package org.appfuse.tutorial.dao;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.Contact;
import org.appfuse.tutorial.model.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

import static org.junit.Assert.*;

public class MenuDaoTest extends BaseDaoTestCase {
    @Autowired
    private MenuDao menuDao;

    @Test
    public void testFindMenuByComida() throws Exception {
    	Menu menu = new Menu();
    	menu.setComida("gallo pinto");
    	
    	menuDao.save(menu);
        flush();
    	
        List<Menu> menus = menuDao.findByComida("gallo pinto");
        assertTrue(menus.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMenu() throws Exception {
        Menu menu = new Menu();
        menu.setComida("papas");

        menu = menuDao.save(menu);
        flush();

        menu = menuDao.get(menu.getId());

        assertEquals("papas", menu.getComida());
        assertNotNull(menu.getId());

        log.debug("removing menu...");

        menuDao.remove(menu.getId());
        flush();

        // should throw DataAccessException
        menuDao.get(menu.getId());
    }
}