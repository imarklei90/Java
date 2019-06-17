package edu.sse.ustc.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Basic Logger
 * @author iustc
 * @since 2018.08.27
 */
public class BasicLogger {

	public static void main(String[] args) {
		// cancel the log
		Logger.getGlobal().setLevel(Level.OFF);
		Logger.getGlobal().info("Global Logger...");
	}

}
