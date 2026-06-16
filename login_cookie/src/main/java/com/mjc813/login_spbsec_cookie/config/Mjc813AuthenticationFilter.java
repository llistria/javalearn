package com.mjc813.login_spbsec_cookie.config;

import com.mjc813.login_spbsec_cookie.models.member.IMember;
import com.mjc813.login_spbsec_cookie.models.member.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class Mjc813AuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private MemberService memberService;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain) throws ServletException, IOException {
		try {
			if (request.getMethod().equals("OPTIONS")) {
				filterChain.doFilter(request, response);
				return;
			}

			// ✅ 세션이 아닌 쿠키에서 signId 추출
			String signId = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("MJC_LOGIN".equals(cookie.getName())) {
						signId = cookie.getValue();
						break;
					}
				}
			}

			if (signId != null && !signId.isBlank()) {
				IMember signedMember = this.memberService.findBySignId(signId);
				if (signedMember != null) {
					UsernamePasswordAuthenticationToken authentication =
							new UsernamePasswordAuthenticationToken(
									signedMember, null, signedMember.getAuthorities()
							);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception ex) {
			log.error("user authentication error : " + ex.toString());
		}
		filterChain.doFilter(request, response);
	}
}
