/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.activities
 * Type: Activity
 * Last update: 7-ago-2017 15.22.23
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
            if ((contentView = getContentView()) == null)
                throw new Exception("");
            typeClass = (Class<Component>) contentView.getClass();
            Constructor<Component> constructor = typeClass.getConstructor();
            contentView = constructor.newInstance();
            contentView.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        onStart();
    }

    protected final Component getContentView() {
        return contentView;
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
