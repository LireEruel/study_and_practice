package com.ssafy.valid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MemberDto {
	@NotNull
	private String userName;
	
	@NotBlank
	private String userId;
	private String password;
	private String email;
}
