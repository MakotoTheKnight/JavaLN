package edu.mscd.cs.javaln;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Constants {

    // Define a HashSet of class types

    public static final Map primitiveHashMap = Collections.unmodifiableMap(new HashMap() {
        {
            put("int", Integer.TYPE);
            put("short", Short.TYPE);
            put("char", Character.TYPE);
            put("long", Long.TYPE);
            put("boolean", Boolean.TYPE);
            put("float", Float.TYPE);
            put("double", Double.TYPE);
            put("byte", Byte.TYPE);
            put("void", Void.TYPE);
        }
    });

    // Static final fields used in the syslogd handler

    public static final int EMERGENCY = 0;
    public static final int ALERT = 1;
    public static final int CRITICAL = 2;
    public static final int ERROR = 3;
    public static final int WARNING = 4;
    public static final int NOTICE = 5;
    public static final int INFORMATIONAL = 6;
    public static final int DEBUG = 7;

    public static final int KERN = 0;
    public static final int USER = 1;
    public static final int MAIL = 2;
    public static final int DAEMON = 3;
    public static final int AUTH = 4;
    public static final int SYSLOG = 5;
    public static final int LPR = 6;
    public static final int NEWS = 7;
    public static final int UUCP = 8;
    public static final int CRON = 9;
    public static final int AUTHPRIV = 10;
    public static final int FTP = 11;
    public static final int LOCAL_0 = 16;
    public static final int LOCAL_1 = 17;
    public static final int LOCAL_2 = 18;
    public static final int LOCAL_3 = 19;
    public static final int LOCAL_4 = 20;
    public static final int LOCAL_5 = 21;
    public static final int LOCAL_6 = 22;
    public static final int LOCAL_7 = 23;


}
