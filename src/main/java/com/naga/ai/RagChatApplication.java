package com.naga.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.naga.*", "com.spring.*"})
public class RagChatApplication {
    private static final Logger logger = LoggerFactory.getLogger(RagChatApplication.class);

    public static void main(String[] args) {
        logger.info("RagChatApplication : ");
        SpringApplication.run(RagChatApplication.class, args);
    }
}
