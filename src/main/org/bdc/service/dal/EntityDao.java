/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.dal
 * Type: EntityDao
 * Last update: 20-set-2017 13.23.22
 * 
 */

package main.org.bdc.service.dal;

import java.io.Serializable;
import java.util.List;

import main.org.bdc.service.dal.exception.SaveDalException;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;
import main.org.bdc.service.dal.exception.UpdateDalException;

/**
 * The Interface EntityDao.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface EntityDao<T, ID extends Serializable> {

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(T entity);

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<T> getAll();

    /**
     * Gets the by example.
     *
     * @param exampleInstance the example instance
     * @param excludeProperty the exclude property
     * @return the by example
     */
    @Deprecated
    public List<T> getByExample(T exampleInstance, String[] excludeProperty);

    /**
     * Gets the by id.
     *
     * @param id the id
     * @param lock the lock
     * @return the by id
     */
    @Deprecated
    public T getById(ID id, boolean lock);

    /**
     * Save.
     *
     * @param entity the entity
     * @return the t
     * @throws SaveDalException the save dal exception
     */
    public T save(T entity) throws SaveDalException;

    /**
     * Save or update.
     *
     * @param entity the entity
     * @return the t
     * @throws SaveOrUpdateDalException the save or update dal exception
     */
    public T saveOrUpdate(T entity) throws SaveOrUpdateDalException;

    /**
     * Update.
     *
     * @param entity the entity
     * @return the t
     * @throws UpdateDalException the update dal exception
     */
    public T update(T entity) throws UpdateDalException;
}