package com.codeacademy.jobsearch.service.impl;

import com.codeacademy.jobsearch.entity.Company;
import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.dto.CompanyDTO;
import com.codeacademy.jobsearch.exceptions.EntityNotFoundException;
import com.codeacademy.jobsearch.repository.CompanyRepository;
import com.codeacademy.jobsearch.service.CompanyService;
import com.codeacademy.jobsearch.service.mapper.DtoMapper;
import com.codeacademy.jobsearch.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private EntityMapper entityMapper;
    private DtoMapper dtoMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, EntityMapper entityMapper, DtoMapper dtoMapper) {
        this.companyRepository = companyRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(company -> entityMapper.convertCompanyEntityToDTO(company))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getCompanyById(Long id) {
        Company company = companyRepository.getOne(id);
        return entityMapper.convertCompanyEntityToDTO(company);
    }

    @Override
    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        Company company = dtoMapper.convertCompanyDtoToEntity(companyDTO);
        Company savedCompany = companyRepository.save(company);
        return entityMapper.convertCompanyEntityToDTO(savedCompany);
    }

    @Override
    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        Long id = companyDTO.getId();
        if (companyRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        Company company = companyRepository.getOne(id);
        company.setId(companyDTO.getId());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setRegistrationCode(companyDTO.getRegistrationCode());
        company.setAddress(companyDTO.getAddress());
        company.setCompanyUrl(companyDTO.getCompanyUrl());
        company.setLogoUrl(companyDTO.getLogoUrl());
        return entityMapper.convertCompanyEntityToDTO(company);
    }

    @Override
    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        companyRepository.deleteById(id);

    }
}
