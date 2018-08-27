package org.com.service;

import java.util.*;
import javax.inject.Inject;
import org.com.vo.*;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
	
	@Inject
	private UserDetailsManager userDetailsManager;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void create(UserVO vo) throws Exception {
		System.out.println("before = "+vo.getUpw());
		vo.setUpw(passwordEncoder.encode(vo.getUpw()));
		System.out.println("after = "+vo.getUpw());

		UserDetails user = new User(vo.getUid(), vo.getUpw(), Arrays.asList(new SimpleGrantedAuthority("USER")));
		System.out.println(user.getAuthorities());
	}
}