package com.azvtech.companydatasourceservice.mapper;

import com.azvtech.companydatasourceservice.dto.CompanyRequest;
import com.azvtech.companydatasourceservice.dto.CompanyResponse;
import com.azvtech.companydatasourceservice.model.Company;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fellipe Toledo
 */
@Component
@RequiredArgsConstructor
public class CompanyMapper {
    private final ModelMapper mapper;

    public CompanyResponse companyDaoToCompanyDto(Company company) {
        return mapper.map(company, CompanyResponse.class);
    }
    public Company companyDtoToCompanyDao(CompanyRequest company) {
        return mapper.map(company, Company.class);
    }

    public List<CompanyResponse> toCompanyDtoList(List<Company> companies) {
        return companies.stream().map(this::companyDaoToCompanyDto)
                .collect(Collectors.toList());
    }
}
