package com.zharker.artifactId.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zharker.artifactId")
public class ArtifactIdApplication {
    public static void main(String[] args){
        SpringApplication.run(ArtifactIdApplication.class, args);
    }
}
