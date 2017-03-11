/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.translators
 * Type: Translator_File2
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.translators;

import org.bdc.service.parser.monitor.beans.Bean_File2;
import org.bdc.service.parser.monitor.consumers.Consumer;
import org.bdc.service.parser.monitor.consumers.Consumer_File2;
import org.bdc.service.parser.monitor.producers.Producer;
import org.bdc.service.parser.monitor.producers.Producer_File2;

public class Translator_File2 extends Translator<Bean_File2> {

    public Translator_File2(String fileName) {
        super(fileName);
    }

    @Override
    public Consumer<Bean_File2> getConsumer() {
        return new Consumer_File2(getQueue());
    }

    @Override
    public Producer<Bean_File2> getProducer() {
        return new Producer_File2(getFileName(), getQueue());
    }

}
