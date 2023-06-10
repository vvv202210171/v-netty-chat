package org.example;

import io.vertx.core.AbstractVerticle;

/**
 * Created by chengen on 26/04/2017.
 */
public class MainVerticle extends AbstractVerticle {
    public void start() {
        vertx.deployVerticle(MyFirstVertical.class.getName());
    }
}