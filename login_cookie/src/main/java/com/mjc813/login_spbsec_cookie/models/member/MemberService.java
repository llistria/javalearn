package com.mjc813.login_spbsec_cookie.models.member;

import com.mjc813.login_spbsec_cookie.common.Util;
import com.mjc813.login_spbsec_cookie.models.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {
	@Autowired
	private MemberJpaRepository memberJpaRepository;

	// ✅ 비밀번호 인코딩용
	@Autowired
	private PasswordEncoder passwordEncoder;

	// ✅ UserDetailsService 구현 - DaoAuthenticationProvider가 사용
	@Override
	public UserDetails loadUserByUsername(String signId) throws UsernameNotFoundException {
		return this.memberJpaRepository.findBySignId(signId)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + signId));
	}

	public MemberDto insert(MemberDto memberDto, boolean bAdminMode) {
		MemberEntity memberEntity = (MemberEntity)new MemberEntity().clone(memberDto, true);
		memberEntity.setId(null);
		memberEntity.setCreateDt(LocalDateTime.now());
		// ✅ 비밀번호 BCrypt 인코딩 후 저장
		memberEntity.setPassword(passwordEncoder.encode(memberDto.getPassword()));
		if ( bAdminMode ) {
			memberEntity.setIsValidEmail(true);
			memberEntity.setRole(Role.USER.toString());
		} else {
			memberEntity.setIsValidEmail(false);
			memberEntity.setRole(Role.GUEST.toString());
			memberEntity.setValidText(Util.getRandomAllString(12));
		}
		MemberEntity saved = this.memberJpaRepository.save(memberEntity);
		MemberDto result = (MemberDto)new MemberDto().clone(saved, true);
		return result;
	}

	public MemberDto findById(String id) {
		MemberEntity findById = this.memberJpaRepository.findById(Long.parseLong(id)).orElseThrow();
		MemberDto result = (MemberDto)new MemberDto().clone(findById, true);
		return result;
	}

	public MemberDto update(MemberDto updateDto) {
		MemberEntity find = this.memberJpaRepository.findById(updateDto.getId()).orElseThrow();
		MemberEntity memberEntity = (MemberEntity)new MemberEntity().clone(find, true);
		memberEntity.clone(updateDto, false);
		MemberEntity saved = this.memberJpaRepository.save(memberEntity);
		MemberDto result = (MemberDto)new MemberDto().clone(saved, true);
		return result;
	}

	public List<MemberDto> findAll() {
		List<MemberEntity> all = this.memberJpaRepository.findAll();
		List<MemberDto> result = this.transfer(all);
		return result;
	}

	private List<MemberDto> transfer(List<MemberEntity> all) {
		return all.stream()
			.map( x -> (MemberDto)new MemberDto().clone(x, true))
			.toList();
	}

	public MemberDto findBySignId(String signId) {
		Optional<MemberEntity> bySignId = this.memberJpaRepository.findBySignId(signId);
		if ( bySignId.isPresent() ) {
			MemberEntity member = bySignId.get();
			MemberDto result = (MemberDto)new MemberDto().clone(member, true);
			return result;
		} else {
			return null;
		}
	}
}
