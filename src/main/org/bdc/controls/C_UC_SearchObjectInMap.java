/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_SearchObjectInMap
 * Last update: 15-set-2017 11.53.36
 * 
 */

package main.org.bdc.controls;

/**
 * Created by Sasha on 13/09/17.
 */
public class C_UC_SearchObjectInMap {

    private static C_UC_SearchObjectInMap instance = null;

    public synchronized static C_UC_SearchObjectInMap getInstance() {
        if (instance == null)
            instance = new C_UC_SearchObjectInMap();
        return instance;
    }

    public void search() {}

}
