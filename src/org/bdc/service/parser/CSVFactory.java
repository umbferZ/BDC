/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser
 * Type: CSVFactory
 * Last update: 11-mar-2017 19.20.50
 * 
 */

package org.bdc.service.parser;

import org.bdc.service.parser.monitor.exceptions.FailedInsertException;
import org.bdc.service.parser.monitor.exceptions.FailedReadException;
import org.bdc.service.parser.monitor.translators.Translator_File1;
import org.bdc.service.parser.monitor.translators.Translator_File2;
import org.bdc.service.parser.monitor.translators.Translator_File3;
import org.bdc.service.parser.monitor.translators.Translator_File4;

public class CSVFactory {

    public static void translateFile1(String fileName) throws FailedInsertException, FailedReadException {
        new Translator_File1(fileName).translates();
    }

    public static void translateFile2(String fileName) throws FailedInsertException, FailedReadException {
        new Translator_File2(fileName).translates();
    }

    public static void translateFile3(String fileName) throws FailedInsertException, FailedReadException {
        new Translator_File3(fileName).translates();
    }

    public static void translateFile4(String fileName) throws FailedInsertException, FailedReadException {
        new Translator_File4(fileName).translates();
    }

    public CSVFactory() {}
}
