package com.zharker.artifactId.repository;

import com.zharker.artifactId.entity.RoleResourceAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleResourceActionRepository extends JpaRepository<RoleResourceAction, Long> {

    public List<RoleResourceAction> findByRole_id(Long roldId);

    public List<RoleResourceAction> findByResource_url(String url);
}
