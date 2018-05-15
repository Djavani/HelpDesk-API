package com.drgomes.helpdesk.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.drgomes.helpdesk.api.entity.User;
import com.drgomes.helpdesk.api.enums.ProfileEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {
	}
	
	
	// gera um JWT user com base nos dados de um usuario
	public static JwtUser create(User user) {
		return new JwtUser(
				user.getId(),
				user.getEmail(),
				user.getPassword(),
				mapToGrantedAuthorities(user.getProfile())
				);
				
	}
	
	// converte o perfil do usuario em um formato usado no Spring Security
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}

}
