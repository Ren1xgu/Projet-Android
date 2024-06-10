package com.example.country.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Countries.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_COUNTRIES = "countries";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NATIONALFLAG = "nationalflag";
    private static final String COLUMN_BOOKMARK = "bookmark";
    private static final String COLUMN_CAPITAL = "capital";

    private static final String CREATE_TABLE_COUNTRIES =
            "CREATE TABLE " + TABLE_COUNTRIES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_NATIONALFLAG + " TEXT," +
                    COLUMN_CAPITAL + " TEXT," +
                    COLUMN_BOOKMARK + " INTEGER DEFAULT 0" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COUNTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTRIES);
        onCreate(db);
    }

    //Insert country data
    public  void insertCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, country.getName());
        values.put(COLUMN_CAPITAL, country.getCapital());
        values.put(COLUMN_NATIONALFLAG, country.getNationalflag());
        values.put(COLUMN_BOOKMARK, country.getBookmark());
        // 其他属性的填充
        db.insert(TABLE_COUNTRIES, null, values);
        db.close();
    }
    //Updating of national data
    public int updateCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, country.getName());
        values.put(COLUMN_CAPITAL, country.getCapital());
        values.put(COLUMN_NATIONALFLAG, country.getNationalflag());
        values.put(COLUMN_BOOKMARK, country.getBookmark());

        // Update the condition, here use id as the condition, because id is the primary keyUpdate the condition, here use id as the condition, because id is the primary key
        String selection = COLUMN_ID + "=?";
        String[] selectionArgs = { String.valueOf(country.getId()) };

        int rowsAffected = db.update(TABLE_COUNTRIES, values, selection, selectionArgs);

        db.close();

        return rowsAffected;
    }
    // Get a list of countries
    public ArrayList<Country> getAllCountries() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Country> countries = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_COUNTRIES, null);

        if (cursor.moveToFirst()) {
            do {
                Country country = new Country();
                // Assuming that the Country class has a constructor or setter method.
                country.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                country.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                country.setCapital(cursor.getString(cursor.getColumnIndex(COLUMN_CAPITAL)));
                country.setNationalflag(cursor.getString(cursor.getColumnIndex(COLUMN_NATIONALFLAG)));
                country.setBookmark(cursor.getInt(cursor.getColumnIndex(COLUMN_BOOKMARK)));
                // Get the other properties from the cursor and assign them to the country object.
                countries.add(country);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return countries;
    }

    public ArrayList<Country> getBookmarkedCountries() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Country> bookmarkedCountries = new ArrayList<>();
        Cursor cursor = db.query(TABLE_COUNTRIES, null, "bookmark = 1", null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Country country = new Country();
                // Assuming that the Country class has a constructor or setter method.
                country.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                country.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                country.setCapital(cursor.getString(cursor.getColumnIndex(COLUMN_CAPITAL)));
                country.setNationalflag(cursor.getString(cursor.getColumnIndex(COLUMN_NATIONALFLAG)));
                country.setBookmark(cursor.getInt(cursor.getColumnIndex(COLUMN_BOOKMARK)));
                // Get the other properties from the cursor and assign them to the country object.
                bookmarkedCountries.add(country);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return bookmarkedCountries;
    }

    public ArrayList<Country> searchCountriesByName(String query) {
        ArrayList<Country> searchResults = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {
                    COLUMN_ID,
                    COLUMN_NAME,
                    COLUMN_NATIONALFLAG,
                    COLUMN_BOOKMARK
            };

            // Fuzzy queries using the LIKE operator, with % as a wildcard
            String selection = COLUMN_NAME + " LIKE ?";
            String[] selectionArgs = {"%" + query + "%"};

            Cursor cursor = db.query(TABLE_COUNTRIES, columns, selection, selectionArgs, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    Country country = new Country();
                    // Assuming that the Country class has a constructor or setter method.
                    country.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                    country.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                    // Get nationalflag and bookmark fields from cursor
                    country.setNationalflag(cursor.getString(cursor.getColumnIndex(COLUMN_NATIONALFLAG)));
                    country.setBookmark(cursor.getInt(cursor.getColumnIndex(COLUMN_BOOKMARK)));
                    searchResults.add(country);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        }catch (Exception e){
            return searchResults;

        }

        return searchResults;
    }
}