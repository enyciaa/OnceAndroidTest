package com.once.android.testandroid.utils;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * Helper methods for exceptions
 */
public final class ExceptionUtils {


    /**
     * Constructor private so class can't be initilised
     */
    private ExceptionUtils() {
    }


    /**
     * Open Activity
     */
    public static String throwableStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

}
