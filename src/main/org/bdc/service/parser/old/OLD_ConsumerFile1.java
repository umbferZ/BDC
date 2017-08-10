/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.old
 * Type: OLD_ConsumerFile1
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package main.org.bdc.service.parser.old;

import java.util.ArrayList;
import java.util.List;

import main.org.bdc.model.entity.ClumpTipo;

/**
 * The Class OLD_ConsumerFile1.
 *
 * @param <T> the generic type
 */
public class OLD_ConsumerFile1<T> extends OLD_Consumer<T, Integer> {

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.old.OLD_Consumer#mappaturaStringaOggetti(java.lang.Object[])
     */
    @Override
    protected void mappaturaStringaOggetti(Object... oggetti) {

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.old.OLD_Consumer#mapsParameterTypes()
     */
    @Override
    protected List<Class[]> mapsParameterTypes() {

        Class[] clump = { int.class, double.class, double.class, double.class, ClumpTipo.class };
        Class[] posizione = { double.class, double.class };
        List<Class[]> list = new ArrayList<>();
        list.add(clump);
        list.add(posizione);
        return list;
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.old.OLD_Consumer#mapsParameterValues()
     */
    @Override
    protected List<int[]> mapsParameterValues() {

        int[] clump = { 0, 3, 4, 5, 6 };
        int[] posizione = { 1, 2 };
        List<int[]> list = new ArrayList<>();
        list.add(clump);
        list.add(posizione);
        return null;
    }

}
