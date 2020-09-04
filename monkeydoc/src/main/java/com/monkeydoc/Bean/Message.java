package com.monkeydoc.Bean;

import java.util.Map;

public class Message {
    Map map;
    String header;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Message(Map map, String header) {
        this.map = map;
        this.header = header;
    }
}
