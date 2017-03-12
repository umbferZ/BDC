/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.translators
 * Type: Translator_File4
 * Last update: 12-mar-2017 16.25.12
 * 
 */

package org.bdc.service.parser.monitor.translators;

import org.bdc.service.parser.monitor.beans.Bean_File4;
import org.bdc.service.parser.monitor.consumers.Consumer;
import org.bdc.service.parser.monitor.consumers.Consumer_File4;
import org.bdc.service.parser.monitor.producers.Producer;
import org.bdc.service.parser.monitor.producers.Producer_File4;

/**
 * The Class Translator_File4.
 */
public class Translator_File4 extends Translator<Bean_File4> {

    /**
     * Instantiates a new translator file 4.
     *
     * @param fileName the file name
     */
    public Translator_File4(String fileName) {
        super(fileName);
    }

    /* (non-Javadoc)
     * @see org.bdc.service.parser.monitor.translators.Translator#getConsumer()
     */
    @Override
    public Consumer<Bean_File4> getConsumer() {
        return new Consumer_File4(getQueue());
    }

    /* (non-Javadoc)
     * @see org.bdc.service.parser.monitor.translators.Translator#getProducer()
     */
    @Override
    public Producer<Bean_File4> getProducer() {
        return new Producer_File4(getFileName(), getQueue());
    }

}
