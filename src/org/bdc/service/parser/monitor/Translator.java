/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor
 * Type: Translator
 * Last update: 11-mar-2017 0.58.34
 * 
 */

package org.bdc.service.parser.monitor;

import org.bdc.service.parser.monitor.exceptions.FailedInsertException;
import org.bdc.service.parser.monitor.exceptions.FailedReadException;

public abstract class Translator<SB extends SimpleBean> {

    private Productor<SB> productor;

    private Consumer<SB> consumer;

    public Translator(Productor<SB> p, Consumer<SB> c) {
        this.consumer = c;
        this.productor = p;
    }

    public void translates() throws FailedInsertException, FailedReadException {
        Thread prod = new Thread(productor);
        Thread cons = new Thread(consumer);
        prod.start();
        cons.start();
        try {
            prod.join();
        } catch (InterruptedException e) {
            throw new FailedReadException();
        }
        try {
            cons.join();
        } catch (InterruptedException e) {
            throw new FailedInsertException();
        }
    }
}
