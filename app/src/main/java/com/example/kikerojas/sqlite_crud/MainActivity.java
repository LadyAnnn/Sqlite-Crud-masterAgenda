package com.example.kikerojas.sqlite_crud;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.kikerojas.sqlite_crud.adapter.AdapterPerssonas;
import com.example.kikerojas.sqlite_crud.entidades.Personas;
import com.example.kikerojas.sqlite_crud.sqlite.Database;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView listVieContact;
    EditText editTextBuscar;
    private Button btnagregar;
    private EditText textonombre;
    private EditText textotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textonombre=(EditText)findViewById(R.id.txtnombre2);
        textotel=(EditText)findViewById(R.id.txttel2);

        btnagregar=(Button)findViewById(R.id.buttonagregar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        database = new Database(this, null, null, 1);

        listVieContact = (ListView) findViewById(R.id.listViewcontactos);
        editTextBuscar = (EditText) findViewById(R.id.buscaredit);
       // floatingActionButton.setOnClickListener(this);
        database = new Database(this, null, null, 1);

        //boton agregar
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = textonombre.getText().toString();
                int numero = Integer.parseInt(textotel.getText().toString());
                Personas persona = new Personas();
                persona.agregar(nombre, numero);
                if(database.addPersona(persona)>0){
                    confirmacion();
                }else{
                   // mensajeError();
                }

                limpiarcampos();

            }
        });
        ListPersonas();
        //buscarDisplay();
    }
    public void limpiarcampos() {
        textonombre.setText("");
        textotel.setText("");
    }
    public void confirmacion() {

        new AlertDialog.Builder(this)
                .setTitle("Exito")
                .setMessage("Guardado Correctamente")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }



    private void ListPersonas() {

        ArrayList<Personas> personasList = database.getPersonases();
        AdapterPerssonas adapterpersonas = new AdapterPerssonas(this, 0, personasList);
        listVieContact.setAdapter(adapterpersonas);
        listVieContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Personas personas = (Personas) parent.getItemAtPosition(position);
                //dialogOpe(personas);
            }
        });


    }
}
