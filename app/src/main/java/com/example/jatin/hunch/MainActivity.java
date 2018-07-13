package com.example.jatin.hunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.edittext);
        b1= findViewById(R.id.button);
        dataBaseHelper = new DataBaseHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = e1.getText().toString();

                 Long hasbeeninserted =   dataBaseHelper.Isinserted(s);
                 if(hasbeeninserted != -1)
                 {
                     Toast.makeText(MainActivity.this, "data inserted ", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(MainActivity.this, " Something went wrong ", Toast.LENGTH_SHORT).show();
                 }
            }

        });
    }
}
