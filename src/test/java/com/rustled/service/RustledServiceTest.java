package com.rustled.service;

import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RustledServiceTest {

    // Temporary test
    @Test
    public void testFoo() {
        RustledService rustledService = new RustledService();
        Response response = rustledService.getFoo();

        assertEquals(200, response.getStatus());
    }
}