package com.monkeydoc.Bean;

public class Responsemsg {
    String responsemsg;
    String userid;

    public Responsemsg(String responsemsg, String userid) {
        this.responsemsg = responsemsg;
        this.userid = userid;
    }

    public String getResponsemsg() {
        return responsemsg;
    }

    public void setResponsemsg(String responsemsg) {
        this.responsemsg = responsemsg;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
