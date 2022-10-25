package jp.ac.ecc.se.ecc_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView fullView = findViewById(R.id.fullView);

        Intent intent = getIntent();
        Uri imageUri =  (intent!=null)?intent.getParcelableExtra("image"):null;
        fullView.setImageURI(imageUri);
    }

}