package dev.uublabs.savingdata;

import android.provider.BaseColumns;

/**
 * Created by Admin on 11/13/2017.
 */

public final class DatabaseContract
{
    public static class Entry implements BaseColumns
    {
        public static final String TABLE_NAME = "Persons";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_GENDER = "Gender";
    }
}
