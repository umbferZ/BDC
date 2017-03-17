/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.activities
 * Type: Activity
 * Last update: 17-mar-2017 7.47.22
 * 
 */

package org.bdc.service.activities;

import java.awt.Component;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

public abstract class Activity<CV extends Component> {

    private CV        contentView;

    private Class<CV> typeClass;

    @SuppressWarnings("unchecked")
    public void run() {
        onCreate();
        try {
            if ((contentView = getContentView()) == null)
                throw new Exception("");
            typeClass = (Class<CV>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Constructor<CV> constructor = typeClass.getConstructor();
            contentView = constructor.newInstance();
            contentView.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        onStart();
    }

    protected CV getContentView() {
        return contentView;
    }

    protected abstract void onClose();

    protected abstract void onCreate();

    protected abstract void onPause();

    protected abstract void onStart();

    protected abstract void onStop();

    protected void setContentView(CV contentView) {
        this.contentView = contentView;
    }

}
