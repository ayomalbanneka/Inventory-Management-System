package lk.jiat.ims.loggers;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class CustomLoggers {

    public static final Logger logger = Logger.getLogger(CustomLoggers.class.getName());

    static {

        try {

            FileHandler handler = new FileHandler("syetemInfo.log", true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);

        } catch (IOException | SecurityException e) {
            e.printStackTrace();
            System.out.println("Logger Class Exception :" + e.toString());
        }
    }

}
