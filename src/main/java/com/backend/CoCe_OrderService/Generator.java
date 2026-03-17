package com.backend.CoCe_OrderService;

import org.springframework.beans.factory.annotation.Value;

public class Generator {

    @Value("${spring.application.frontend-url}")
    private static String url;

    public static String urlGenerator(String id) {
        return url + id;
    }

}
