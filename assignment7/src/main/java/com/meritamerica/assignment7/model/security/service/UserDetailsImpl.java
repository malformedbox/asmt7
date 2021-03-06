package com.meritamerica.assignment7.model.security.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meritamerica.assignment7.model.User;

public class UserDetailsImpl implements UserDetails {
	
	private Long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl() {}
	public UserDetailsImpl(Long id, String username, String password,
							String role) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
    public UserDetailsImpl(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
  
    }
	
	public static UserDetailsImpl build(User user) {
		
		return new UserDetailsImpl(
				user.getId(),
				user.getUsername(),
				user.getPassword(),
				user.getRole()
				);
	}

	public Long getId() { return id; }
	
	@Override
	public String getPassword() { return password; }

	@Override
	public String getUsername() { return username; }

	@Override
	public boolean isAccountNonExpired() { return true;	}

	@Override
	public boolean isAccountNonLocked() { return true; }

	@Override
	public boolean isCredentialsNonExpired() { return true; }

	@Override
	public boolean isEnabled() { return true; }
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
