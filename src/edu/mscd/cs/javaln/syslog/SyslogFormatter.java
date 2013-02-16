package edu.mscd.cs.javaln.syslog;

// http://www.faqs.org/rfcs/rfc3164.html

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;

/**
 * Format a message so that it is acceptable to syslogd.
 */

public abstract class SyslogFormatter extends Formatter {

    protected int facility = Facility.USER;

    public SyslogFormatter() {
        super();

        String f = LogManager.getLogManager().
                getProperty(getClass().getName() + ".facility");

        if (f != null)
            facility = mapFacility(f);
    }

    public SyslogFormatter(int theFacility) {
        super();
        facility = theFacility;
    }

    protected static int mapLevel(Level level) {
        // these really don't match up well...
        if (level == Level.SEVERE) {
            return Facility.EMERGENCY;
        }
        if (level == Level.WARNING) {
            return Facility.ALERT;
        }
        if (level == Level.INFO) {
            return Facility.CRITICAL;
        }
        if (level == Level.CONFIG) {
            return Facility.ERROR;
        }
        if (level == Level.FINE) {
            return Facility.WARNING;
        }
        if (level == Level.FINER) {
            return Facility.NOTICE;
        }
        if (level == Level.FINEST) {
            return Facility.INFORMATIONAL;
        }
        return Facility.DEBUG;
    }

    protected int mapFacility(String facility) {
        if (facility.equalsIgnoreCase("KERN")) {
            return (Facility.KERN);
        } else if (facility.equalsIgnoreCase("USER")) {
            return (Facility.USER);
        } else if (facility.equalsIgnoreCase("MAIL")) {
            return (Facility.MAIL);
        } else if (facility.equalsIgnoreCase("DAEMON")) {
            return (Facility.DAEMON);
        } else if (facility.equalsIgnoreCase("AUTH")) {
            return (Facility.AUTH);
        } else if (facility.equalsIgnoreCase("SYSLOG")) {
            return (Facility.SYSLOG);
        } else if (facility.equalsIgnoreCase("LPR")) {
            return (Facility.LPR);
        } else if (facility.equalsIgnoreCase("NEWS")) {
            return (Facility.NEWS);
        } else if (facility.equalsIgnoreCase("UUCP")) {
            return (Facility.UUCP);
        } else if (facility.equalsIgnoreCase("CRON")) {
            return (Facility.CRON);
        } else if (facility.equalsIgnoreCase("AUTHPRIV")) {
            return (Facility.AUTHPRIV);
        } else if (facility.equalsIgnoreCase("FTP")) {
            return (Facility.FTP);
        } else if (facility.equalsIgnoreCase("LOCAL_0")) {
            return (Facility.LOCAL_0);
        } else if (facility.equalsIgnoreCase("LOCAL_1")) {
            return (Facility.LOCAL_1);
        } else if (facility.equalsIgnoreCase("LOCAL_2")) {
            return (Facility.LOCAL_2);
        } else if (facility.equalsIgnoreCase("LOCAL_3")) {
            return (Facility.LOCAL_3);
        } else if (facility.equalsIgnoreCase("LOCAL_4")) {
            return (Facility.LOCAL_4);
        } else if (facility.equalsIgnoreCase("LOCAL_5")) {
            return (Facility.LOCAL_5);
        } else if (facility.equalsIgnoreCase("LOCAL_6")) {
            return (Facility.LOCAL_6);
        } else if (facility.equalsIgnoreCase("LOCAL_7")) {
            return (Facility.LOCAL_7);
        } else {
            return (Facility.USER);
        }
    }

    public abstract String getPrefix(int level);

    public String format(LogRecord rec) {
        String ret = getPrefix(mapLevel(rec.getLevel())) + " "
                + rec.getSourceClassName() + " " + rec.getSourceMethodName() + " "
                + rec.getLevel() + ": " + formatMessage(rec);
        return (ret);
    }
}
