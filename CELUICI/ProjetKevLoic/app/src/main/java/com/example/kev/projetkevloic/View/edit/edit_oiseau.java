package com.example.kev.projetkevloic.View.edit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kev.projetkevloic.Database.OiseauDB;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.add.addOiseau;
import com.example.kev.projetkevloic.View.home.HomeOiseaux;
import com.example.kev.projetkevloic.object.Oiseau;

import java.util.ArrayList;

public class edit_oiseau extends AppCompatActivity {

    OiseauDB oDB = new OiseauDB(this);
    Button butOK;
    String id = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_oiseau);

        butOK = (Button) findViewById(R.id.butOk);

        butOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tnom , ttext, tpoids,ttaille;

                Spinner mySpinner=(Spinner) findViewById(R.id.editText3);
                String color = mySpinner.getSelectedItem().toString();

                tnom =  (EditText)  findViewById(R.id.editText1);
                ttext = (EditText)  findViewById(R.id.editText4);
                tpoids = (EditText)   findViewById(R.id.editText5);
                ttaille = (EditText)   findViewById(R.id.editText2);

                Oiseau o = new Oiseau();
                o.setId(Integer.parseInt(id));
                o.setText(ttext.getText().toString());
                o.setColor(color);
                o.setNom((tnom.getText().toString()));
                o.setPoids(tpoids.getText().toString());
                o.setTaille(ttaille.getText().toString());


                oDB.updateOiseau(o);


                Intent intent = new Intent(edit_oiseau.this , HomeOiseaux.class);

                startActivity(intent);
            }
        });

        ArrayList<String>colors = new ArrayList<String>();
        Spinner spinnerColor = (Spinner) findViewById(R.id.editText3);


        for (String c : oDB.colorss){
            colors.add(c);
        }

        ArrayAdapter<String> adapterColors = new ArrayAdapter<String>
              (this, android.R.layout.simple_spinner_item, colors);
        spinnerColor.setAdapter(adapterColors);


        //Get the intent
        Intent intent = getIntent();

        //Extract the strings
        id = intent.getStringExtra("id");
        Log.d("---------------",id+"");
        String nom = intent.getStringExtra("nom");
        String text = intent.getStringExtra("text");
        String color = intent.getStringExtra("color");
        String taille = intent.getStringExtra("taille");
        String poids = intent.getStringExtra("poids");


        //Set the values
        TextView txtLblNom = (TextView) findViewById(R.id.textView1);
        txtLblNom.setText("Nom : ");

        TextView txtLblTaille = (TextView) findViewById(R.id.textView4);
        txtLblTaille.setText("Taille : ");

        TextView txtLblPoids = (TextView) findViewById(R.id.textView5);
        txtLblPoids.setText("Poids : ");

        TextView txtLblColor = (TextView) findViewById(R.id.textView3);
        txtLblColor.setText("Color : ");

        TextView txtLblText = (TextView) findViewById(R.id.textView2);
        txtLblText.setText("Description : ");

        EditText txtNom = (EditText) findViewById(R.id.editText1);
        txtNom.setText(nom);

        EditText txtTaille = (EditText) findViewById(R.id.editText4);
        txtTaille.setText(taille);

        EditText txtPoids = (EditText) findViewById(R.id.editText5);
        txtPoids.setText(poids);

        Spinner spinnerColor2 = (Spinner) findViewById(R.id.editText3);
        spinnerColor2.setSelection(oDB.findColor(color));

        EditText txtText = (EditText) findViewById(R.id.editText2);
        txtText.setText(text);
    }

   // private void setWineLotField() {
   //     String currentColor = (String) spinnerOrientation.getSelectedItem();
    //}


    public void Retour (View view) {
        finish();
    }


}
