/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.translators
 * Type: Translator_File3
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.translators;

import org.bdc.service.parser.monitor.beans.Bean_File3;
import org.bdc.service.parser.monitor.consumers.Consumer;
import org.bdc.service.parser.monitor.consumers.Consumer_File3;
import org.bdc.service.parser.monitor.producers.Producer;
import org.bdc.service.parser.monitor.producers.Producer_File3;

public class Translator_File3 extends Translator<Bean_File3> {

    public Translator_File3(String fileName) {
        super(fileName);
    }

    @Override
    public Consumer<Bean_File3> getConsumer() {
        return new Consumer_File3(getQueue());
    }

    @Override
    public Producer<Bean_File3> getProducer() {
        return new Producer_File3(getFileName(), getQueue());
    }

}
