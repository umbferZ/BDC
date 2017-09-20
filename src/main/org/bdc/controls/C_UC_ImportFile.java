/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_ImportFile
 * Last update: 20-set-2017 13.23.21
 * 
 */

package main.org.bdc.controls;

import main.org.bdc.service.parser.CSVFactory;
import main.org.bdc.service.parser.monitor.producers.IllegalFileException;
import main.org.bdc.view.JFrameMain.TypeFile;

/**
 * The Class C_UC_ImportFile.
 */
public class C_UC_ImportFile {

    private static C_UC_ImportFile instance = null;

    /**
     * Gets the single instance of C_UC_ImportFile.
     *
     * @return single instance of C_UC_ImportFile
     */
    public synchronized static C_UC_ImportFile getInstance() {
        if (instance == null)
            instance = new C_UC_ImportFile();
        return instance;
    }

    /**
     * Instantiates a new c U C import file.
     */
    public C_UC_ImportFile() {}

    /**
     * Import file.
     *
     * @param fileName the file name
     * @param typeFile the type file
     * @return the thread
     * @throws IllegalFileException the illegal file exception
     */
    /* REQ 04 */
    public Thread importFile(String fileName, TypeFile typeFile) throws IllegalFileException {
        switch (typeFile) {
            case Higal:
                return CSVFactory.translateFile1(fileName);
            case HigalAddictional:
                return CSVFactory.translateFile2(fileName);
            case Glimpse:
                return CSVFactory.translateFile3(fileName);
            case MIPSGAL:
                return CSVFactory.translateFile4(fileName);
        }
        throw new IllegalFileException("");
    }

}
