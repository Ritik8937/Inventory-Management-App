package com.example.arvaria;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class dialog extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        image=findViewById(R.id.imageview_dialog);

    }
    public void camera(View v)
    {
        Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1001);
    }
    public void gallery(View v)
    {

        Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1002);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            if(requestCode==1001)
            {
                cameraCode(data);
            }
            if(requestCode==1002)
            {
                gallery(data);
            }
        }
    }
    public void cameraCode(Intent data)
    {
        Bitmap thumb = (Bitmap) data.getExtras().get("data");
        image.setImageBitmap(thumb);
    }
    public void gallery(Intent data)
    {
        Uri selectedImage=data.getData();
        image.setImageURI(selectedImage);
    }
}
