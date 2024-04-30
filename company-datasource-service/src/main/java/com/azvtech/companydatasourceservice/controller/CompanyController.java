package com.azvtech.companydatasourceservice.controller;

import com.azvtech.companydatasourceservice.dto.CompanyRequest;
import com.azvtech.companydatasourceservice.dto.CompanyResponse;
import com.azvtech.companydatasourceservice.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("/api/v1/rioonibus-datasource/company")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {
    private final CompanyService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCompany(
            @Valid
            @RequestBody
            CompanyRequest company) {
        service.createCompany(company);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCompany(
            @Valid
            @RequestBody
            CompanyRequest company,
            @PathVariable("id") long id) {
        this.service.updateCompany(company, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCompany(
            @PathVariable("id")
            long id) {
        this.service.deleteCompany(id);

    }

    @GetMapping("/all")
    public List<CompanyResponse> getAllCompanies() {
        return service.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(
            @PathVariable
            long id) {
        return ResponseEntity.ok(this.service.getCompanyById(id));
    }
}
