package com.ivansaprykin.dao;

import com.ivansaprykin.model.User;
import com.ivansaprykin.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao extends AbstractDao {

    private Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void saveUser(User user) {
        save(user);
    }

    public void updateUser(User user) {
        update(user);
    }

    public void deleteUser(User user) {
        delete(user);
    }

    public User getUserById(int userId) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", userId));
        User user = (User) criteria.uniqueResult();
        session.getTransaction().commit();
        return user;
    }

    public List<User> getAllUsers() {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> specializations = (List<User>) criteria.list();
        session.getTransaction().commit();
        return specializations;
    }

    public User getUserByLogin(String userLogin) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("login", userLogin));
        User user = (User) criteria.uniqueResult();
        session.getTransaction().commit();
        return user;
    }
}
