package com.naik.dao;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class CustomHibernateDaoSupport extends HibernateDaoSupport
{
    @Autowired
    public void setConnection(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }

    public void save(Object model) {
        getHibernateTemplate().save(model);
    }

    public void update(Object model) {
        getHibernateTemplate().update(model);
    }

    public void delete(Object model) {
        getHibernateTemplate().delete(model);
    }

    public void saveAll(List models) {
        models.forEach(model->getHibernateTemplate().save(model));
    }

    public Object get(String entityName, Serializable id) {
        return getHibernateTemplate().get(entityName, id);
    }

    public Object find(String queryString, Object... values) {
        return getHibernateTemplate().find(queryString, values);
    }

    public List findFirstFew(Class entity, int count) {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(entity), 0, count);
    }

    public List findFew(Class entity, int firstResult, int count) {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(entity), firstResult, count);
    }

}
