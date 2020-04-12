package com.example.crudfirebasemusica;

import android.content.Intent;
import android.os.Bundle;

import com.example.crudfirebasemusica.models.ContactoModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoActivity extends AppCompatActivity {

    private EditText et_nuevo_nombre, et_nuevo_genero;
    private FloatingActionButton fab_nuevo_guardar;
    private ContactoModel model;

    private final String text_reference = "artistas";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        Toolbar toolbar = findViewById(R.id.toolbar_nuevo);
        setSupportActionBar(toolbar);

        et_nuevo_nombre = findViewById(R.id.et_nuevo_nombre);
        et_nuevo_genero = findViewById(R.id.et_nuevo_genero);
        fab_nuevo_guardar = findViewById(R.id.fab_nuevo_guardar);



        fab_nuevo_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String nombre = et_nuevo_nombre.getText().toString();
                String genero = et_nuevo_genero.getText().toString();

                if(!nombre.equals("") && !genero.equals("")){
                    String id = reference.push().getKey();

                    if(id != null && !id.equals("")){
                        model = new ContactoModel(id, nombre, genero);

                        reference.child(id).setValue(model)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        if (!model.get_id().equals("") && model.get_id() != null){
                                            Intent detalle = new Intent(NuevoActivity.this, DetalleActivity.class);
                                            detalle.putExtra("id", model.get_id());
                                            startActivity(detalle);
                                            finish();
                                        }
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Snackbar.make(view, "No pude guardar, revisa la informacion", Snackbar.LENGTH_LONG).show();
                                    }
                                });
                    }else {
                        Snackbar.make(view, "problemas al crear ID en base de datos", Snackbar.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(NuevoActivity.this, "Por favor ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
