package movie.fpoly.mticket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import movie.fpoly.mticket.DAO.UserDao;
import movie.fpoly.mticket.R;
import movie.fpoly.mticket.databases.DatabaseHelper;
import movie.fpoly.mticket.models.Users;
import movie.fpoly.mticket.ui_manager.Administration;

public class Login extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private UserDao userDAO;
    private List<Users> usersList = new ArrayList<>();
    private EditText username, password;
    private TextView login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper = new DatabaseHelper(this);
        userDAO = new UserDao(this);
        usersList = userDAO.getUsers("SELECT * FROM USERS");

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
            } else {
                for (int i = 0; i < usersList.size(); i++) {
                    if (usernameLogin.equals(usersList.get(i).getUsername()) && passwordLogin.equals(usersList.get(i).getPassword())) {
                        Intent intent = new Intent(Login.this, Home.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", usersList.get(i));
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });

        register.setOnClickListener(v -> {
            startActivity(new Intent( Login.this, Register.class));
        });
    }
}