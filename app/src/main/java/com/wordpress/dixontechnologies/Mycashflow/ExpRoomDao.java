/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.wordpress.dixontechnologies.Mycashflow.data.Constants_;

import java.util.List;
@Dao
interface ExpRoomDao {

    @Insert
    void insertExp(ExpItems expItems);
    //each annotation will take two methods.

    @Update
    void updateExp(ExpItems expItems);

    @Ignore
    @Delete
    void deleteExp(ExpItems expItems);

    @Ignore
    @Query("SELECT * FROM " + Constants_.TABLE_EXP)
    LiveData<List<ExpItems>> getExpItems();

    @Ignore
    @Query("SELECT * FROM " + Constants_.TABLE_EXP + " WHERE exp_id = :id")
    public ExpItems getExpById(Long id);

}
*/
