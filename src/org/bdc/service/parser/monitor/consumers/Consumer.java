/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.consumers
 * Type: Consumer
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.consumers;

import org.bdc.service.parser.monitor.QueueProducerConsumer;
import org.bdc.service.parser.monitor.beans.SimpleBean;

public abstract class Consumer<SB extends SimpleBean> implements Runnable {

    private QueueProducerConsumer<SB> queue;

    public Consumer(QueueProducerConsumer<SB> queue) {
        this.queue = queue;
    }

    public QueueProducerConsumer<SB> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        SB bean = null;
        int a = 0;
        try {
            int i = 0;
            while (true) {

                if (queue.isFinished())
                    if (queue.isEmpty())
                        return;
                if (!queue.isEmpty()) {
                    for (int j = 0; j < 10000; j++)
                        a = (a + 45) * j;
                    bean = queue.take();
                    inserts(bean);
                    System.out.println(String.format("inserimento bean %d", i++));
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(String.format("Consumer sets finish"));
            queue.setFinished(true);
        }
    }

    public void setQueue(QueueProducerConsumer<SB> queue) {
        this.queue = queue;
    }

    protected abstract void inserts(SB bean);
}