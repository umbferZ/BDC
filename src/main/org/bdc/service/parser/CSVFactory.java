/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser
 * Type: CSVFactory
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.service.parser;

import main.org.bdc.service.parser.monitor.exceptions.FailedInsertException;
import main.org.bdc.service.parser.monitor.exceptions.FailedReadException;
import main.org.bdc.service.parser.monitor.translators.Translator_File1;
import main.org.bdc.service.parser.monitor.translators.Translator_File2;
import main.org.bdc.service.parser.monitor.translators.Translator_File3;
import main.org.bdc.service.parser.monitor.translators.Translator_File4;

/**
 * A factory for creating CSV objects.
 */
public class CSVFactory {

    /**
     * Translate file 1.
     *
     * @param fileName the file name
     * @return the thread
     */
    public static Thread translateFile1(String fileName) {
        return new Thread(new Translator_File1(fileName));

    }

    /**
     * Translate file 2.
     *
     * @param fileName the file name
     * @return the thread
     */
    public static Thread translateFile2(String fileName) {
        return new Thread(new Translator_File2(fileName));

    }

    /**
     * Translate file 3.
     *
     * @param fileName the file name
     * @return the thread
     */
    public static Thread translateFile3(String fileName) {
        return new Thread(new Translator_File3(fileName));

    }

    /**
     * Translate file 4.
     *
     * @param fileName the file name
     * @return the thread
     */
    public static Thread translateFile4(String fileName) {
        return new Thread(new Translator_File4(fileName));

    }

    /**
     * Instantiates a new CSV factory.
     */
    public CSVFactory() {}
}
