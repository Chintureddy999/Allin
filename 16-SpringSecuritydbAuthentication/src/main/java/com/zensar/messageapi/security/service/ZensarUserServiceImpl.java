package com.zensar.messageapi.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.messageapi.entity.ZensarUser;
import com.zensar.messageapi.repository.ZensarUserRepository;
@Service
public class ZensarUserServiceImpl implements UserDetailsService {
	@Autowired
	private ZensarUserRepository repo;
    /**
     * Following method is used to  fetch username and password from Db
     */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ZensarUser foundUser =this.repo.findByUsername(username);
		if(foundUser==null)
		{
			throw new UsernameNotFoundException(username);
		}
		User authenticatedUser=new User(foundUser.getUsername(),foundUser.getPassword(),AuthorityUtils.createAuthorityList("Role_User"));
		return authenticatedUser;
	}

}
