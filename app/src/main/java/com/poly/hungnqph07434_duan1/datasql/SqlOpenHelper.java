package com.poly.hungnqph07434_duan1.datasql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.poly.hungnqph07434_duan1.model.CauHoi;
import com.poly.hungnqph07434_duan1.model.NguoiChoi;
import com.poly.hungnqph07434_duan1.model.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class SqlOpenHelper extends SQLiteOpenHelper {


    private static final String AV_TABLE = "av";
    private static String DB_PATH = "";
    private static String DB_NAME = "databaseduan1.db";// Database name
    private SQLiteDatabase mDataBase;
    private final Context mContext;

    public String USER = "user";
    public String PASSWORD = "password";
    public String PHONE = "phone";
    public String HOTEN = "hoten";

    public SqlOpenHelper(Context context) {


        super(context, "databaseduan1.db", null, 1);
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    public void createDataBase() {
        //If the database does not exist, copy it from the assets.
        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    public List<User> getAllUser(){
        List<User> khoanThuChis = new ArrayList<>();
        String SELECT = "SELECT * FROM user";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                User user= new User();
                user.setName(cursor.getString(0));
                user.setPassword(cursor.getString(1));
                user.setPhone(cursor.getString(2));
                user.setHoten(cursor.getString(3));
                khoanThuChis.add(user);

                cursor.moveToNext();
            }
            cursor.close();
        }
        sqLiteDatabase.close();

        return khoanThuChis;
    }

    public List<NguoiChoi> getAllNguoiChoi(){
        List<NguoiChoi> nguoiChois = new ArrayList<>();
        String SELECT = "SELECT * FROM nguoiChoi GROUP  by nguoiChoi.Diem ORDER by nguoiChoi.Diem ASC LIMIT 10";

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                NguoiChoi nguoiChoi= new NguoiChoi();
                nguoiChoi.setTen(cursor.getString(0));
                nguoiChoi.setDiem(cursor.getString(1));
                nguoiChois.add(nguoiChoi);
                cursor.moveToNext();
            }
            cursor.close();
        }
        sqLiteDatabase.close();

        return nguoiChois;
    }

    public List<CauHoi> getAllCauHoi(){
        List<CauHoi> cauHois = new ArrayList<>();
        String SELECT = "SELECT * FROM dataCauHoi";

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                CauHoi cauHoi= new CauHoi();
              cauHoi.setCauHoi(cursor.getString(0));
              cauHoi.setDapAnA(cursor.getString(1));
              cauHoi.setDapAnB(cursor.getString(2));
              cauHoi.setDapAnC(cursor.getString(3));
              cauHoi.setDapAnD(cursor.getString(4));
              cauHoi.setDapAnDung(cursor.getString(5));
                cauHois.add(cauHoi);
                cursor.moveToNext();
            }
            cursor.close();
        }
        sqLiteDatabase.close();

        return cauHois;
    }

    public long insertUser(User user) {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put("userName",user.getName());
        contentValues.put("password",user.getPassword());
        contentValues.put("phone",user.getPhone());
        contentValues.put("hoten",user.getHoten());

        long kq=sqLiteDatabase.insert("user", null,contentValues);
        sqLiteDatabase.close();
        return kq;
    }

    public long insertUser(NguoiChoi nguoiChoi) {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put("tenNguoiChoi",nguoiChoi.getTen());
        contentValues.put("Diem",nguoiChoi.getDiem());

        long kq=sqLiteDatabase.insert("nguoiChoi", null,contentValues);
        sqLiteDatabase.close();
        return kq;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
