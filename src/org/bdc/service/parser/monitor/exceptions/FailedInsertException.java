
package org.bdc.service.parser.monitor.exceptions;

public class FailedInsertException extends Exception {

    public FailedInsertException() {
        this("Nothing specific message");
    }

    public FailedInsertException(String message) {
        super("FailedInsertException: " + message);
    }

}
