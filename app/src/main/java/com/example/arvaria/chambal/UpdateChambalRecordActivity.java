package com.example.arvaria.chambal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arvaria.Person;
import com.example.arvaria.R;

public class UpdateChambalRecordActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mOccupationEditText;
    // private EditText mImageEditText;
    private Button mUpdateBtn;

    private ChambalDBHelper dbHelper;
    private long receivedPersonId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_chambal_record);
        mNameEditText = (EditText)findViewById(R.id.chambalNameUpdate);
        mAgeEditText = (EditText)findViewById(R.id.chambalAgeUpdate);
        mOccupationEditText = (EditText)findViewById(R.id.chambalOccupationUpdate);
        mUpdateBtn = (Button)findViewById(R.id.updateChambalButton);

        dbHelper = new ChambalDBHelper(this);
        try {
            //get intent to get person id
            receivedPersonId = getIntent().getLongExtra("USER_ID", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Person queriedChambal = dbHelper.getPerson(receivedPersonId);
        mNameEditText.setText(queriedChambal.getName());
        mAgeEditText.setText(queriedChambal.getAge());
        mOccupationEditText.setText(queriedChambal.getOccupation());
        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(
                    View view) {
                //call the save person method
                updateChambal();
            }



        });
    }
    private void updateChambal() {
        String name = mNameEditText.getText().toString().trim();
        String age = mAgeEditText.getText().toString().trim();
        String occupation = mOccupationEditText.getText().toString().trim();
//        if(name.isEmpty()){
//            //error name is empty
//            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT).show();
//        }
//
//        if(age.isEmpty()){
//            //error name is empty
//            Toast.makeText(this, "You must enter an age", Toast.LENGTH_SHORT).show();
//        }
//
//        if(occupation.isEmpty()){
//            //error name is empty
//            Toast.makeText(this, "You must enter an occupation", Toast.LENGTH_SHORT).show();
//        }
        Person updatedChambal = new Person(name, age, occupation);
        //call dbhelper update
        dbHelper.updateChambalRecord(receivedPersonId, this, updatedChambal);  goBackHome();
    }

    private void goBackHome() {
        startActivity(new Intent(this,chambal.class));
    }
}
