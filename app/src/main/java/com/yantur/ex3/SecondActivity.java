package com.yantur.ex3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        ((EditText)findViewById(R.id.edit_name)).setText(intent.getStringExtra("name"));
        ((EditText)findViewById(R.id.edit_age)).setText(String.valueOf(intent.getIntExtra("age", 0)));

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = getIntent();
                    String name = ((EditText) findViewById(R.id.edit_name)).getText().toString();
                    Integer age = Integer.parseInt(
                            ((EditText) findViewById(R.id.edit_age)).getText().toString());
                    intent.putExtra("name", name);
                    intent.putExtra("age", age);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                } catch (NumberFormatException e) {
                    Toast.makeText(SecondActivity.this, "Please fill fields correctly!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
