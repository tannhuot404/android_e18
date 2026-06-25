package com.example.demo_e18;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHello;
    Button btn1;
    Button btn2;
    Button btn3;

    EditText etName;

    CheckBox cb1;
    CheckBox cb2;

    RadioGroup rdGroupGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvHello = findViewById(R.id.tvHello);
        etName = findViewById(R.id.etName);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        rdGroupGender = findViewById(R.id.rdGroupGender);

        tvHello.setText("Hello world!");

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("ET name", etName.getText().toString());
//            }
//        });
//
//        btn2.setOnClickListener(v -> {
//            Log.d("CB 1", "" + cb1.isChecked());
//            Log.d("CB 2", "" + cb2.isChecked());
//        });

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        ImageButton imgBtn = findViewById(R.id.btnHome);
        imgBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        var id = v.getId();

        if (id == R.id.btn1) {
            Toast.makeText(this, "Button 1 clicked.", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btn2) {
            var view = findViewById(R.id.main);
            var snackBar = Snackbar.make(view, "this is snackbar", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Ok", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
            snackBar.show();
        } else if (id == R.id.btnHome) {
            Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
        }
    }
}