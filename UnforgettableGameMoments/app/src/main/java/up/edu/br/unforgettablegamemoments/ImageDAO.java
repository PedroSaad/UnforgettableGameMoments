package up.edu.br.unforgettablegamemoments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class ImageDAO {
    static SQLiteDatabase conn;

    public static ImageDAO criarInstancia(){
        conn = Conexao.capturarConexao();
        return new ImageDAO();
    }

    public void salvar(Image image){
        ContentValues values = new ContentValues();
        values.put("name", image.getName());
        values.put("description", image.getDescription());
        values.put("date",image.getDate());

        conn.insert("image","null",values);

    }
}
