package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.MenuDao;
import org.appfuse.tutorial.model.Menu;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("menuDao")
public class MenuDaoHibernate extends GenericDaoHibernate<Menu, Long> implements MenuDao {

    public MenuDaoHibernate() {
        super(Menu.class);
    }

    public List<Menu> findByComida(String comida) {
        return getSession().createCriteria(Menu.class).add(Restrictions.eq("comida", comida)).list();
    }
    
}