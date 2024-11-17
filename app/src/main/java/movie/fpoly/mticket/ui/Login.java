package movie.fpoly.mticket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import movie.fpoly.mticket.R;

public class Login extends AppCompatActivity {
    private EditText username, password;
    private TextView login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(v -> {
            startActivity(new Intent( Login.this, Home.class));
            finish();
        });

        register.setOnClickListener(v -> {
            startActivity(new Intent( Login.this, Register.class));
        });
    }
}