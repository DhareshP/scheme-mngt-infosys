package com.pms.scheme_management.repository;

import com.pms.scheme_management.model.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Integer> {

    List<Scheme> findBySchemeIsActiveIsTrue();

    List<Scheme> findSchemeBySchemeName(String schemeName);

    List<Scheme> findSchemeBySchemeNameAndSchemeIsActiveIsTrue(String schemeName);

    @Query("SELECT s FROM Scheme s WHERE LOWER(REPLACE(s.schemeName, ' ', '')) LIKE LOWER(REPLACE(CONCAT('%', :schemeName, '%'), ' ', '')) AND s.schemeIsActive = true")
    List<Scheme> searchBySchemeNameFlexible(@Param("schemeName") String schemeName);}