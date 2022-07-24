package com.selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestsLogging {

	private static final Logger Log = LogManager.getLogger(TestsLogging.class);

	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}
}