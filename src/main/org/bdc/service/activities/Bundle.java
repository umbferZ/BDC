/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.activities
 * Type: Bundle
 * Last update: 7-ago-2017 15.22.37
 * 
 */

package main.org.bdc.service.activities;

import java.util.HashMap;

@Deprecated
public class Bundle {

    private HashMap<String, String> bundle;

    public String getString(String key) {
        return bundle.get(key);
    }

    public void putString(String key, String value) {
        bundle.put(key, value);
    }
}
