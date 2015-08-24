package org.appfuse.tutorial.dao;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.Contact;

import java.util.List;

public interface ContactDao extends GenericDao<Contact, Long> {
	
    public List<Contact> findByName(String name);
    public Contact createContact(Contact contact);
    public Contact findById(Long id);
    public Contact updateContact(Contact contact);
    public boolean deleteContact(Long id);
    
}