package com.kura.example.domain.service.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.kura.example.domain.model.User;

public class ReservationUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private final User user;
	
	public ReservationUserDetails(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("ROLE_" + this.user.getRoleName().name());
	}
	
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return this.user.getUserId();
	}
	
	//アカウント期限切れに関するプロパティは使用しない
	@Override
	public boolean isAccountNonExpired() {
		return  true;
	}
	
	//アカウントロックに関するプロパティは使用しない
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//パスワード有効期限切れに関するプロパティは使用しない
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//アカウント無効化に関するプロパティは使用しない
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
