package com.example.jeiro.calmapp.BD;

/**
 * Created by rcrodriguez on 20/11/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rcrodriguez on 7/9/2017.
 */

public class base_de_datos extends SQLiteOpenHelper
{
    private static final String TEXT_TYPE   = " TEXT";
    private static final String NUMBER_TYPE = " INTEGER";
    private static final String REAL_TYPE   = " REAL";

    private static final String COMMA_SEP = ",";

    private static final String CREAR_TABLA_CATEGORIA =
            "CREATE TABLE " +
                    tablas.tabla_categoria.TABLE_NAME +
                    " (" +
                    tablas.tabla_categoria._ID + " INTEGER PRIMARY KEY," +
                    tablas.tabla_categoria.COLUMN_NAME_DESCRIPCION + TEXT_TYPE   + COMMA_SEP +
                    tablas.tabla_categoria.COLUMN_NAME_ICONO       + NUMBER_TYPE +
                    " )";

    private static final String DELETE_TABLA_CATEGORIA =
            "DROP TABLE IF EXISTS " + tablas.tabla_categoria.TABLE_NAME;

    private static final String CREAR_TABLA_CONTENIDO =
            "CREATE TABLE " +
                    tablas.tabla_contenido.TABLE_NAME +
                    " (" +
                    tablas.tabla_contenido._ID + " INTEGER PRIMARY KEY," +
                    tablas.tabla_contenido.COLUMN_NAME_SITIO  + NUMBER_TYPE + COMMA_SEP +
                    tablas.tabla_contenido.COLUMN_NAME_NOMBRE + TEXT_TYPE   + COMMA_SEP +
                    tablas.tabla_contenido.COLUMN_NAME_TIPO   + NUMBER_TYPE +
                    " )";

    private static final String DELETE_TABLA_CONTENIDO =
            "DROP TABLE IF EXISTS " + tablas.tabla_contenido.TABLE_NAME;

    private static final String DELETE_TABLA_SITIO =
            "DROP TABLE IF EXISTS " + tablas.tabla_sitio.TABLE_NAME;

    private static final String CREAR_TABLA_SITIO =
            "CREATE TABLE " +
                    tablas.tabla_sitio.TABLE_NAME +
                    " (" +
                    tablas.tabla_sitio._ID + " INTEGER PRIMARY KEY," +
                    tablas.tabla_sitio.COLUMN_NAME_LATITUD  + REAL_TYPE   + COMMA_SEP +
                    tablas.tabla_sitio.COLUMN_NAME_LONGITUD + REAL_TYPE   + COMMA_SEP +
                    tablas.tabla_sitio.COLUMN_NAME_NOMBRE   + TEXT_TYPE   + COMMA_SEP +
                    tablas.tabla_sitio.COLUMN_NAME_CAT      + NUMBER_TYPE + COMMA_SEP +
                    tablas.tabla_sitio.COLUMN_NAME_TELEFONO + NUMBER_TYPE   +
                    " )";

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Organizate.db";

    public base_de_datos(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREAR_TABLA_CATEGORIA);
        db.execSQL(CREAR_TABLA_CONTENIDO);
        db.execSQL(CREAR_TABLA_SITIO);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DELETE_TABLA_CATEGORIA);
        db.execSQL(DELETE_TABLA_CONTENIDO);
        db.execSQL(DELETE_TABLA_SITIO);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}