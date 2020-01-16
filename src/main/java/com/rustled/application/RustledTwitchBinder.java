package com.rustled.application;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class RustledTwitchBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(RustledTwitchClient.class).to(RustledTwitchClient.class);
    }
}
