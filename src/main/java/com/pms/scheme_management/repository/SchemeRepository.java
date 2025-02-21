package com.pms.scheme_management.repository;

import com.pms.scheme_management.model.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Integer> {
}