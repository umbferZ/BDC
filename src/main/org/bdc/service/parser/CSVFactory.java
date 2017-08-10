/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser
 * Type: CSVFactory
 * Last update: 12-mar-2017 16.25.12
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
     * @throws FailedInsertException the failed insert exception
     * @throws FailedReadException the failed read exception
     */
    public static void translateFile1(String fileName) throws FailedInsertException, FailedReadException {
        new Translator_File1(fileName).translates();
    }

    /**
     * Translate file 2.
     *
     * @param fileName the file name
     * @throws FailedInsertException the failed insert exception
     * @throws FailedReadException the failed read exception
     */
    public static void translateFile2(String fileName) throws FailedInsertException, FailedReadException {
        new Translator_File2(fileName).translates();
    }

    /**
     * Translate file 3.
     *
     * @param fileName the file name
     * @throws FailedInsertException the failed insert exception
     * @throws FailedReadException the failed read exception
     */
    public static void translateFile3(String fileName) throws FailedInsertException, FailedReadException {
        new Translator_File3(fileName).translates();
    }

    /**
     * Translate file 4.
     *
     * @param fileName the file name
     * @throws FailedInsertException the failed insert exception
     * @throws FailedReadException the failed read exception
     */
    public static void translateFile4(String fileName) throws FailedInsertException, FailedReadException {
        new Translator_File4(fileName).translates();
    }

    /**
     * Instantiates a new CSV factory.
     */
    public CSVFactory() {}
}
