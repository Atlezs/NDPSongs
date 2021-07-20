package sg.edu.rp.c346.id2006248.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etSong, etName, etYear;
    Button btnInsert, btnList;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSong = findViewById(R.id.etSong);
        etName = findViewById(R.id.etName);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);
        rg = findViewById(R.id.RadioGroup);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NDPSongs2.class);
                startActivity(intent);
            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etSong.getText().toString();
                String data2 = etName.getText().toString();
                String data3 = etYear.getText().toString();
                int intData3 = Integer.parseInt(data3);
                int checkedRadioID = rg.getCheckedRadioButtonId();
                int radioBtn;
                if(checkedRadioID == R.id.radioButton){
                    radioBtn = 1;
                }
                else if(checkedRadioID == R.id.radioButton2){
                    radioBtn = 2;
                }
                else if(checkedRadioID == R.id.radioButton3){
                    radioBtn = 3;
                }
                else if(checkedRadioID == R.id.radioButton4){
                    radioBtn = 4;
                }
                else{
                    radioBtn = 5;
                }


                DBHelper dbh = new DBHelper(MainActivity.this);
                dbh.insertSong(data, data2, intData3, radioBtn);
                Toast.makeText(MainActivity.this,"Insert Successful",Toast.LENGTH_LONG).show();
            }
        });

    }
}