package com.gapgram.model;

public class Contact {

    private String mail;
    public Contact(){
        this.setMail("Azimi@gmail.com");
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public void deleteMail(){
        this.mail="";
    }

}
