package jp.ac.ecc.se.ecc_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView nameLabel= findViewById(R.id.nameLabel);
        EditText nameText=findViewById(R.id.nameText2);
        Button clearButton=findViewById(R.id.clear);
        Button confirmButton= findViewById(R.id.confirmButton);
        Button sendButton= findViewById(R.id.send);

        nameLabel.setText("name");

        sendButton.setOnClickListener((View.OnClickListener) this);
        confirmButton.setOnClickListener((View.OnClickListener)this);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }
        });
    }
    @Override
    public void onClick(View view){
        Intent intent= new Intent(this, EventActivity.class);
        setTitle("Button Clicked");
        switch (view.getId()){
            case R.id.send:
                setTitle("送信 Button Clicked");
                Toast.makeText(this, "送信クリック", Toast.LENGTH_SHORT).show();
                intent.putExtra("q ",19);
                startActivity(intent);
                break;
            case R.id.confirmButton:
                setTitle("確認 Button Clicked");
                Toast.makeText(this, "確認クリック", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
