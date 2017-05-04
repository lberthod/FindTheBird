package com.example.kev.projetkevloic.View.edit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kev.projetkevloic.Database.OiseauDB;
import com.example.kev.projetkevloic.Database.OrnithoDB;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.home.HomeOrnithologue;
import com.example.kev.projetkevloic.object.Ornithologue;

public class edit_ornitho extends AppCompatActivity {

    OrnithoDB rDB = new OrnithoDB(this);
    Button butOK;
    String id = null;
    int ID_USER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ornitho);

        butOK = (Button) findViewById(R.id.button5);

        butOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tusername , tpassword, tage ,tcanton;

                tusername =  (EditText)  findViewById(R.id.editText1);
                tpassword =  (EditText)  findViewById(R.id.editText4);
                tage =  (EditText)  findViewById(R.id.editText3);
                tcanton =  (EditText)  findViewById(R.id.editText2);

                Ornithologue o = new Ornithologue();
                int idOk = Integer.parseInt(id);
                Log.d("-----------", idOk+"");
                o.setId(idOk);
                o.setUsername(tusername.getText().toString());
                o.setPassword(tpassword.getText().toString());
                o.setAge(tage.getText().toString());
                o.setCanton(tcanton.getText().toString());

                rDB.updateOrnitho(o);

                Intent intent = new Intent(edit_ornitho.this , HomeOrnithologue.class);
                intent.putExtra("ID_USER", ID_USER);

                startActivity(intent);
            }
        });

        //Get the intent
        Intent intent = getIntent();

        //Extract the strings
        String username = intent.getStringExtra("username");
        String canton = intent.getStringExtra("canton");
        String age = intent.getStringExtra("age");
        String password = intent.getStringExtra("password");
        id = intent.getStringExtra("id");
        ID_USER = intent.getIntExtra("ID_USER",0);


        //Set the values
        TextView txtLblNom = (TextView) findViewById(R.id.textView1);
        txtLblNom.setText("Username : ");

        TextView txtLblprenom = (TextView) findViewById(R.id.textView2);
        txtLblprenom.setText("Canton: ");

        TextView txtLblAge = (TextView) findViewById(R.id.textView3);
        txtLblAge.setText("Age : ");

        TextView txtLblPassword = (TextView) findViewById(R.id.textView4);
        txtLblPassword.setText("Password: ");


        EditText txtUsername = (EditText) findViewById(R.id.editText1);
        txtUsername.setText(username);

        EditText txtCanton = (EditText) findViewById(R.id.editText2);
        txtCanton.setText(canton);

        EditText txtAge = (EditText) findViewById(R.id.editText3);
        txtAge.setText(age);

        EditText txtPassword = (EditText) findViewById(R.id.editText4);
        txtPassword.setText(password);


    }


    public void Retour (View view) {finish();
    }
}
