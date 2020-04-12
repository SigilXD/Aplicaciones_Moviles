package com.example.crudfirebasemusica;

import android.content.Intent;
import android.os.Bundle;

import com.example.crudfirebasemusica.adapters.ContactoAdapter;
import com.example.crudfirebasemusica.models.ContactoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_main_bandas;
    private FloatingActionButton fab_main_nuevo;
    private ArrayList<ContactoModel> list;
    private ContactoModel model;

    private final String text_reference = "artistas";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        fab_main_nuevo = findViewById(R.id.fab_main_nuevo);
        lv_main_bandas = findViewById(R.id.lv_main_bandas);
        list = new ArrayList<>();
        model = new ContactoModel();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()){
                    model = child.getValue(ContactoModel.class);
                    if(model != null){
                        list.add(model);
                    }
                }
                lv_main_bandas.setAdapter(new ContactoAdapter(MainActivity.this, list));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Error con Firebase", Toast.LENGTH_SHORT).show();
            }
        });

        lv_main_bandas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                model = (ContactoModel) adapterView.getItemAtPosition(i);
                if(model != null){
                    if (!model.get_id().equals("") && model.get_id() != null){
                        Intent detalle = new Intent(MainActivity.this, DetalleActivity.class);
                        detalle.putExtra("id", model.get_id());
                        startActivity(detalle);
                    }
                }
            }
        });

        fab_main_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevo = new Intent(MainActivity.this, NuevoActivity.class);
                startActivity(nuevo);
            }
        });
    }

}
