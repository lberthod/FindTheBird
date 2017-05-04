package com.example.kev.projetkevloic.View.show;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kev.projetkevloic.Database.OiseauDB;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.edit.edit_oiseau;
import com.example.kev.projetkevloic.View.home.HomeOiseaux;

import java.util.ArrayList;

public class show_oiseau extends AppCompatActivity {

    OiseauDB oDB ;
    private String idf;
    private int ID_USER ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_oiseau);
        ArrayList<String> colors = new ArrayList<String>();


        for (String i : colors) {
            colors.add(i);
        }

        //Get the intent
        Intent intent = getIntent();

        //Extract the strings
        String nom = intent.getStringExtra("NOM");
        String taille = intent.getStringExtra("TAILLE");
        String poids =  intent.getStringExtra("POIDS");
        String color = intent.getStringExtra("COLOR");
        String text = intent.getStringExtra("TEXT");
        int id_ = intent.getIntExtra("ID",0);
        ID_USER  = intent.getIntExtra("ID_USER", 0);
        Log.d("ID_USERR : " , ID_USER+"");

        // check if the user is the user, if yes we can edit
        if(ID_USER != 1){
            Button butEdit;
            butEdit = (Button) findViewById(R.id.button6);

            butEdit.setVisibility(View.INVISIBLE);
        }


        setIdf(String.valueOf(id_));

        //Set the values
        TextView txtLblNom = (TextView) findViewById(R.id.textView1);
        txtLblNom.setText("Nom : ");

        TextView txtLblTaille = (TextView) findViewById(R.id.textView2);
        txtLblTaille.setText("Taille : ");

        TextView txtLblPoids = (TextView) findViewById(R.id.textView3);
        txtLblPoids.setText("Poids : ");

        TextView txtLblColor = (TextView) findViewById(R.id.textView4);
        txtLblColor.setText("Color : ");

        TextView txtLblText = (TextView) findViewById(R.id.textView5);
        txtLblText.setText("Description : ");


        TextView txtNom = (TextView) findViewById(R.id.textView6);
        txtNom.setText(nom);

        TextView txtTaille = (TextView) findViewById(R.id.textView7);
        txtTaille.setText(taille);

        TextView txtPoids = (TextView) findViewById(R.id.textView8);
        txtPoids.setText(poids);

        TextView txtColor = (TextView) findViewById(R.id.textView11);
        txtColor.setText(color);

        TextView txtText = (TextView) findViewById(R.id.textView10);
        txtText.setText(text);

    }

    public void Retour(View view) {
        finish();
    }

    public void Modify(View view) {

        Intent intent = new Intent(show_oiseau.this, edit_oiseau.class);

        TextView txtNom = (TextView) findViewById(R.id.textView6);
        String nom = txtNom.getText().toString();


        TextView txttaille = (TextView) findViewById(R.id.textView7);
        String taille = txttaille.getText().toString();

        TextView txtPoids = (TextView) findViewById(R.id.textView8);
        String poids = txtPoids.getText().toString();


        TextView txtColor = (TextView) findViewById(R.id.textView11);
        String color = txtPoids.getText().toString();

        TextView txtText = (TextView) findViewById(R.id.textView10);
        String text = txtText.getText().toString();

        intent.putExtra("nom", nom);
        intent.putExtra("text", text);
        intent.putExtra("color", color);
        intent.putExtra("poids", poids);
        intent.putExtra("taille", taille);
        intent.putExtra("id", getIdf() );


        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public String getIdf() {
        return idf;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.butDelete:
                intent = new Intent(this, HomeOiseaux.class);
                int ID = Integer.parseInt(idf);

                oDB = new OiseauDB(this);
                oDB.deleteOiseau(ID);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}





