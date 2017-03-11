/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.exceptions
 * Type: FailedReadException
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.exceptions;

public class FailedReadException extends Exception {

    public FailedReadException() {
        this("Nothing specific message");
    }

    public FailedReadException(String message) {
        super("FailedReadException: " + message);
    }

}
