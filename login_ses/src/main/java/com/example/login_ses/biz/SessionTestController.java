package com.example.login_ses.biz;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionTestController {

	// 세션 생성
	@GetMapping("/session/make")
	public String make(HttpServletRequest request,
					   @RequestParam("name") String name,
					   @RequestParam("value") String value,
					   Model model)
	{
		HttpSession session = request.getSession(true); // true: 없으면 새로 생성
		session.setAttribute(name, value);
		session.setMaxInactiveInterval(120); // 120초 후 만료

		model.addAttribute("session_id", session.getId());
		model.addAttribute("session_name", name);
		model.addAttribute("session_value", value);
		model.addAttribute("session_time", session.getMaxInactiveInterval());
		return "info/info";
	}

	// 세션 조회
	@GetMapping("/session/get")
	public String get(HttpServletRequest request,
					  @RequestParam("name") String name,
					  Model model)
	{
		HttpSession session = request.getSession(false); // false: 없으면 null 반환

		if (session != null) {
			Object value = session.getAttribute(name);
			model.addAttribute("session_id", session.getId());
			model.addAttribute("session_name", name);
			model.addAttribute("session_value", value != null ? value : "존재하지 않는 키");
			model.addAttribute("session_time", session.getMaxInactiveInterval());
		} else {
			model.addAttribute("session_value", "세션이 존재하지 않습니다.");
		}
		return "info/info";
	}

	// 세션 삭제 (특정 속성만)
	@GetMapping("/session/delete")
	public String delete(HttpServletRequest request,
						 @RequestParam("name") String name,
						 Model model)
	{
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.removeAttribute(name); // 특정 키만 제거
			model.addAttribute("session_id", session.getId());
			model.addAttribute("session_value", "삭제 완료: " + name);
		} else {
			model.addAttribute("session_value", "세션이 존재하지 않습니다.");
		}
		return "info/info";
	}

	// 세션 전체 무효화
	@GetMapping("/session/invalidate")
	public String invalidate(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate(); // 세션 전체 파기
			model.addAttribute("session_value", "세션이 완전히 종료되었습니다.");
		} else {
			model.addAttribute("session_value", "이미 세션이 없습니다.");
		}
		return "info/info";
	}
}