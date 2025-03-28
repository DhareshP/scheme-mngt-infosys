package com.pms.scheme_management.repository;

import com.pms.scheme_management.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Integer> {

    List<Policy> findBySchemeId(int schemeId);
}
