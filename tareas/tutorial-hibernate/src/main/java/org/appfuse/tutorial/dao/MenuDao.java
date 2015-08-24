package org.appfuse.tutorial.dao;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.Menu;

import java.util.List;

public interface MenuDao extends GenericDao<Menu, Long> {
    public List<Menu> findByComida(String comida);
}