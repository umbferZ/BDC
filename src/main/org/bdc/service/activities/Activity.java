/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.activities
 * Type: Activity
 * Last update: 13-set-2017 0.29.16
 * 
 */

package main.org.bdc.service.activities;

import java.awt.Component;
import java.lang.reflect.Constructor;

@Deprecated
public abstract class Activity {

    private Component        contentView;

    private Class<Component> typeClass;

    @SuppressWarnings("unchecked")
    public final void run() {
        onCreate();
        try {
            if ((this.contentView = getContentView()) == null)
                throw new Exception("");
            this.typeClass = (Class<Component>) this.contentView.getClass();
            Constructor<Component> constructor = this.typeClass.getConstructor();
            this.contentView = constructor.newInstance();
            this.contentView.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        onStart();
    }

    protected final Component getContentView() {
        return this.contentView;
    }

    protected abstract void onClose();

    protected abstract void onCreate();

    protected abstract void onPause();

    protected abstract void onStart();

    protected abstract void onStop();

    protected final void setContentView(Component contentView) {
        this.contentView = contentView;
    }

}
