package com.azvtech.companydatasourceservice.service;

import com.azvtech.companydatasourceservice.dto.CompanyRequest;
import com.azvtech.companydatasourceservice.dto.CompanyResponse;
import com.azvtech.companydatasourceservice.exception.ResourceNotFoundException;
import com.azvtech.companydatasourceservice.mapper.CompanyMapper;
import com.azvtech.companydatasourceservice.model.Company;
import com.azvtech.companydatasourceservice.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ICompanyService implements CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    @Override
    public void createCompany(CompanyRequest companyRequest) {
        Company mappedCompany = mapper.companyDtoToCompanyDao(companyRequest);
        repository.save(mappedCompany);
        log.info("Company {} is saved", mappedCompany.getId());

    }

    @Override
    public void updateCompany(CompanyRequest company, Long companyId) {
        Company findCompany = repository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company", "Id", companyId));
        findCompany.setAddress(company.getAddress());
        findCompany.setCnpj(company.getCnpj());
        findCompany.setSite(company.getSite());
        findCompany.setName(company.getName());
        findCompany.setEmail(company.getEmail());
        findCompany.setTel(company.getTel());
        repository.save(findCompany);
        log.info("Company {} is updated", findCompany.getId());
    }

    @Override
    public CompanyResponse getCompanyById(Long companyId) {
        Company findCompany = repository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company", "Id", companyId));
        return mapper.companyDaoToCompanyDto(findCompany);
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        List<Company> companies = repository.findAll();
        return mapper.toCompanyDtoList(companies);
    }

    @Override
    public void deleteCompany(Long companyId) {
        Company findCompany = repository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company", "Id", companyId));
        repository.deleteById(companyId);
        log.info("Company {} is deleted", findCompany.getId());

    }
}
