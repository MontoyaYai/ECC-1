package jp.ac.ecc.se.ecc_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //EditText thoughtsText=findViewById(R.id.thoughtsText);
        SharedPreferences pref =getPreferences(Context.MODE_PRIVATE);
        Intent preferenceIntent = new Intent(this, PreferencesActivity.class);

        String [] curryList={"ドライカレー","カツカレー","チーズカレー","スープカレー"};

        ListView listView = findViewById(R.id.curryList);
        ArrayAdapter<String> adapter =
                new ArrayAdapter(this, android.R.layout.simple_list_item_1,curryList);

       Intent memo = new Intent(this, PreferencesActivity.class);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String st=(String) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),st,Toast.LENGTH_SHORT).show();
                preferenceIntent.putExtra("curry",i);
                startActivity(preferenceIntent);

            }
        });
    }

}