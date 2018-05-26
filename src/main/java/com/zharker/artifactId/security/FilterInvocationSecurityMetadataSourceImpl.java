package com.zharker.artifactId.security;

import com.zharker.artifactId.entity.RoleResourceAction;
import com.zharker.artifactId.repository.ResourceRepository;
import com.zharker.artifactId.repository.RoleResourceActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleResourceActionRepository roleResourceActionRepository;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String url = ((FilterInvocation) o).getRequestUrl();
        return getRolesByResourceUrl(url);
    }

    private Collection<ConfigAttribute> getRolesByResourceUrl(String url) {

        List<RoleResourceAction> rraList = roleResourceActionRepository.findByResource_url(url);
        if(CollectionUtils.isEmpty(rraList)){
            return null;
        }
        return rraList.stream().map(rra->rra.getRole().getName()).distinct().map(SecurityConfig::new).collect(Collectors.toList());
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
