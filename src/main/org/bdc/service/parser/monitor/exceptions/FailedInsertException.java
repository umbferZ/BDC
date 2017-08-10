/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.exceptions
 * Type: FailedInsertException
 * Last update: 12-mar-2017 16.25.13
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
