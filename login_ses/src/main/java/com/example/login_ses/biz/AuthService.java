package com.example.login_ses.biz;

import com.example.login_ses.common.LoginException;
import com.example.login_ses.models.auth.SignInDto;
import com.example.login_ses.models.auth.ValidEmailDto;
import com.example.login_ses.models.member.MemberEntity;
import com.example.login_ses.models.member.MemberJpaRepository;
import com.example.login_ses.models.member.MemberService;
import com.example.login_ses.models.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	@Autowired
	private MemberJpaRepository memberJpaRepository;

	public Boolean checkValidEmail(ValidEmailDto validEmailDto) {
		MemberEntity find = this.memberJpaRepository.findBySignId(validEmailDto.getSignId()).orElseThrow();
		if ( validEmailDto.getValidText().equals(find.getValidText()) ) {
			find.setIsValidEmail(true);
			find.setRole(Role.USER.toString());
			this.memberJpaRepository.save(find);
			return true;
		} else {
			return false;
		}
	}

	public Boolean signMember(SignInDto signInDto) throws LoginException {
		MemberEntity find = this.memberJpaRepository.findBySignId(signInDto.getSignId()).orElseThrow();
		if ( !find.getIsValidEmail() ) {
			throw new LoginException("not valid email");
		}
		if ( find.getRole().equals(Role.GUEST.toString()) ) {
			throw new LoginException("doesn't need login");
		}
		if ( signInDto.getPassword().equals(find.getPassword()) ) {
			return true;
		}
		return false;
	}
}
