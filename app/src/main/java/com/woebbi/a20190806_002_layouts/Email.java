package com.woebbi.a20190806_002_layouts;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Email implements Serializable {

    private String to;
    private String from;
    private String subject;
    private String message;
    private Calendar sentDate;
    private Date receiveDate;

    private Calendar cal;

    public Email(String to, String from, String subject, String message, Calendar cal, Date receiveDate) { //TODO change reviece date to calendar
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.sentDate = sentDate;
        this.cal = cal;
        this.receiveDate = receiveDate;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Calendar getSentDate() {
        return sentDate;
    }

    public void setSentDate(Calendar sentDate) {
        this.sentDate = sentDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Calendar getCalendar() {
        return cal;
    }


}
