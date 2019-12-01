package up.edu.br.unforgettablegamemoments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Image> imagesList;
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagesList = new ArrayList<>();

        recyclerView = findViewById(R.id.rView);


        //Pega os dados do Firebase
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.child("images").getChildren()) {
                    String name = ds.child("name").getValue(String.class);
                    String description = ds.child("description").getValue(String.class);
                    String date = ds.child("date").getValue(String.class);
                    String imageSrc = ds.child("imageSrc").getValue(String.class);

                    imagesList.add(new Image( imageSrc, name,description,date,R.drawable.crash));
                    imagesList.add(new Image( "aaa", "aaaa","dddd","41",R.drawable.crash));

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

        //HARDCODE para colocar imgagens na tela

        imagesList.add(new Image("Skyrim","Dragão","aaa","aaaa",R.drawable.skyrim));
        imagesList.add(new Image("Skyrim","Dragão","aaa","aaaa",R.drawable.skyrim));
        imagesList.add(new Image("Skyrim","Dragão","aaa","aaaa",R.drawable.skyrim));
        imagesList.add(new Image("Skyrim","Dragão","aaa","aaaa",R.drawable.skyrim));


        LinearLayoutManager layautManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLilayoutManager = layautManager;

        recyclerView.setLayoutManager(rvLilayoutManager);

        ImageAdapter adapter = new ImageAdapter(this, imagesList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(MainActivity.this, MainActivity.class );
        startActivity(i);
    }

    public void abrirMain(View view) {
        Intent i = new Intent(MainActivity.this, MainActivity.class );
        startActivity(i);
    }

    public void abrirNovaImagem(View view) {
        Intent i = new Intent(MainActivity.this, RegisterImage.class );
        startActivity(i);
    }
}
