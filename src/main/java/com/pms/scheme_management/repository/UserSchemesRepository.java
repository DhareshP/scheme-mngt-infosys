package com.pms.scheme_management.repository;

import com.pms.scheme_management.model.Scheme;
import com.pms.scheme_management.model.UserSchemes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSchemesRepository extends JpaRepository<UserSchemes , Long> {

    List<UserSchemes> findByUserId(int userId);

        @Query("SELECT s FROM Scheme s WHERE s.schemeIsActive = true")
        List<Scheme> findActiveSchemes();

        @Query("SELECT us FROM UserSchemes us JOIN FETCH us.userId JOIN FETCH us.scheme")
        List<UserSchemes>findAllByUserSchemes();

}
