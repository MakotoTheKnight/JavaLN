package edu.mscd.cs.javaln;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Constants {

    // Define a HashSet of class types

    public static final Map PRIMITIVE_MAP = Collections.unmodifiableMap(new HashMap() {
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

}
