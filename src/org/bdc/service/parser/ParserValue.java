/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser
 * Type: ParserValue
 * Last update: 11-mar-2017 19.20.51
 * 
 */

package org.bdc.service.parser;

import org.bdc.model.entity.ClumpTipo;
import org.bdc.service.parser.exception.BadParseValueException;

public class ParserValue {

    public static Object parse(Class type, String s) throws BadParseValueException {
        // FIXME individuare il valore nullo
        s = s.trim();
        String nullore = "00";
        switch (type.getSimpleName()) {
            case "int":
                return Integer.parseInt(!s.isEmpty() ? s : nullore);
            case "double":
                return Double.parseDouble(!s.isEmpty() ? s : nullore);
            case "float":
                return Double.parseDouble(!s.isEmpty() ? s : nullore);
            case "ClumpTipo":
                return ClumpTipo.valueOf(!s.isEmpty() ? s : nullore);
            case "String":
                return String.valueOf(s);
            default:
                throw new BadParseValueException();
        }
    }
}
