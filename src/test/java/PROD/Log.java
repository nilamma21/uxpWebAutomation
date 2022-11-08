package PROD;

import java.util.Properties;

import org.apache.log4j.Logger;

public class Log {

	//Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());
	

	public static void info(String msg) {
		Log.info(msg);
	}

	public static void debug(String msg) {
		Log.debug(msg);
	}

	public static void warn(String msg) {
		Log.warn(msg);
	}

	public static void error(String msg, Exception e) {
		Log.error(msg, e);
	}

	public static void fatal(String msg) {
		Log.fatal(msg);
	}
}

