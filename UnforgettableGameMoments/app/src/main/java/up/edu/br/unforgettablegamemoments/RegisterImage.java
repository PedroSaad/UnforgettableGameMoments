package up.edu.br.unforgettablegamemoments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterImage extends AppCompatActivity {

    private Image image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_image);

        new Conexao(getApplicationContext(),
                "GameMoments.db",
                null,
                1);

//        if(getIntent().getExtras() != null){
//            image = (Image) getIntent().getExtras().getSerializable("image");
//
//            TextView txtName = findViewById(R.id.item_name);
//            TextView txtDescription = findViewById(R.id.item_description);
//            TextView txtData = findViewById(R.id.item_date);
//
//            txtName.setText(image.getName());
//            txtDescription.setText(image.getDescription());
//        }
    }

    public void salvar(View view){
        TextView txtName = findViewById(R.id.txtNome);
        TextView txtDescription = findViewById(R.id.txtDescricao);

        if(image == null){
            image = new Image();
        }
        image.setName(txtName.getText().toString());
        image.setDescription(txtDescription.getText().toString());

        ImageDAO imageDAO = ImageDAO.criarInstancia();

        imageDAO.salvar(image);

        Intent it = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(it);
        Log.d("teste",image.getName());

    }
}
