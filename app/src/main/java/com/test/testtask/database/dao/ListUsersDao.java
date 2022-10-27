package com.test.testtask.database.dao;

import com.test.testtask.database.model.Reponse;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
@Dao
public interface ListUsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Reponse reponse);
}
