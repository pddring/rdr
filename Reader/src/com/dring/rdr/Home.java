package com.dring.rdr;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    
    public void scanImage(View view) {
    	Toast.makeText(this, "Button pressed", Toast.LENGTH_SHORT).show();
    	Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, R.integer.camera_result);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(resultCode!= -1) {
    		Toast.makeText(this, "Error: code: " + requestCode + " result: " + resultCode, Toast.LENGTH_SHORT).show();
    		return;
    	}
    	
    	switch(requestCode) {
    	// got image from camera
    	case R.integer.camera_result:
    		ImageView iv = (ImageView) findViewById(R.id.imgPreview);
    		Bundle extras = data.getExtras();
    		Bitmap bm = (Bitmap)extras.get("data");
    		iv.setImageBitmap(bm);
    		break;
    	}
    	
    }
}
