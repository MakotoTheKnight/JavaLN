package edu.mscd.cs.javaln.syslog;

// http://www.faqs.org/rfcs/rfc3164.html

import edu.mscd.cs.javaln.Constants;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;

/**
 * Format a message so that it is acceptable to syslogd.
 */

public abstract class SyslogFormatter extends Formatter {

    protected Facility facility = new Facility(Constants.USER);

    public SyslogFormatter() {
        super();

        String f = LogManager.getLogManager().
                getProperty(getClass().getName() + ".facility");

        if (f != null)
            facility = mapFacility(f);
    }

    public SyslogFormatter(int theFacility) {
        super();
        facility = new Facility(theFacility);
    }

    protected static int mapLevel(Level level) {
        // these really don't match up well...
        if (level == Level.SEVERE) {
            return Constants.EMERGENCY;
        }
        if (level == Level.WARNING) {
            return Constants.ALERT;
        }
        if (level == Level.INFO) {
            return Constants.CRITICAL;
        }
        if (level == Level.CONFIG) {
            return Constants.ERROR;
        }
        if (level == Level.FINE) {
            return Constants.WARNING;
        }
        if (level == Level.FINER) {
            return Constants.NOTICE;
        }
        if (level == Level.FINEST) {
            return Constants.INFORMATIONAL;
        }
        return Constants.DEBUG;
    }

    protected Facility mapFacility(String facility) {
        Facility returnFacility;
        if (facility.equalsIgnoreCase("KERN")) {
            returnFacility = new Facility(Constants.KERN);
        } else if (facility.equalsIgnoreCase("USER")) {
            returnFacility = new Facility(Constants.USER);
        } else if (facility.equalsIgnoreCase("MAIL")) {
            returnFacility = new Facility(Constants.MAIL);
        } else if (facility.equalsIgnoreCase("DAEMON")) {
            returnFacility = new Facility(Constants.DAEMON);
        } else if (facility.equalsIgnoreCase("AUTH")) {
            returnFacility = new Facility(Constants.AUTH);
        } else if (facility.equalsIgnoreCase("SYSLOG")) {
            returnFacility = new Facility(Constants.SYSLOG);
        } else if (facility.equalsIgnoreCase("LPR")) {
            returnFacility = new Facility(Constants.LPR);
        } else if (facility.equalsIgnoreCase("NEWS")) {
            returnFacility = new Facility(Constants.NEWS);
        } else if (facility.equalsIgnoreCase("UUCP")) {
            returnFacility = new Facility(Constants.UUCP);
        } else if (facility.equalsIgnoreCase("CRON")) {
            returnFacility = new Facility(Constants.CRON);
        } else if (facility.equalsIgnoreCase("AUTHPRIV")) {
            returnFacility = new Facility(Constants.AUTHPRIV);
        } else if (facility.equalsIgnoreCase("FTP")) {
            returnFacility = new Facility(Constants.FTP);
        } else if (facility.equalsIgnoreCase("LOCAL_0")) {
            returnFacility = new Facility(Constants.LOCAL_0);
        } else if (facility.equalsIgnoreCase("LOCAL_1")) {
            returnFacility = new Facility(Constants.LOCAL_1);
        } else if (facility.equalsIgnoreCase("LOCAL_2")) {
            returnFacility = new Facility(Constants.LOCAL_2);
        } else if (facility.equalsIgnoreCase("LOCAL_3")) {
            returnFacility = new Facility(Constants.LOCAL_3);
        } else if (facility.equalsIgnoreCase("LOCAL_4")) {
            returnFacility = new Facility(Constants.LOCAL_4);
        } else if (facility.equalsIgnoreCase("LOCAL_5")) {
            returnFacility = new Facility(Constants.LOCAL_5);
        } else if (facility.equalsIgnoreCase("LOCAL_6")) {
            returnFacility = new Facility(Constants.LOCAL_6);
        } else if (facility.equalsIgnoreCase("LOCAL_7")) {
            returnFacility = new Facility(Constants.LOCAL_7);
        } else {
            returnFacility = new Facility(Constants.USER);
        }

        return returnFacility;
    }

    public abstract String getPrefix(int level);

    public String format(LogRecord rec) {
        String ret = getPrefix(mapLevel(rec.getLevel())) + " "
                + rec.getSourceClassName() + " " + rec.getSourceMethodName() + " "
                + rec.getLevel() + ": " + formatMessage(rec);
        return (ret);
    }
}
