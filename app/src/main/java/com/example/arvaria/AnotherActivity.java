package com.example.arvaria;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    TextView mTitle,mDesc;
    ImageView mImage;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        ActionBar actionBar=getSupportActionBar();
        mTitle=findViewById(R.id.Title_items);
        mDesc=findViewById(R.id.Description);
        mImage=findViewById(R.id.imageview_another);

        Intent intent=getIntent();
        String mTitlet=intent.getStringExtra("iTitle");
        String mDescriptiont=intent.getStringExtra("iDescrip");
        byte[] mBytes=getIntent().getByteArrayExtra("iImage");
        if(mBytes!=null) {
             bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);
            actionBar.setTitle(mTitlet);
            mTitle.setText(mTitlet);
            mDesc.setText(mDescriptiont);
            mImage.setImageBitmap(bitmap);
        }


    }
}
