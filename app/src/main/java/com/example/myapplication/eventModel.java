package com.example.myapplication;

public class eventModel {
    String head,event;

    public eventModel(String head, String event) {
        this.head = head;
        this.event = event;
    }

    public String getHead() {

        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
