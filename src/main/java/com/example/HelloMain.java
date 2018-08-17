package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.TimeZone;

/**
 * Date 18/08/18
 * Time 12:07 AM
 *
 * @author yogin
 */
public class HelloMain {

    private static final int DEFAULT_PORT = 10000;

    public static void main(String[] args) throws IOException, InterruptedException {

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        //now that we have the configuration files, let the spring context read it and start the message listener container(s).
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/spring/spring*.xml");
        context.registerShutdownHook();

        int port = getPort(args);
        HelloServer server = context.getAutowireCapableBeanFactory().createBean(HelloServer.class);
        server.start(port);
    }

    private static int getPort(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            try {
                String portNum = args[0];
                int parsedPort = Integer.parseInt(portNum);
                if (parsedPort > 0) {
                    port = parsedPort;
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return port;
    }
}
