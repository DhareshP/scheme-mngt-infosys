package com.pms.scheme_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pms.scheme_management.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {
}
