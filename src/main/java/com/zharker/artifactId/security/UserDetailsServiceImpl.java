package com.zharker.artifactId.security;

import com.zharker.artifactId.entity.User;
import com.zharker.artifactId.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/*

        if(username.equalsIgnoreCase("admin")){
            return new UserInfo("admin","123456","ROLE_ADMIN",true, true, true, true);
        }
*/
        User user = userRepository.findFirstByName(username);

        if(user != null){
            String roles = "";
            if(!CollectionUtils.isEmpty(user.getRoles())){
                roles = user.getRoles().stream().map(r->r.getName()).collect(Collectors.joining(","));
            }
            return new UserInfo(user.getName(), user.getPassword(), roles, true, true, true, true);
        }

        return null;
    }
}
