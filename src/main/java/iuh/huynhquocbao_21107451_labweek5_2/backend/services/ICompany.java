package iuh.huynhquocbao_21107451_labweek5_2.backend.services;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Company;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICompany {
    public Company findFirstCompany();
    public Company findCompanyByCompName(String name);
    public List<Company> findAll();
    public Company find(Long id);
    public Company findCompanyByUserName(String userName);
}
