package com.example.kev.projetkevloic.View.show;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.edit.edit_ornitho;

public class show_ornitho extends AppCompatActivity {
    String password = "";
    private String idf;
    private int ID_USER ;

    public String getIdf() {
        return idf;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ornitho);

        //Get the intent
        Intent intent = getIntent();

        //Extract the strings
        String nom = intent.getStringExtra("username");
        String canton = intent.getStringExtra("canton");
        String password = intent.getStringExtra("password");
        String age = intent.getStringExtra("age");
        int id_ = intent.getIntExtra("id",0);
        setIdf(String.valueOf(id_));

        ID_USER  = intent.getIntExtra("ID_USER", 0);
        Log.d("ID_ORNITHI : ", ID_USER+"");

        // check if the user is the user, if yes we can edit
        if(id_ != ID_USER || ID_USER == 1){
            Button butEdit;
            butEdit = (Button) findViewById(R.id.button10);

            butEdit.setVisibility(View.INVISIBLE);
        }


        //Set the values
        TextView txtLblNom = (TextView) findViewById(R.id.textView1);
        txtLblNom.setText("Nom : ");

        TextView txtLblCanton = (TextView) findViewById(R.id.textView2);
        txtLblCanton.setText("Canton : ");

        TextView txtLblAge = (TextView) findViewById(R.id.textView3);
        txtLblAge.setText("Age : ");


        TextView txtUser = (TextView) findViewById(R.id.textView4);
        txtUser.setText(nom);

        TextView txtCanton = (TextView) findViewById(R.id.textView5);
        txtCanton.setText(canton);

        TextView txtAge = (TextView) findViewById(R.id.textView6);
        txtAge.setText(age);

    }

    public void Retour (View view) {
        finish();
    }

    public void edit (View view) {

        Intent intent = new Intent(show_ornitho.this, edit_ornitho.class);

        TextView txtUsername = (TextView) findViewById(R.id.textView4);
        String username = txtUsername.getText().toString();

        TextView txtCanton= (TextView) findViewById(R.id.textView5);
        String canton = txtCanton.getText().toString();

        TextView txtAge= (TextView) findViewById(R.id.textView6);
        String age = txtAge.getText().toString();


        intent.putExtra("username", username);
        intent.putExtra("canton", canton);
        intent.putExtra("age", age);
        intent.putExtra("password",password);
        intent.putExtra("id", getIdf()+"" );
        intent.putExtra("ID_USER", ID_USER);

        startActivity(intent);
    }



}
