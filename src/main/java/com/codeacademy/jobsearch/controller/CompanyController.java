package com.codeacademy.jobsearch.controller;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.service.impl.CompanyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyServiceImpl companyServiceImpl;

    public CompanyController(CompanyServiceImpl companyServiceImpl) {
        this.companyServiceImpl = companyServiceImpl;
    }


    @GetMapping
    public List<CompanyDTO> getAllCompanies() {
        return companyServiceImpl.getAllCompanies();
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompanyById(@PathVariable Long id) {
        return companyServiceImpl.getCompanyById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDTO registerCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        return companyServiceImpl.addCompany(companyDTO);
    }


    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CompanyDTO updateCompany(@RequestBody @Valid CompanyDTO companyDTO) {
        return companyServiceImpl.updateCompany(companyDTO);
    }
}
