package com.example.bytenotesfeatures;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.mindorks.paracamera.Camera;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

// 01 Create ImageView

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// 02 Initialize Views

        imageView = findViewById(R.id.imageView);
}

    public void takePicture(View view) {
// 03 Make Intent

        Intent takePictureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

// 04 Check if any application available that can carry out the implicit intent

        if(takePictureIntent.resolveActivity(getPackageManager())!=null){

// 05- If yes then carry out intent and wait for result in onActivityForResult method

        startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);

        }
    }

// 07-
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);


        }
    }
}