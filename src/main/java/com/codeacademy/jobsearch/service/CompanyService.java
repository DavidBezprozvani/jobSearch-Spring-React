package com.codeacademy.jobsearch.service;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.exceptions.EntityNotFoundException;
import com.codeacademy.jobsearch.repository.CompanyRepository;
import com.codeacademy.jobsearch.service.mapper.DtoMapper;
import com.codeacademy.jobsearch.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    private EntityMapper entityMapper;
    private DtoMapper dtoMapper;

    public CompanyService(CompanyRepository companyRepository, EntityMapper entityMapper, DtoMapper dtoMapper) {
        this.companyRepository = companyRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

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


    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        Long id = companyDTO.getId();
        if (id == null) {
            throw new EntityNotFoundException(id);
        }
        Company company = getCompanyEntityById(id);
        company.setId(companyDTO.getId());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setRegistrationCode(companyDTO.getRegistrationCode());
        company.setAddress(companyDTO.getAddress());
        company.setCompanyUrl(companyDTO.getCompanyUrl());
        company.setLogoUrl(companyDTO.getLogoUrl());
        return entityMapper.convertCompanyEntityToDTO(company);
    }



    // TODO: get by company name, update company

    public Company getCompanyEntityById(Long id){
        return companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}
