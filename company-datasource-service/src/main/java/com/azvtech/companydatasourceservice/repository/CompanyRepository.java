package com.azvtech.companydatasourceservice.repository;

import com.azvtech.companydatasourceservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fellipe Toledo
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
