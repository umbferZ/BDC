/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser.monitor.exceptions
 * Type: FailedReadException
 * Last update: 12-mar-2017 16.25.12
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
