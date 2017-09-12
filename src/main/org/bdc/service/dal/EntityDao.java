/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.dal
 * Type: EntityDao
 * Last update: 12-mar-2017 16.24.10
 * 
 */

package main.org.bdc.service.dal;

import java.io.Serializable;
import java.util.List;

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
     * Insert.
     *
     * @param entity the entity
     * @return the t
     */
    public T saveOrUpdate(T entity);
}