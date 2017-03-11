
package org.bdc.service.parser.monitor.exceptions;

public class FailedReadException extends Exception {

    public FailedReadException() {
        this("Nothing specific message");
    }

    public FailedReadException(String message) {
        super("FailedReadException: " + message);
    }

}
