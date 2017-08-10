/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package main.org.bdc.service.parser.monitor.consumers;

import main.org.bdc.service.parser.monitor.QueueProducerConsumer;
import main.org.bdc.service.parser.monitor.beans.SimpleBean;

/**
 * The Class Consumer.
 *
 * @param <SB> the generic type
 */
public abstract class Consumer<SB extends SimpleBean> implements Runnable {

    private QueueProducerConsumer<SB> queue;

    /**
     * Instantiates a new consumer.
     *
     * @param queue the queue
     */
    public Consumer(QueueProducerConsumer<SB> queue) {
        this.queue = queue;
    }

    /**
     * Gets the queue.
     *
     * @return the queue
     */
    public QueueProducerConsumer<SB> getQueue() {
        return queue;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        SB bean = null;
        int a = 0;
        try {
            while (true) {
                if (queue.isFinished())
                    if (queue.isEmpty())
                        return;
                if (!queue.isEmpty()) {
                    bean = queue.take();
                    inserts(bean);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(String.format("Consumer sets finish"));
            queue.setFinished(true);
        }
    }

    /**
     * Sets the queue.
     *
     * @param queue the new queue
     */
    public void setQueue(QueueProducerConsumer<SB> queue) {
        this.queue = queue;
    }

    /**
     * Inserts.
     *
     * @param bean the bean
     */
    protected abstract void inserts(SB bean);
}