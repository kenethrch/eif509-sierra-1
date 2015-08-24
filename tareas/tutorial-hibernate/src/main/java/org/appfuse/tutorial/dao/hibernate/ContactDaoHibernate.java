package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.ContactDao;
import org.appfuse.tutorial.model.Contact;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("contactDao")
public class ContactDaoHibernate extends GenericDaoHibernate<Contact, Long> implements ContactDao {

	public ContactDaoHibernate() {
		super(Contact.class);
	}
	
	@Override
	public List<Contact> findByName(String name) {
		return getSession().createCriteria(Contact.class).add(Restrictions.eq("name", name)).list();
	}

	@Override
	public Contact createContact(Contact contact) {
		getSession().save(contact);
		return contact;
	}

	@Override
	public Contact findById(Long id) {
		Contact contact = null;
		
		if (id != null) {
			Criteria criteria = getSession().createCriteria(Contact.class);
			criteria.add(Restrictions.eq("id", id));
			
			contact = (Contact) criteria.uniqueResult();
		}
		
		return contact;
	}

	@Override
	public Contact updateContact(Contact contact) {
		if (contact != null) {
			getSession().update(contact);
		}
		
		return contact;
	}

	@Override
	public boolean deleteContact(Long id) {
		if (id != null) {
			getSession().delete(id);
			return true;
		}
		
		return false;
	}

}
