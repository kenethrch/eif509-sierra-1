package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.CompanyDao;
import org.appfuse.tutorial.model.Company;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("companyDao")
public class CompanyDaoHibernate extends GenericDaoHibernate<Company, Long> implements CompanyDao {

	public CompanyDaoHibernate() {
		super(Company.class);
	}
	
	@Override
	public List<Company> findByName(String name) {
		return getSession().createCriteria(Company.class).add(Restrictions.eq("name", name)).list();
	}

	@Override
	public Company createCompany(Company company) {
		getSession().save(company);
		return company;
	}

	@Override
	public Company findById(Long id) {
		Company company = null;
		
		if (id != null) {
			Criteria criteria = getSession().createCriteria(Company.class);
			criteria.add(Restrictions.eq("id", id));
			
			company = (Company) criteria.uniqueResult();
		}
		
		return company;
	}

	@Override
	public Company updateCompany(Company company) {
		if (company != null) {
			getSession().update(company);
		}
		
		return company;
	}

	@Override
	public boolean deleteCompany(Long id) {
		if (id != null) {
			getSession().delete(id);
			return true;
		}
		
		return false;
	}

}
