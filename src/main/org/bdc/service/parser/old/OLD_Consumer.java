/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.old
 * Type: OLD_Consumer
 * Last update: 12-mar-2017 16.25.13
 * 
 */

package main.org.bdc.service.parser.old;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import main.org.bdc.service.dal.EntityDao;
import main.org.bdc.service.parser.ParserValue;
import main.org.bdc.service.parser.exception.BadParseValueException;

/**
 * The Class OLD_Consumer.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public abstract class OLD_Consumer<T, ID extends Serializable> extends Thread {

    List<EntityDao<T, ID>> entities;

    BlockingQueue<String[]> queue;

    String[] r;

    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {

        try {
            String[] take = queue.take();
            while (take[0] != null && take[1] != null) {
                mappaturaStringaOggetti();

                for (EntityDao<T, ID> entity : entities) {
                    // FIXME get className
                    Class<?> classe = Class.forName("");

                    Class<?>[] parameterTypes = mapsParameterTypes().get(0);
                    Object[] parametersValue = null;

                    for (int i = 0; i < parametersValue.length; i++)
                        parametersValue[i] = ParserValue.parse(parameterTypes[i], r[0]);

                    Constructor<?> constructor = classe.getConstructor(parameterTypes);
                    constructor.newInstance();
                }
                // FIXME save objects into db;

            }
        } catch (InterruptedException e) {

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (BadParseValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mappatura stringa oggetti.
     *
     * @param oggetti the oggetti
     */
    protected abstract void mappaturaStringaOggetti(Object... oggetti);

    /**
     * Maps parameter types.
     *
     * @return the list
     */
    protected abstract List<Class[]> mapsParameterTypes();

    /**
     * Maps parameter values.
     *
     * @return the list
     */
    protected abstract List<int[]> mapsParameterValues();
}
