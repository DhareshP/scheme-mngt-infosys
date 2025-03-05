package com.pms.scheme_management.repository;

import com.pms.scheme_management.model.UserSchemes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSchemesRepository extends JpaRepository<UserSchemes , Long> {

    List<UserSchemes> findByUserId(int userId);
}
