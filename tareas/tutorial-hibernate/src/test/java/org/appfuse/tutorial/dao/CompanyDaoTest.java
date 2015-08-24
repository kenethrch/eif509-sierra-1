package org.appfuse.tutorial.dao;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

import static org.junit.Assert.*;

public class CompanyDaoTest extends BaseDaoTestCase {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testFindCompanyByName() throws Exception {
    	Company company = new Company();
    	company.setName("Apple");
    	
    	company = companyDao.save(company);
        flush();
    	
        List<Company> companies = companyDao.findByName(company.getName());
        assertTrue(companies.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveCompany() throws Exception {
    	Company company = new Company();
        company.setName("Google");

        company = companyDao.createCompany(company);
        flush();

        company = companyDao.get(company.getId());

        assertEquals("Google", company.getName());
        assertNotNull(company.getId());

        log.debug("removing company...");

        companyDao.deleteCompany(company.getId());
        flush();

        // should throw DataAccessException
        companyDao.get(company.getId());
    }
    
    @Test(expected=DataAccessException.class)
    public void testFindAndUpdateCompany() throws Exception {
    	Company company = new Company();
        company.setName("Samsung");

        company = companyDao.save(company);
        flush();

        // Testing findById
        company = companyDao.findById(company.getId());

        assertEquals("Samsung", company.getName());
        assertNotNull(company.getId());

        company.setName("Microsoft");
        companyDao.updateCompany(company);
        
        // Testing updateCompany
        assertTrue(companyDao.findByName("Microsoft").size() > 0);
    }
    
}