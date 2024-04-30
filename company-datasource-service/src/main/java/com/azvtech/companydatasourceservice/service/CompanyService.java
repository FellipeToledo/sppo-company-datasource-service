package com.azvtech.companydatasourceservice.service;

import com.azvtech.companydatasourceservice.dto.CompanyRequest;
import com.azvtech.companydatasourceservice.dto.CompanyResponse;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
public interface CompanyService {
    void createCompany(CompanyRequest company);
    void updateCompany(CompanyRequest company, Long companyId);
    CompanyResponse getCompanyById(Long companyId);
    List<CompanyResponse> getAllCompanies();
    void deleteCompany(Long companyId);
}
