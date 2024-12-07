package movie.fpoly.mticket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import movie.fpoly.mticket.R;
import movie.fpoly.mticket.ui_manager.Administration;

public class Login extends AppCompatActivity {
    private EditText username, password;
    private TextView login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(v -> {
            String usernameLogin = username.getText().toString();
            String passwordLogin = password.getText().toString();
            if (usernameLogin.isEmpty() || passwordLogin.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else if (usernameLogin.equals("admin") && passwordLogin.equals("admin")) {
                Toast.makeText(this, "Đăng nhập quản trị viên thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( Login.this, Administration.class);
                startActivity(intent);
                finish();
            } else if (usernameLogin.equals("user") && passwordLogin.equals("user")) {
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(v -> {
            startActivity(new Intent( Login.this, Register.class));
        });
    }
}