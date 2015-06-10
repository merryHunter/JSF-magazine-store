/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com.chernuhaiv.util;

import java.sql.Timestamp;

/**
 *
 * @author chernuhaiv@gmail.com
 */
public class DateConversionUtil {

    public static Timestamp utilDateToSQLTimestamp(java.util.Date date) {
        try {
            return new Timestamp(date.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static java.util.Date timestampToUtilDate(Timestamp ts) {
        try {
            return new java.util.Date(ts.getTime());
        } catch (Exception e) {
            return null;
        }
    }
}
