package com.InfinityRaider.YouShallNotStack;

//credits to Pahimar for this LogHelper class

import org.apache.logging.log4j.Level;

import net.fybertech.meddleapi.MeddleAPI;

public abstract class LogHelper {
    public static void log(Level logLevel, Object object) {
    	MeddleAPI.LOGGER.log(logLevel, String.valueOf(object));
    }
    public static void all(Object object) {
        log(Level.ALL, object);
    }
    public static void debug(Object object) {
        log(Level.INFO, "[DEBUG] "+object);
    }
    public static void error(Object object) {
        log(Level.ERROR, object);
    }
    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }
    public static void info(Object object) {
        log(Level.INFO, object);
    }
    public static void off(Object object) {
        log(Level.OFF, object);
    }
    public static void trace(Object object) {
        log(Level.TRACE, object);
    }
    public static void warn(Object object) {
        log(Level.WARN, object);
    }
}