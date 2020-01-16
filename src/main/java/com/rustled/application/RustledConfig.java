package com.rustled.application;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class RustledConfig extends ResourceConfig {
    public RustledConfig() {
        packages("com.rustled");
        register(new RustledTwitchBinder());
    }
}
