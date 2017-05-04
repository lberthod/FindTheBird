package com.example.kev.projetkevloic.View.add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.kev.projetkevloic.Database.OrnithoDB;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.edit.edit_ornitho;
import com.example.kev.projetkevloic.View.home.HomeOrnithologue;
import com.example.kev.projetkevloic.activity.Login;
import com.example.kev.projetkevloic.object.Ornithologue;

import java.util.ArrayList;

public class addOrni extends AppCompatActivity {

    Button bOK;
    OrnithoDB rDB = new OrnithoDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_orni);

        ArrayList<String> cantons = new ArrayList<String>() ;
        for (String c : rDB.cantons){
            cantons.add(c);
        }
        Spinner spinnerCantons = (Spinner) findViewById(R.id.editText4);

        ArrayAdapter<String> adapteroiseauName = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, cantons);
        spinnerCantons.setAdapter(adapteroiseauName);

        bOK = (Button) findViewById(R.id.button5) ;

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tusername , tpassword, tage ,tcanton;
                finish();
                tusername =  (EditText)  findViewById(R.id.editText6);
                tpassword =  (EditText)  findViewById(R.id.editText);
                tage =  (EditText)  findViewById(R.id.editText2);

                Spinner spinnerCanton= (Spinner) findViewById(R.id.editText4);
                String canton = spinnerCanton.getSelectedItem().toString();



                rDB.createOrnitho(tusername.getText().toString(),
                        tpassword.getText().toString() ,
                        tage.getText().toString(),
                        canton);

                Intent intent = new Intent(addOrni.this , Login.class);

                startActivity(intent);
            }
        });
    }
}
