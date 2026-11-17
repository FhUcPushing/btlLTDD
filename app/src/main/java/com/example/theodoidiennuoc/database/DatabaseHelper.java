package com.example.theodoidiennuoc.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DienNuocPhongTroG319.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String taoBang = "CREATE TABLE rooms("+
                "room_code TEXT PRIMARY KEY,"+
                "password TEXT NOT NULL,"+
                        "tenant_name TEXT NOT NULL,"+
                "phone TEXT,"+
                "floor_info TEXT,"+
                "start_date TEXT,"+
                "default_elec_price INTEGER,"+
                "default_water_price INTEGER)";
        db.execSQL(taoBang);
        themPhongMau(db);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS rooms");
        onCreate(db);
    }
    private void themPhongMau(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put("room_code","P319");
        values.put("password","123456");
        values.put("tenant_name","Trần Minh Khang");
        db.insert("rooms",null,values);

        ContentValues values1 = new ContentValues();
        values1.put("room_code","P101");
        values1.put("password","123456");
        values1.put("tenant_name","Vũ Hoàng Anh");
        db.insert("rooms",null,values1);

        ContentValues values2 = new ContentValues();
        values2.put("room_code","P202");
        values2.put("password","123456");
        values2.put("tenant_name","Đoàn Văn Phúc");
        db.insert("rooms",null,values2);

    }
    public boolean kiemTraDangNhap(String maPhong, String matKhau){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT room_code, password FROM rooms WHERE room_code = ? AND password = ?", new String[]{maPhong,matKhau}
        );
        if(cursor.getCount()<1){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
