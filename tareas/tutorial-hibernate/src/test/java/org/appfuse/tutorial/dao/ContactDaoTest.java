package org.appfuse.tutorial.dao;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.Contact;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

import static org.junit.Assert.*;

public class ContactDaoTest extends BaseDaoTestCase {
    @Autowired
    private ContactDao contactDao;

    @Test
    public void testFindContactByName() throws Exception {
    	Contact contact = new Contact();
    	contact.setName("Fulano");
    	
    	contact = contactDao.save(contact);
        flush();
    	
        List<Contact> contacts = contactDao.findByName(contact.getName());
        assertTrue(contacts.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveContact() throws Exception {
    	Contact contact = new Contact();
        contact.setName("Mengano");

        contact = contactDao.createContact(contact);
        flush();

        contact = contactDao.get(contact.getId());

        assertEquals("Mengano", contact.getName());
        assertNotNull(contact.getId());

        log.debug("removing contact...");

        contactDao.deleteContact(contact.getId());
        flush();

        // should throw DataAccessException
        contactDao.get(contact.getId());
    }
    
    @Test(expected=DataAccessException.class)
    public void testFindAndUpdateContact() throws Exception {
    	Contact contact = new Contact();
    	contact.setName("Zutano");

    	contact = contactDao.save(contact);
        flush();

        // Testing findById
        contact = contactDao.findById(contact.getId());

        assertEquals("Zutano", contact.getName());
        assertNotNull(contact.getId());

        contact.setName("Fulano 2");
        contactDao.updateContact(contact);
        
        // Testing updateCompany
        assertTrue(contactDao.findByName("Fulano 2").size() > 0);
    }
    
}