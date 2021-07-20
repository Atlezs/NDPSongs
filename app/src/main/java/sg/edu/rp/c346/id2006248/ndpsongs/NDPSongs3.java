package sg.edu.rp.c346.id2006248.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NDPSongs3 extends AppCompatActivity {

    EditText etSongID, etName, etYear, etSong;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rg;
    RadioButton rb,rb2,rb3,rb4,rb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndpsongs3);

        etSongID = findViewById(R.id.etSongID);
        etName = findViewById(R.id.etName2);
        etYear = findViewById(R.id.etYear2);
        etSong = findViewById(R.id.etSong2);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        rg = findViewById(R.id.rg2);
        rb = findViewById(R.id.rb);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);

        Intent intent = getIntent();
        Song data = (Song) intent.getSerializableExtra("data");

        etSongID.setText(String.valueOf(data.getId()));
        etSong.setText(data.getTitle());
        etName.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));


        int stars = data.getStars();

        if(stars == 1) {
            rb.setChecked(true);
        }
        else if (stars == 2) {
            rb2.setChecked(true);
        }
        else if (stars == 3) {
            rb3.setChecked(true);
        }
        else if (stars == 4) {
            rb4.setChecked(true);
        }
        else if (stars == 5) {
            rb5.setChecked(true);
        }

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(NDPSongs3.this);
                dbh.deleteSong(data.getId());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(NDPSongs3.this);
                data.setTitle(etSong.getText().toString());
                data.setSingers(etName.getText().toString());
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

                data.setYear(intData3);
                data.setStars(radioBtn);
                dbh.updateSong(data);
                dbh.close();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NDPSongs3.this,NDPSongs2.class);
                startActivity(intent);
            }
        });

    }
}