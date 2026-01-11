package naga.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AIApplication {
    private static final Logger logger = LoggerFactory.getLogger(AIApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(AIApplication.class, args);
    }
}
