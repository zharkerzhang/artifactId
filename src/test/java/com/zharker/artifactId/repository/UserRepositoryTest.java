package com.zharker.artifactId.repository;

import com.zharker.artifactId.config.ArtifactIdApplication;
import com.zharker.artifactId.config.ArtifactIdApplicationTest;
import com.zharker.artifactId.config.JpaConfiguration;
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

    @Test
    public void baseTest(){
        String name = "user";
        List<?> userList = this.userRepository.findByName(name);
        Assert.notNull(userList,"user list not null");
    }
}
