/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: main.org.bdc.service.parser
 * Type: ParserValue
 * Last update: 20-set-2017 13.23.24
 * 
 */

package main.org.bdc.service.parser;

import main.org.bdc.model.galaxy.ClumpType;
import main.org.bdc.service.parser.exception.BadParseValueException;

/**
 * The Class ParserValue.
 */
public class ParserValue {

    /**
     * Parses the.
     *
     * @param type the type
     * @param s the s
     * @return the object
     * @throws BadParseValueException the bad parse value exception
     */
    public static Object parse(Class type, String s) throws BadParseValueException {
        s = s.trim();
        switch (type.getSimpleName()) {
            case "int":
                return !s.isEmpty() ? Integer.parseInt(s) : (int) Float.NaN;
            case "double":
                return !s.isEmpty() ? Double.parseDouble(s) : Double.NaN;
            case "float":
                return !s.isEmpty() ? Double.parseDouble(s) : Float.NaN;
            case "ClumpType":
                return ClumpType.valueOf(s);
            case "String":
                return s;
            default:
                throw new BadParseValueException();
        }
    }
}
