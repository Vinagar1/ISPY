package com.vinayagarwal.ispy20;

/**
 * Created by vinayagarwal on 3/5/16.
 */

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.ActionBarActivity;
import android.content.pm.PackageManger;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class Capture{

    static final int REQEST_IMAGE_CAPTURE = 1;
    ImageView imageViewFind;

    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(android.R.layout.activity_main);

            Button Capture = (Button) findViewById(R.id.Capture);
            imageViewFind= (imageView)imageView findViewID(R.id.imageViewFind);
            // Disable Button in camera if user does not have camera
            if(hasCamera())
                imageViewFind.setEnable(false);
    }

    // Cheack if users has camera
    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    //to connect the camera taken photo to the screen monitor
    //Launching the camera
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take a picture and pass results along to activity results
        startActivityForResult(intent, REQEST_IMAGE_CAPTURE);
    }

    //return image

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //GET THE PHOTO
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            imageViewFind.setImageBitmap(photo);
        }
    }
}
