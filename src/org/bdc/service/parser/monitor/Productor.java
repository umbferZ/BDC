/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor
 * Type: Productor
 * Last update: 11-mar-2017 0.58.34
 * 
 */

package org.bdc.service.parser.monitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public abstract class Productor<SB extends SimpleBean> implements Runnable {

    private String fileName;

    private QueueProductorConsumer<SB> queue;

    public Productor(String fileName, QueueProductorConsumer<SB> queue) {
        this.queue = queue;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        CSVReader csvReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferReader = new BufferedReader(fileReader);
            String[] nextLine;
            int counter = 0;
            while (counter < 3)
                if (bufferReader.readLine().contains("----"))
                    counter++;
            csvReader = new CSVReader(bufferReader, ',');
            while ((nextLine = csvReader.readNext()) != null) {
                queue.put(getSimpleBean(nextLine));
                notifyAll();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            queue.setFinished(true);
            try {
                csvReader.close();
                bufferReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract SB getSimpleBean(String... values);
}