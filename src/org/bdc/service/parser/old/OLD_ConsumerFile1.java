/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.old
 * Type: OLD_ConsumerFile1
 * Last update: 11-mar-2017 0.58.34
 * 
 */

package org.bdc.service.parser.old;

import java.util.ArrayList;
import java.util.List;

import org.bdc.model.entity.ClumpTipo;

public class OLD_ConsumerFile1<T> extends OLD_Consumer<T, Integer> {

    @Override
    protected void mappaturaStringaOggetti(Object... oggetti) {

        // TODO Auto-generated method stub

    }

    @Override
    protected List<Class[]> mapsParameterTypes() {

        Class[] clump = { int.class, double.class, double.class, double.class, ClumpTipo.class };
        Class[] posizione = { double.class, double.class };
        List<Class[]> list = new ArrayList<>();
        list.add(clump);
        list.add(posizione);
        return list;
    }

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
