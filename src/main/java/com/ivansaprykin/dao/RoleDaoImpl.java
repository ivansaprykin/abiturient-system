package com.ivansaprykin.dao;

import com.ivansaprykin.model.Role;
import com.ivansaprykin.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RoleDaoImpl extends AbstractDao {

    private Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void saveRole(Role role) {
        save(role);
    }

    public void updateRole(Role role) {
        update(role);
    }

    public void deleteRole(Role role) {
        delete(role);
    }

    public Role getRoleById(int roleId) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Role.class);
        criteria.add(Restrictions.eq("id", roleId));
        Role enrollee = (Role) criteria.uniqueResult();
        session.getTransaction().commit();
        return enrollee;
    }
}
