package com.example.arvaria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Pictures extends AppCompatActivity {
    FloatingActionButton fab;
    Dialog dialog_box;
    Button gallery,camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(
                    View v) {
//                AlertDialog.Builder a=new AlertDialog.Builder(Pictures.this);
//                View vi=getLayoutInflater().inflate(R.layout.activity_dialog,null,false);
//                a.setView(vi);
//                a.show();
            Intent it=new Intent(getApplicationContext(),dialog.class);
            startActivity(it);

            }
        });

    }

}
