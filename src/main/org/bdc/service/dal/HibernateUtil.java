/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.dal
 * Type: HibernateUtil
 * Last update: 12-set-2017 17.32.01
 * 
 */

package main.org.bdc.service.dal;

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
        if (concreteSessionFactory.isClosed())
            concreteSessionFactory.getCurrentSession().close();
    }

    /**
     * Gets the session.
     *
     * @return the session
     * @throws HibernateException the hibernate exception
     */
    public static Session getSession() throws HibernateException {
        // if (concreteSessionFactory.isOpen())
        // return concreteSessionFactory.getCurrentSession();
        return concreteSessionFactory.openSession();
    }
}