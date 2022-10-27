package com.test.testtask.database;

import android.content.Context;


import com.test.testtask.database.dao.ListUsersDao;
import com.test.testtask.database.model.ListUsers;
import com.test.testtask.database.model.Reponse;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ListUsers.class, Reponse.class},
        version = 4,exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    private static DataBase INSTANCE;
    public static DataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, "DataBase")
                    //.addMigrations(DataBase.MIGRATION_1_2)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    public abstract ListUsersDao listUsersDao();
}