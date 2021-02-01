package com.codeacademy.jobsearch.controller;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company registerCompany(@Valid @RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping
    public List<CompanyDTO> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    // TODO: get by company name, update company

}
