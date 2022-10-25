package jp.ac.ecc.se.ecc_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntentActivity extends AppCompatActivity {
    final int CAMERA_RESULT = 100; //camera result
    Uri imageUri; //image from galery


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        //宣言
        EditText searchText = findViewById(R.id.searchText);
        Button searchButton = findViewById(R.id.searchButton);
        Button cameraButton = findViewById(R.id.cameraButton);
        FloatingActionButton floatButton = findViewById(R.id.confirmFab);
        Intent sendImage = new Intent(getApplicationContext(), ImageActivity.class);

        //search button click
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query= searchText.getText().toString();

                //Web search activity
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH); // web search instance
                intent.putExtra(SearchManager.QUERY,query); //send information

                startActivity(intent); //start

            }
        });

        //Camera button click
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //File create
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = "Traning_" + timestamp + "_.jpg";
                //画像ファイルのパラメータの設定
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, fileName);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                //保存画像情報の URI を生成する
                imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // capture image instance
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, CAMERA_RESULT);
            }
        });

        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendImage.putExtra("image",imageUri);
                if (imageUri!= null)
                    startActivity(sendImage);
            }
        });

    }
    //カメラから送られてきた Intent から撮影された画像データを取得する
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMERA_RESULT && resultCode == RESULT_OK){ // camera result== 100;
            //Bitmap bitmap =data.getParcelableExtra("data"); //?

         ImageView cameraImage= findViewById(R.id.cameraImage);  //image instance
//            cameraImage.setImageBitmap(bitmap); //Image id - ???
            cameraImage.setImageURI(imageUri);
        }
    }

}