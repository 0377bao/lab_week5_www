package iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Company;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.CompanyRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.ICompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompany {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Company findFirstCompany() {
        return companyRepository.findById(1l).orElse(null);
    }

    @Override
    public Company findCompanyByCompName(String name) {
        return companyRepository.findCompanyByCompName(name);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company find(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company findCompanyByUserName(String userName) {
        return companyRepository.findCompanyByUserName(userName);
    }


}
