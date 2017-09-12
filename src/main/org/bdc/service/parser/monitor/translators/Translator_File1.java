/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.translators
 * Type: Translator_File1
 * Last update: 13-set-2017 0.30.17
 * 
 */

package main.org.bdc.service.parser.monitor.translators;

import main.org.bdc.service.parser.monitor.beans.Bean_File1;
import main.org.bdc.service.parser.monitor.consumers.Consumer;
import main.org.bdc.service.parser.monitor.consumers.Consumer_File1;
import main.org.bdc.service.parser.monitor.producers.Producer;
import main.org.bdc.service.parser.monitor.producers.Producer_File1;

/**
 * The Class Translator_File1.
 */
public class Translator_File1 extends Translator<Bean_File1> {

    /**
     * Instantiates a new translator file 1.
     *
     * @param fileName the file name
     */
    public Translator_File1(String fileName) {
        super(fileName);
    }

    /*
     * (non-Javadoc)
     * @see
     * main.org.bdc.service.parser.monitor.translators.Translator#getConsumer()
     */
    @Override
    public Consumer<Bean_File1> getConsumer() {
        return new Consumer_File1(getQueue());
    }

    /*
     * (non-Javadoc)
     * @see
     * main.org.bdc.service.parser.monitor.translators.Translator#getProducer()
     */
    @Override
    public Producer<Bean_File1> getProducer() {
        return new Producer_File1(getFileName(), getQueue());
    }

}
