package up.edu.br.unforgettablegamemoments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    static SQLiteDatabase conn;

    public Conexao(Context context,
                   String name,
                   SQLiteDatabase.CursorFactory factory,
                   int version){
        super(context, name, factory, version);
        conn = getWritableDatabase();
    }

    public static SQLiteDatabase capturarConexao(){return conn;}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IMAGE("+
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME VARCHAR(255)NOT NULL, " +
                "DESCRIPTION VARCHAR(140) NOT NULL," +
                "DATA VARCHAR(255)); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
