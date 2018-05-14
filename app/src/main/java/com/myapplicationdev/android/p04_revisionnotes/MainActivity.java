package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    Button add,show;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button)findViewById(R.id.buttonInsertNote);
        show = (Button)findViewById(R.id.buttonShowList);
        etNote = (EditText)findViewById(R.id.editTextNote);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroupStars);
                int selectedButton = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectedButton);

                int rating = Integer.parseInt(rb.getText().toString());
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertNote(etNote.getText().toString(), rating);
                db.close();
                Toast.makeText(getBaseContext(),"successful added",
                        Toast.LENGTH_SHORT).show();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });


    }
}
