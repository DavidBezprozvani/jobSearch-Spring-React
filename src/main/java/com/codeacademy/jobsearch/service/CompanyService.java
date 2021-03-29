package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> getAllCompanies();

    CompanyDTO getCompanyById(Long id);

    CompanyDTO addCompany(CompanyDTO companyDTO);

    CompanyDTO updateCompany(CompanyDTO companyDTO);

    void deleteCompany(Long id);
}
