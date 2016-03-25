package com.yantur.ex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_CODE = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nameString = ((EditText) findViewById(R.id.name)).getText().toString();
                    int ageInt = Integer.parseInt(((EditText) findViewById(R.id.age)).getText().toString());

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                    intent.putExtra("name", nameString);
                    intent.putExtra("age", ageInt);
                    startActivityForResult(intent, REQUEST_CODE);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,"Please fill fields correctly!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Log.d("ART", "I am here");
            ((EditText) findViewById(R.id.name)).setText(data.getStringExtra("name"));
            ((EditText) findViewById(R.id.age)).setText(String.valueOf(data.getIntExtra("age", 0)));
        }
    }
}
