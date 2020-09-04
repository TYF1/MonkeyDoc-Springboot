package com.example.monkeyloginon.entity;

import java.util.Map;

public class Message {
    public Map map;
    public String header;

    public Message(Map map, String header) {
        this.map = map;
        this.header = header;
    }
}
