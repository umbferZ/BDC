/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.controls
 * Type: C_UC_ImportFile
 * Last update: 14-set-2017 12.57.35
 * 
 */

package main.org.bdc.controls;

import main.org.bdc.service.parser.CSVFactory;
import main.org.bdc.service.parser.monitor.producers.IllegalFileException;
import main.org.bdc.view.JFrameMain.TypeFile;

/**
 * Created by Sasha on 13/09/17.
 */

public class C_UC_ImportFile {

    private static C_UC_ImportFile instance = null;

    public synchronized static C_UC_ImportFile getInstance() {
        if (instance == null)
            instance = new C_UC_ImportFile();
        return instance;
    }

    public C_UC_ImportFile() {}

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
