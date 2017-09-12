/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.activities
 * Type: Intent
 * Last update: 13-set-2017 0.29.16
 * 
 */

package main.org.bdc.service.activities;

import java.awt.Component;
import java.util.List;

@Deprecated
public class Intent {

    private String           action;

    private Activity         activity;

    private Context          context;

    private Bundle           extra;

    private List<Integer>    flags;

    private Class<Component> typeClass;

    public Intent(Class<Component> componentClass) {
        this.typeClass = componentClass;

    }

    public void addFlags(int flag) {

    }

    public Bundle getExtra() {
        return this.extra;
    }

    public void putExtra(Bundle bundle) {

    }

    public void setAction(String action) {

    }

    public void startActivity(Activity activity) throws InterruptedException {

        Runnable runnable = new Runnable() {

            @Override
            public void run() {

            }
        };
        Thread t = new Thread(runnable);
        t.start();
        t.join();
    }

}
