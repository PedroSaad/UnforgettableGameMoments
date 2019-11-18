package up.edu.br.unforgettablegamemoments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Image> imagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rView);
        imagesList = new ArrayList<>();
        imagesList.add(new Image(R.drawable.skyrim,"Skyrim","Dragão"));
        imagesList.add(new Image(R.drawable.crash,"Crash","1ª Fase"));
        imagesList.add(new Image(R.drawable.witcher,"The Witcher 3","Cavalo Voador!Cavalo Voador!Cavalo Voador!Cavalo Voador!Cavalo Voador!Cavalo Voador!Cavalo Voador!Cavalo Voador!Cavalo Voador!Cavalo Voador!"));
        imagesList.add(new Image(R.drawable.darksouls,"Dark Souls","Atirador!"));


        LinearLayoutManager layautManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLilayoutManager = layautManager;

        recyclerView.setLayoutManager(rvLilayoutManager);

        ImageAdapter adapter = new ImageAdapter(this, imagesList);
        recyclerView.setAdapter(adapter);
    }
}
