package com.shankar.example.fileDbApi;

import com.shankar.example.fileDbApi.resource.fileDbResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class fileDbConfig {
    public fileDbConfig()
    {
        System.out.println ("Registering jersey config");
        new ResourceConfig().register(fileDbResource.class);
    }
}
