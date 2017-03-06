package org.bdc.model.e;

import org.bdc.model.e.dao.E1Dao;
import org.bdc.model.e.dao.E2Dao;
import org.bdc.model.e.dao.E3Dao;

public class FactoryDao {

    private static FactoryDao instance = null;

    private FactoryDao() {

    }

    public static FactoryDao getInstance() {
        if (instance == null)
            instance = new FactoryDao();
        return instance;
    }

    public E1Dao getE1Dao() {
        return new E1Dao();
    }

    public E2Dao getE2Dao() {
        return new E2Dao();
    }

    public E3Dao getE3Dao() {
        return new E3Dao();
    }
}
