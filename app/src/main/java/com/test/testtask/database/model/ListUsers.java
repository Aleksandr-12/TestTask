package com.test.testtask.database.model;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ListUsers")
public class ListUsers  implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int mId;
    private String User;
    private String Uid;
    private String Language;

    public ListUsers(String user, String uid, String language) {
        User = user;
        Uid = uid;
        Language = language;
    }
    public ListUsers() {
    }
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
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
