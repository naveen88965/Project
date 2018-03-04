package naveen.android.com.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DS on 3/4/2018.
 */

public class SqHelper extends SQLiteOpenHelper{



    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = Constant.DATABASE_NAME;
    public SqHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Constant.TABLE_NAME + " (" +
                    Constant.COLUMN_NAME_ONE + " TEXT," +
                    Constant.COLUMN_NAME_TWO + " TEXT," +
                    Constant.COLUMN_NAME_THREE + " TEXT,"+
                    Constant.COLUMN_NAME_FOUR + " TEXT, PRIMARY KEY (COLUMN_NAME_TWO,COLUMN_NAME_THREE ))";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Constant.TABLE_NAME;



    public SqHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }
}
