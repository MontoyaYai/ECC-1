package jp.ac.ecc.se.ecc_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Intent intent= getIntent();
        int age= intent.getIntExtra("age",25);
        Toast.makeText(this, "年齢："+ age, Toast.LENGTH_SHORT).show();

        TextView textProfile= findViewById(R.id.profile);
        EditText pass= findViewById(R.id.pass);
        EditText name= findViewById(R.id.name);
        Button clear1= findViewById(R.id.boton1);
        Button clear2= findViewById(R.id.boton2);
        CheckBox check10= findViewById(R.id.checkBox1);
        CheckBox check20= findViewById(R.id.checkBox2);
        CheckBox check30= findViewById(R.id.checkBox3);
        RadioButton radioWoman= findViewById(R.id.woman);
        RadioButton radioMan= findViewById(R.id.man);
        Button kakuninButton= findViewById(R.id.boton3);

        clear1.setOnClickListener(this);
        clear2.setOnClickListener(this);
        kakuninButton.setOnClickListener(this);

        kakuninButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(radioMan.isChecked()==true){
                    Toast.makeText(getApplicationContext(), R.string.mane, Toast.LENGTH_SHORT).show();
                }else if (radioWoman.isChecked()==true){
                    Toast.makeText(getApplicationContext(),R.string.woman, Toast.LENGTH_SHORT).show();
                }
                finish();
                return false;
            }
        });


        clear2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setTitle(pass.getText());
                return false;
            }
        });
    }
    @Override
    public void onClick(View view){
        EditText name= findViewById(R.id.name);
        EditText pass= findViewById(R.id.pass);
        switch (view.getId()){
            case R.id.boton1:
                Toast.makeText(this, name.getText(), Toast.LENGTH_SHORT).show();
                name.setText("");
                break;
            case R.id.boton2:
                pass.setText("");
                setTitle(R.string.app_name);
                break;
            case R.id.boton3:
                Toast.makeText(this, name.getText(), Toast.LENGTH_SHORT).show();

        }
    }
}