package com.hamzaiqbal.photoeditorapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenGallery(View view) {
        ImagePicker.Companion.with(this)
                .crop()
                .galleryOnly()
                .start();
    }

    public void OpenCamera(View view) {
        ImagePicker.Companion.with(this)
                .crop()
                .cameraOnly()
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            uri = data.getData();
            if (uri!=null){
            Intent intent = new Intent(getApplicationContext(),EditingPage.class);
            intent.putExtra("uri", uri);
            startActivity(intent);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}