package org.appfuse.tutorial.dao;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.Company;

import java.util.List;

public interface CompanyDao extends GenericDao<Company, Long> {
	
    public List<Company> findByName(String name);
    public Company createCompany(Company company);
    public Company findById(Long id);
    public Company updateCompany(Company company);
    public boolean deleteCompany(Long id);
    
}