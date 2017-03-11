/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor
 * Type: Consumer
 * Last update: 11-mar-2017 0.58.34
 * 
 */

package org.bdc.service.parser.monitor;

public abstract class Consumer<SB extends SimpleBean> implements Runnable {

    private QueueProductorConsumer<SB> queue;

    public Consumer(QueueProductorConsumer<SB> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        SB bean = null;
        try {
            while (!queue.isFinished() && !queue.isEmpty()) {
                bean = queue.take();
                inserts(bean);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queue.setFinished(true);
        }
    }

    protected abstract void inserts(SB bean);
}