package github.cotra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        User user = new User("test");
        logger.trace("logback日志 trace");
        logger.debug("logback日志 debug");
        logger.info("logback日志 info");
        logger.warn("logback日志 warn");
        logger.error("logback日志 error");

    }
}
