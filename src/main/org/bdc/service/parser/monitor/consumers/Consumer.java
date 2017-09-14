/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.consumers
 * Type: Consumer
 * Last update: 14-set-2017 3.35.06
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
        return this.queue;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        SB bean = null;
        int a = 0;
        long time = 0;
        int rows = 0;
        try {

            while (true) {
                if (this.queue.isFinished())
                    if (this.queue.isEmpty())
                        return;
                if (!this.queue.isEmpty()) {
                    bean = this.queue.take();
                    long start = System.currentTimeMillis();
                    inserts(bean);
                    time += System.currentTimeMillis() - start;
                    rows++;
                }
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            // System.out.println(String.format("Consumer sets finish"));
            if (rows > 0)
                System.out.println(String.format("Avarage time for dequeue and insert is %d ms", time / rows));
            this.queue.setFinished(true);
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