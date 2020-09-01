package com.example.arvaria.chambal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arvaria.Person;
import com.example.arvaria.PersonDBHelper;
import com.example.arvaria.R;

public class chambaladdrecord extends AppCompatActivity {
    private EditText cNameEditText,cAgeEditText,cOccupationEditText;
    private Button cAddBtn;
    private ChambalDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chambaladdrecord);
        cNameEditText=(EditText)findViewById(R.id.chambaluserName);
        cAgeEditText=(EditText)findViewById(R.id.chambaluserAge);
        cOccupationEditText=(EditText)findViewById(R.id.chambaluserOccupation);
        cAddBtn=(Button)findViewById(R.id.chambaladduserButton);

        cAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savechambal();
            }

        });

    }

    private void savechambal()
    {
        String name=cNameEditText.getText().toString().trim();
        String age=cAgeEditText.getText().toString().trim();
        String occupation=cOccupationEditText.getText().toString().trim();
        dbHelper = new ChambalDBHelper(this);
        if(name.isEmpty())
        {
            Toast.makeText(this,"You must enter a name",Toast.LENGTH_LONG).show();
        }
        if(age.isEmpty())
        {
            Toast.makeText(this,"You must enter an age",Toast.LENGTH_LONG).show();
        }
        if(occupation.isEmpty())
        {
            Toast.makeText(this, "You must enter an occupation", Toast.LENGTH_SHORT).show();
        }
        Person person=new Person(name,age,occupation);

       dbHelper.saveNewPerson(person);
        goBackHome();
    }

    private void goBackHome() {
        startActivity(new Intent(chambaladdrecord.this,chambal.class));
    }

}
