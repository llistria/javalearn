package com.example.login_ses.biz;

import com.example.login_ses.common.ComResponseDto;
import com.example.login_ses.common.LoginException;
import com.example.login_ses.common.ResponseCode;
import com.example.login_ses.models.auth.SignInDto;
import com.example.login_ses.models.auth.SignUpDto;
import com.example.login_ses.models.auth.ValidEmailDto;
import com.example.login_ses.models.member.MemberDto;
import com.example.login_ses.models.member.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class SessionSignRestController {

	private static final String SESSION_KEY = "MJC_LOGIN"; // 세션 키 상수화

	@Autowired
	private MemberService memberService;

	@Autowired
	private AuthService authService;


	// ─── 이메일 테스트 (변경 없음) ───────────────────────────────────────────────
	@GetMapping("/emailtest/{id}")
	public ResponseEntity<ComResponseDto<MemberDto>> emailTest(@PathVariable String id) {

		MemberDto find = this.memberService.findById(id);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, find)
		);
	}


	// ─── 이메일 인증 확인 GET ────────────────────────────────────────────────────
	@GetMapping("/checkvalidemail")
	public ResponseEntity<ComResponseDto<Boolean>> checkvalidemailGet(
			@RequestParam("signId") String signId,
			@RequestParam("validText") String validText) {

		Boolean isValid = this.checkValid(signId, validText);
		if (isValid) {
			return ResponseEntity.ok(ComResponseDto.make(ResponseCode.SUCCESS, true));
		} else {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR, false)
			);
		}
	}


	// ─── 이메일 인증 확인 POST ───────────────────────────────────────────────────
	@PostMapping("/checkvalidemail")
	public ResponseEntity<ComResponseDto<Boolean>> checkvalidemailPost(
			@RequestBody ValidEmailDto validEmailDto) {

		Boolean isValid = this.authService.checkValidEmail(validEmailDto);
		if (isValid) {
			return ResponseEntity.ok(ComResponseDto.make(ResponseCode.SUCCESS, true));
		} else {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR, false)
			);
		}
	}

	private Boolean checkValid(String signId, String validText) {
		ValidEmailDto dto = ValidEmailDto.builder()
				.signId(signId)
				.validText(validText)
				.build();
		return this.authService.checkValidEmail(dto);
	}


	// ─── 로그인 (쿠키 → 세션으로 변경) ─────────────────────────────────────────
	@PostMapping("/signin")
	public ResponseEntity<ComResponseDto<Boolean>> signin(
			@RequestBody SignInDto signInDto,
			HttpServletRequest request) throws LoginException {

		Boolean isSign = this.authService.signMember(signInDto);

		if (isSign) {
			// 기존 세션 무효화 후 새 세션 생성 (세션 고정 공격 방지)
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}

			HttpSession session = request.getSession(true); // 새 세션 생성
			session.setAttribute(SESSION_KEY, signInDto.getSignId()); // 사용자 ID 저장
			session.setMaxInactiveInterval(3600); // 1시간 비활동 시 만료

			log.info("로그인 성공 - sessionId: {}, signId: {}", session.getId(), signInDto.getSignId());

			return ResponseEntity.ok(ComResponseDto.make(ResponseCode.SUCCESS, true));
		} else {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR, false)
			);
		}
	}


	// ─── 로그아웃 (쿠키 만료 → 세션 무효화로 변경) ─────────────────────────────
	@GetMapping("/signout")
	public ResponseEntity<ComResponseDto<Boolean>> signout(HttpServletRequest request) {

		HttpSession session = request.getSession(false); // 세션 없으면 null
		if (session != null) {
			log.info("로그아웃 - sessionId: {}", session.getId());
			session.invalidate(); // 세션 전체 파기
		}

		return ResponseEntity.ok(ComResponseDto.make(ResponseCode.SUCCESS, true));
	}


	// ─── 현재 로그인 상태 확인 (추가 기능) ──────────────────────────────────────
	@GetMapping("/me")
	public ResponseEntity<ComResponseDto<String>> me(HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			String signId = (String) session.getAttribute(SESSION_KEY);
			if (signId != null) {
				return ResponseEntity.ok(ComResponseDto.make(ResponseCode.SUCCESS, signId));
			}
		}

		return ResponseEntity.status(401).body(
				ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR, null)
		);
	}
}