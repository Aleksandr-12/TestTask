package com.test.testtask.database.model;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Reponse")
public class Reponse implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)

    private int code;

    public Reponse(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
