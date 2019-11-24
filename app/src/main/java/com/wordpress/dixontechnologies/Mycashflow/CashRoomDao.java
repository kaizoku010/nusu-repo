/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.arch.lifecycle.LiveData;


import com.wordpress.dixontechnologies.Mycashflow.data.Constants_;

import java.util.List;

@Dao
public interface CashRoomDao {


    //wanted to create one interface to make that connection. or co-relation.
    @Insert
    void insertCash(CashItems cashItems);
    @Update
    void updateCash(CashItems cashItems);
    @Delete
    void deleteCash(CashItems cashItems);

    @Query("SELECT * FROM " + Constants_.TABLE_CASH)
    LiveData<List<CashItems>> getCashItems_live();

    @Query("SELECT * FROM " + Constants_.TABLE_CASH + " WHERE id = :id")
    CashItems getCashById(Long id);

    @Query("SELECT SUM (amount) AS TOTAL FROM " +
            Constants_.TABLE_CASH)
    public double getCashTotal();


    @Query("SELECT COUNT (*)  FROM " + Constants_.TABLE_CASH)
    public int getCashCount();


    @Query("DELETE FROM " + Constants_.TABLE_CASH)
    void deleteAllCash();
}
*/
