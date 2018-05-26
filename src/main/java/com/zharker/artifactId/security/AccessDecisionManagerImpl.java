package com.zharker.artifactId.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

@Service
public class AccessDecisionManagerImpl implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if(CollectionUtils.isEmpty(collection)){
            return ;
        }

        boolean canAccess = authentication.getAuthorities().stream().map(auth->auth.getAuthority())
                .anyMatch(userRoleName->{
                    return collection.stream().map(attr->attr.getAttribute()).anyMatch(resourceRoleName->resourceRoleName.equals(userRoleName));
                });
        if(!canAccess){
            System.out.println(authentication.getPrincipal());
            System.out.println(o.toString());
            throw new AccessDeniedException("no right");
        }

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
