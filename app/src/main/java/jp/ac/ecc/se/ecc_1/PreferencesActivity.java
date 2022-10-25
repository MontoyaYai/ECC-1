package jp.ac.ecc.se.ecc_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        //ファイルのオブジェクト
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
        //画面部品をアクティビティ内に宣言する


        EditText thoughtsText= findViewById(R.id.thoughtsText);
        Button saveBt =findViewById(R.id.saveButton);
        Button cancelBt=findViewById(R.id.cancelButton);
        //カレーごとにプレフェレンスを分ける
        String menu[]={"dry","cutlet","cheese","soup","memo"};

        //前画面から受け取る
        Intent intent = getIntent();
        int curry = intent.getIntExtra("curry",4);

        String thoughtsSt = pref.getString(menu[curry], "");

//        String thoughtsSt = pref.getString("memo","");

        thoughtsText.setText(thoughtsSt);
        SharedPreferences.Editor editor= pref.edit();

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor= pref.edit();
                editor.putString(menu[curry],thoughtsText.getText().toString());
                editor.apply();
                Toast.makeText(PreferencesActivity.this, "保存しました", Toast.LENGTH_SHORT).show();
            }
        });
        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(PreferencesActivity.this, "終了します", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

    }
}
