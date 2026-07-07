package com.example.demo_e18;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout etUsernameLayout;
    TextInputEditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            var keyboardInset = insets.getInsets(WindowInsetsCompat.Type.ime());// Input Method Editor
            v.setPadding(systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom + keyboardInset.bottom);
            return insets;
        });

        ConstraintLayout mainLayout = findViewById(R.id.main);
        mainLayout.setOnClickListener(v -> {
            hideKeyboard();
        });

        etUsername = findViewById(R.id.etUsername);
        var recieveIntent = getIntent();
        String email = recieveIntent.getStringExtra("email");
        etUsername.setText(email);

        etUsernameLayout = findViewById(R.id.etUsernameLayout);

        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("ET Username", s.toString());
            }
        });

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            String username = Objects.requireNonNull(etUsername.getText()).toString().trim();

            if (username.isEmpty()) {
                etUsernameLayout.setError("Username required");
            } else {
                etUsernameLayout.setError(null);
            }

            hideKeyboard();
        });

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();

        if (view != null) {
            view.clearFocus();

            InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputManager != null) {
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}