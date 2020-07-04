package com.yichaoinc.RESTfulLearn;


public class Message {
    private String status;
    private String messages;
    private int id;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Message(){

    }

    public Message(String status, String messages, int id){
        this.status = status;
        this.messages = messages;
        this.id = id;
    }
}
