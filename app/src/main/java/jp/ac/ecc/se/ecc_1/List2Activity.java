package jp.ac.ecc.se.ecc_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

public class List2Activity extends AppCompatActivity  {
    ArrayList<String> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        Intent intentSub = new Intent(this,SubActivity.class);
        Intent intentEvent= new Intent(this, EventActivity.class);



        Button dataB= findViewById(R.id.dataIn);
        EditText textIn = findViewById(R.id.textInput);
        //dataB.setOnClickListener( this);



        ArrayAdapter<String> adapter =
                        new ArrayAdapter(this, android.R.layout.simple_list_item_1,dataList);
        ListView listView = findViewById(R.id.dataList);

        listView.setAdapter(adapter);

        dataB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!textIn.getText().toString().equals("")) {
                    dataList.add(textIn.getText().toString());
                    listView.setAdapter(adapter);
                    textIn.setText("");
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i%2){
                    case 1: startActivity(intentEvent);
                    break;
                    case 0:startActivity(intentSub);
                }
            }
        });
    }

}
