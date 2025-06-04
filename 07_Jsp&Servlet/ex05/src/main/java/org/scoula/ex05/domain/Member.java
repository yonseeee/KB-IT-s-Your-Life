package org.scoula.ex05.domain;



public class Member {
    private String name;
    private String userid;

    public Member(){

    }
    public Member(String name, String userid) {
        this.userid = userid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
