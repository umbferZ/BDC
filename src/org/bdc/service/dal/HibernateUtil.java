/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.dal
 * Type: HibernateUtil
 * Last update: 12-mar-2017 16.24.09
 * 
 */

package org.bdc.service.dal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * The Class HibernateUtil.
 */
public class HibernateUtil {

    private static final SessionFactory concreteSessionFactory;
    static {
        try {
            concreteSessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Close session.
     */
    public static void closeSession() {
        concreteSessionFactory.getCurrentSession().close();
    }

    /**
     * Gets the session.
     *
     * @return the session
     * @throws HibernateException the hibernate exception
     */
    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }
}