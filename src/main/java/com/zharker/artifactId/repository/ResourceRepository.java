package com.zharker.artifactId.repository;

import com.zharker.artifactId.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
