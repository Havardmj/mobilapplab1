package com.example.havardmj.lab01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;

public class A1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button button1;     //B1
    private Spinner spin1;
    private EditText editTxT1;  //T1


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);


        //asign var to GUI
        button1 = findViewById(R.id.button1);
        spin1 = findViewById(R.id.spin1);
        editTxT1 = findViewById(R.id.editTxT1);

        setSpinnerContent();


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeView(editTxT1);
            }
        });

        spin1.setOnItemSelectedListener(this);
        spin1.setSelection(loadSelection());
    }
    private void changeView(EditText editTxT1) {
        Intent i = new Intent(this, A2.class);
        i.putExtra("input", editTxT1.getText().toString());
        startActivity(i);
    }

    /*
    * * function set up the Spinner content and arange it to the spinner.
    * */
    private void setSpinnerContent() {

        ArrayList<String> content = new ArrayList<String>();    //define anew arrayList

        //fill spinner with strings:
        content.add("Android-programming is fun");
        content.add("Better than IOS (I think ? )");
        content.add("Haven't really tried, so can't say for sure ;)");

        //define a arrayAdapter, that uses the content above.
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, content);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapt);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = p.edit();
        edit.putInt("input", i);
        edit.apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        spin1.setSelection(0);
    }

    @Override
    public void onBackPressed() {

        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    private int loadSelection() {
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);
        return p.getInt("input",0);
    }
}
