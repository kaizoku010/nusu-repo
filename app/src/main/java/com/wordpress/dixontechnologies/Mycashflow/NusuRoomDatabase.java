/*
package com.wordpress.dixontechnologies.Mycashflow;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {CashItems.class, ExpItems.class}, version = 2, exportSchema = false)
public abstract class NusuRoomDatabase extends RoomDatabase
{
        private static volatile  NusuRoomDatabase INSTANCE;
        private static final  String DATABASE_NAME = "nusu_database";

    public abstract CashRoomDao getcashItems();
    public abstract ExpRoomDao getexpItems();



    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {

        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

        static synchronized  NusuRoomDatabase
        getInstance(Context context){
        if (INSTANCE == null){
            //create database
            INSTANCE = Room.databaseBuilder(context,
                    NusuRoomDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                    .addCallback(new RoomDatabase.Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Log.d("sDixonDatabase", "populating with data...");
                        //    new NusuAsync(INSTANCE).execute();
                        }
                    })
                    .build();
        }
        return INSTANCE;
        }

    @Override
    public void clearAllTables() {
        if (INSTANCE != null){
       //     new NusuAsync(INSTANCE).execute();
        }

    }
}

*/
