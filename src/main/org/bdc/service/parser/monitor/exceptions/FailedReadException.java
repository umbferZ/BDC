/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.exceptions
 * Type: FailedReadException
 * Last update: 13-set-2017 0.30.09
 * 
 */

package main.org.bdc.service.parser.monitor.exceptions;

/**
 * The Class FailedReadException.
 */
public class FailedReadException extends Exception {

    /**
     * Instantiates a new failed read exception.
     */
    public FailedReadException() {
        this("Nothing specific message");
    }

    /**
     * Instantiates a new failed read exception.
     *
     * @param message the message
     */
    public FailedReadException(String message) {
        super("FailedReadException: " + message);
    }

}
