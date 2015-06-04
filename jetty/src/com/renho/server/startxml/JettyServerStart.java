package com.renho.server.startxml;

public class JettyServerStart {
    public static void main(String[] args) {
        JettyCustomServer server = new JettyCustomServer("./jetty/etc/jetty.xml", "/jetty");
        server.startServer();
    }
}