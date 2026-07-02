package com.example.demo_e18;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
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
    ProgressBar loadingView;

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

        loadingView = findViewById(R.id.loadingView);

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

        handleCheckboxValue();
        handleRadioButton();
    }

    private void handleCheckboxValue() {
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "You select Checkbox 1", Toast.LENGTH_SHORT).show();
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "You select Checkbox 2", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleRadioButton() {
        rdGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                RadioButton rdButton = findViewById(checkedId);

                if (rdButton != null) {
                    String value = rdButton.getText().toString();
                    Toast.makeText(MainActivity.this, "Gender: " + value, Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        } else if (id == R.id.btn3) {
            loadingView.setVisibility(View.VISIBLE);
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            );

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                loadingView.setVisibility(View.GONE);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                btn1.setEnabled(true);
            }, 2000);
        } else if (id == R.id.btnHome) {
            Log.d("Checkbox", "Checkbox 1: " + cb1.isChecked());
            Log.d("Checkbox", "Checkbox 2: " + cb2.isChecked());

            int selectedRdID = rdGroupGender.getCheckedRadioButtonId();
            RadioButton rdButton = findViewById(selectedRdID);

            if (rdButton != null) {
                String value = rdButton.getText().toString();
                Toast.makeText(MainActivity.this, "Gender: " + value, Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
        }
    }
}