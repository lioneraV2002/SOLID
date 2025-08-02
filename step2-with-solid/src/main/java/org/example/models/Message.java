package org.example.models;

public abstract class Message {
    protected String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract String getMessageType();
}