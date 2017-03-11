/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: BdC
 * Package: org.bdc.service.parser
 * Type: ParserValues
 * Last update: 11-mar-2017 0.58.34
 * 
 */

package org.bdc.service.parser;

import org.bdc.model.entity.ClumpTipo;
import org.bdc.service.parser.exception.BadParseValueException;

public class ParserValues {

    public static Object parse(Class type, String s) throws BadParseValueException {

        switch (type.getSimpleName()) {
            case "int":
                return Integer.parseInt(s);
            case "double":
                return Double.parseDouble(s);
            case "float":
                return Double.parseDouble(s);
            case "ClumpTipo":
                return ClumpTipo.valueOf(s);
            default:
                throw new BadParseValueException();
        }
    }
}
