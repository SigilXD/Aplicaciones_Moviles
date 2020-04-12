package com.example.crudfirebasemusica;

import android.content.Intent;
import android.os.Bundle;

import com.example.crudfirebasemusica.models.ContactoModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarActivity extends AppCompatActivity {

    private EditText et_editar_nombre, et_editar_genero;
    private FloatingActionButton fab_editar_guardar;
    private ContactoModel model;

    private final String text_reference = "artistas";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Toolbar toolbar = findViewById(R.id.toolbar_editar);
        setSupportActionBar(toolbar);

        et_editar_nombre = findViewById(R.id.et_nuevo_nombre);
        et_editar_genero = findViewById(R.id.et_nuevo_genero);
        fab_editar_guardar = findViewById(R.id.fab_editar_guardar);
        model = new ContactoModel();

        String id = getIntent().getStringExtra("id");
        if(id != null && !id.equals("")){
            reference.child(id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    model = dataSnapshot.getValue(ContactoModel.class);
                    if(model != null){
                        et_editar_nombre.setText(model.get_nombre());
                        et_editar_genero.setText(model.get_genero());
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(EditarActivity.this, "Error con Firebase", Toast.LENGTH_SHORT).show();
                }
            });
        }

        fab_editar_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String nombre = et_editar_nombre.getText().toString();
                String genero = et_editar_genero.getText().toString();

                if (!nombre.equals("") && !genero.equals("")) {

                    if (model != null) {
                        String id = model.get_id();

                        if (id != null && id.equals("")) {
                            model.set_nombre(nombre);
                            model.set_genero(genero);

                            reference.child(id).setValue(model)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            if (!model.get_id().equals("") && model.get_id() != null) {
                                                Intent detalle = new Intent(EditarActivity.this, DetalleActivity.class);
                                                detalle.putExtra("id", model.get_id());
                                                startActivity(detalle);
                                                finish();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Snackbar.make(view, "No pude actualizar, revisa la informacion", Snackbar.LENGTH_LONG).show();
                                        }
                                    });
                        } else {
                            Snackbar.make(view, "problemas al crear ID en base de datos", Snackbar.LENGTH_LONG).show();
                        }
                    }

                    } else {
                        Toast.makeText(EditarActivity.this, "Por favor ingrese todos los datos", Toast.LENGTH_SHORT).show();
                    }
                }

        });
    }

}
