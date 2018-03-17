package com.example.havardmj.lab01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A3 extends AppCompatActivity {
    private Button b3;
    private EditText t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);


        b3 = findViewById(R.id.b3);
        t4 = findViewById(R.id.t4);

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //changeView(t4);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, A2.class);
        setResult(Activity.RESULT_CANCELED, i);
        finish();
    }
    private void changeView(EditText t4) {
        Intent i = new Intent(this, A2.class);
        i.putExtra("t4_value", t4.getText().toString());
        setResult(Activity.RESULT_OK, i);
        finish();
    }


}
