/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.activities
 * Type: Bundle
 * Last update: 13-set-2017 0.29.16
 * 
 */

package main.org.bdc.service.activities;

import java.util.HashMap;

@Deprecated
public class Bundle {

    private HashMap<String, String> bundle;

    public String getString(String key) {
        return this.bundle.get(key);
    }

    public void putString(String key, String value) {
        this.bundle.put(key, value);
    }
}
