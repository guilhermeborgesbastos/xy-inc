package me.challenge.GenericRestApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.out.println("SpringApplicationBuilder configure() >> ");
        return application.sources(GenericRestApplication.class);
    }

}
