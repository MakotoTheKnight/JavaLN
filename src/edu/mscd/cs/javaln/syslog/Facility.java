package edu.mscd.cs.javaln.syslog;

public class Facility {

    private final int facilityValue;

    public Facility(final int theFacilityValue) {
        facilityValue = theFacilityValue;
    }

    public int getFacilityValue() {
        return facilityValue;
    }
}
