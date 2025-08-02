package org.example.models;

public class SmsMessage extends Message {
    private String sourcePhoneNumber;
    private String targetPhoneNumber;

    public String getSourcePhoneNumber() {
        return sourcePhoneNumber;
    }

    public void setSourcePhoneNumber(String sourcePhoneNumber) {
        this.sourcePhoneNumber = sourcePhoneNumber;
    }

    public String getTargetPhoneNumber() {
        return targetPhoneNumber;
    }

    public void setTargetPhoneNumber(String targetPhoneNumber) {
        this.targetPhoneNumber = targetPhoneNumber;
    }

    @Override
    public String getMessageType() {
        return "SMS";
    }
}