/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.log;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.text.DateFormat;
import java.util.Date;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author per_ewan
 */
public class LogFormatter extends Formatter {

    private DateFormat dateFormat;

    static final String lineSep = System.getProperty("line.separator");

    public LogFormatter() {

    }



    @Override
    public String format(LogRecord record) {
        StringBuffer buf = new StringBuffer(180);

        if (dateFormat == null)
           dateFormat = DateFormat.getDateTimeInstance();

        buf.append("[");
        buf.append(dateFormat.format(new Date(record.getMillis())));
        buf.append("]");
        buf.append(' ');

        buf.append(record.getLevel());
        buf.append(": ");
        buf.append(formatMessage(record));

        buf.append(lineSep);

        /*Throwable throwable = record.getThrown();
        if (throwable != null) {
            StringWriter sink = new StringWriter();
            throwable.printStackTrace(new PrintWriter(sink, true));
            buf.append(sink.toString());
        }*/

        return buf.toString();
    }



}
