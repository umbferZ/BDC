/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.translators
 * Type: Translator_File2
 * Last update: 12-mar-2017 16.25.13
 * 
 */

package main.org.bdc.service.parser.monitor.translators;

import main.org.bdc.service.parser.monitor.beans.Bean_File2;
import main.org.bdc.service.parser.monitor.consumers.Consumer;
import main.org.bdc.service.parser.monitor.consumers.Consumer_File2;
import main.org.bdc.service.parser.monitor.producers.Producer;
import main.org.bdc.service.parser.monitor.producers.Producer_File2;

/**
 * The Class Translator_File2.
 */
public class Translator_File2 extends Translator<Bean_File2> {

    /**
     * Instantiates a new translator file 2.
     *
     * @param fileName the file name
     */
    public Translator_File2(String fileName) {
        super(fileName);
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.monitor.translators.Translator#getConsumer()
     */
    @Override
    public Consumer<Bean_File2> getConsumer() {
        return new Consumer_File2(getQueue());
    }

    /* (non-Javadoc)
     * @see main.org.bdc.service.parser.monitor.translators.Translator#getProducer()
     */
    @Override
    public Producer<Bean_File2> getProducer() {
        return new Producer_File2(getFileName(), getQueue());
    }

}
