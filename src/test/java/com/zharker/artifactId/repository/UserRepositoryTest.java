package com.zharker.artifactId.repository;

import com.zharker.artifactId.config.ArtifactIdApplication;
import com.zharker.artifactId.config.ArtifactIdApplicationTest;
import com.zharker.artifactId.config.JpaConfiguration;
import com.zharker.artifactId.entity.Role;
import com.zharker.artifactId.entity.RoleResourceAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={ArtifactIdApplication.class, JpaConfiguration.class})
public class UserRepositoryTest{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleResourceActionRepository roleResourceActionRepository;

    @Test
    public void baseTest(){
        List<RoleResourceAction> ls = this.roleResourceActionRepository.findByRole_id(5L);
        org.junit.Assert.assertNotNull(ls);
        ls.forEach(rra->System.out.println(rra.getRole().getName()+" "+ rra.getAction().getType()+" "+rra.getResource().getUrl()));


    }
}
