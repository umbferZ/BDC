/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser.monitor.exceptions
 * Type: FailedInsertException
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser.monitor.exceptions;

public class FailedInsertException extends Exception {

    public FailedInsertException() {
        this("Nothing specific message");
    }

    public FailedInsertException(String message) {
        super("FailedInsertException: " + message);
    }

}
