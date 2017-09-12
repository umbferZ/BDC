/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser.monitor.exceptions
 * Type: FailedInsertException
 * Last update: 13-set-2017 0.30.09
 * 
 */

package main.org.bdc.service.parser.monitor.exceptions;

/**
 * The Class FailedInsertException.
 */
public class FailedInsertException extends Exception {

    /**
     * Instantiates a new failed insert exception.
     */
    public FailedInsertException() {
        this("Nothing specific message");
    }

    /**
     * Instantiates a new failed insert exception.
     *
     * @param message the message
     */
    public FailedInsertException(String message) {
        super("FailedInsertException: " + message);
    }

}
