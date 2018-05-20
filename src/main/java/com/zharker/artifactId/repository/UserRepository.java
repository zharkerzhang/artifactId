package com.zharker.artifactId.repository;

import com.zharker.artifactId.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByIdAndName(Long id, String name);

    public List<User> findByName(String name);

    public User findFirstByName(String username);
}
