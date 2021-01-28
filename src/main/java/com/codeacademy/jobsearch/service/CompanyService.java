package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.User;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.entity.dto.UserDTO;
import com.codeacademy.jobsearch.exceptions.EntityNotFoundException;
import com.codeacademy.jobsearch.repository.CompanyRepository;
import com.codeacademy.jobsearch.service.mapper.EntityToDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    private EntityToDtoMapper entityMapper;

    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(company -> entityMapper.convertCompanyEntityToDTO(company))
                .collect(Collectors.toList());
    }

    public CompanyDTO getCompanyById(Long id){
        return entityMapper.convertCompanyEntityToDTO(getCompanyEntityById(id));
    }


    public Company addCompany(Company company){
        return companyRepository.save(company);
    }


    // TODO: get by company name, update company

    public Company getCompanyEntityById(Long id){
        return companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}
