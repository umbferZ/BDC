/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: main.org.bdc.service.parser
 * Type: ParserValue
 * Last update: 12-mar-2017 16.25.13
 * 
 */

package main.org.bdc.service.parser;

import main.org.bdc.model.entity.ClumpTipo;
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
            case "ClumpTipo":
                return ClumpTipo.valueOf(s);
            case "String":
                return s;
            default:
                throw new BadParseValueException();
        }
    }
}
