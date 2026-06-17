package com.example.spring_sec.models.auth;

import com.example.spring_sec.models.member.IMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto implements IMember {
	@JsonIgnore
	private Long id;

	private String signId;
	private String password;
	private String email;

	@JsonIgnore
	private String role;

	@JsonIgnore
	private Boolean isValidEmail;

	@JsonIgnore
	private String validText;

	@JsonIgnore
	private LocalDateTime createDt;

	@JsonIgnore
	private LocalDateTime updateDt;

	@JsonIgnore
	private LocalDateTime deleteDt;
}
