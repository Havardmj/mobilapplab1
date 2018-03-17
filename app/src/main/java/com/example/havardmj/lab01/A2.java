package com.example.havardmj.lab01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A2 extends AppCompatActivity {
    public static final int SET_CONTACT_REQUEST = 1;  // The request code
    private Button b2;
    private EditText t2;
    private EditText t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        //map variables to GUI elements
        b2 = findViewById(R.id.b2);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);


        t2.setKeyListener(null);
        t2.setOnClickListener(null);
        t3.setKeyListener(null);
        t3.setOnClickListener(null);

        String s = getIntent().getStringExtra("input");
        t2.setText("Goodday: " + s);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, A1.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SET_CONTACT_REQUEST) {
            if(resultCode == RESULT_OK) {
                String res = data.getStringExtra("t4_value");
                t3.setText(("Feedback: " + res));
            }
        }
    }
    private void changeView() {
        Intent i = new Intent(this, A3.class);
            startActivityForResult(i, SET_CONTACT_REQUEST);
    }


}