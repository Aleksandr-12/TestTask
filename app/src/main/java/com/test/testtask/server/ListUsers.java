package com.test.testtask.server;

public class ListUsers {
    private String User;
    private String Uid;
    private String Language;

    public ListUsers(String user, String uid, String language) {
        User = user;
        Uid = uid;
        Language = language;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }
}
