package com.UserRole.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author Kimtaeng
 * Created on 2018. 9. 21.
 */
public class LoggingSample {
    Logger logger = LoggerFactory.getLogger(LoggingSample.class);

    public void someMethod() {
        logger.info("Hello log4j2 Logger!");
    }

    public static void main(String[] args) {
        new LoggingSample().someMethod();
    }
}