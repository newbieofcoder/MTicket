package movie.fpoly.mticket.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import movie.fpoly.mticket.R;

public class Register extends AppCompatActivity {
    private static final String PASSWORD_REGEX_LONG = "^.{6,}$";
    private static final String PASSWORD_REGEX_LETTER = "^(?=.*[a-z])(?=.*[A-Z]).{1,}$";
    private static final String PASSWORD_REGEX_NUMBER = "^(?=.*\\d).{1,}$";
    private static final String PASSWORD_REGEX_SPECIAL_CHARACTER = "^(?=.*[!@#$%^&*(),.?\":{}|<>]).{1,}$";
    private EditText username, password, re_password;
    private TextView register, back;
    private TextView tvValidateLength, tvValidateLetter, tvValidateNumber, tvValidateSpecialCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        re_password = findViewById(R.id.re_password);
        register = findViewById(R.id.register);
        back = findViewById(R.id.back);
        tvValidateLength = findViewById(R.id.tvValidateLength);
        tvValidateLetter = findViewById(R.id.tvValidateLetter);
        tvValidateNumber = findViewById(R.id.tvValidateNumber);
        tvValidateSpecialCharacter = findViewById(R.id.tvValidateSpecialCharacter);

        tvValidateLength.setVisibility(View.INVISIBLE);
        tvValidateLetter.setVisibility(View.INVISIBLE);
        tvValidateNumber.setVisibility(View.INVISIBLE);
        tvValidateSpecialCharacter.setVisibility(View.INVISIBLE);

        back.setOnClickListener(v -> {
            finish();
        });
        register.setOnClickListener(v -> {
            String username = this.username.getText().toString();
            String password = this.password.getText().toString();
            String re_password = this.re_password.getText().toString();
            if (username.isEmpty() || password.isEmpty() || re_password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            } else if (password.length() < 6 || username.length() < 6) {
                Toast.makeText(this, "Mật khẩu và tên đăng nhập phải có ít nhất 6 ký tự", Toast.LENGTH_SHORT).show();
                return;
            } else if (!password.equals(re_password)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            } else {
                registerWithUsernameAndPassword(username, password);
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        re_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isValid(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void registerWithUsernameAndPassword(String username, String password) {
    }

    private boolean isValid(String password) {
        tvValidateLength.setVisibility(View.VISIBLE);
        tvValidateLetter.setVisibility(View.VISIBLE);
        tvValidateNumber.setVisibility(View.VISIBLE);
        tvValidateSpecialCharacter.setVisibility(View.VISIBLE);
        if (password.matches(PASSWORD_REGEX_LONG)) {
            tvValidateLength.setTextColor(getResources().getColor(R.color.green));
        } else {
            tvValidateLength.setTextColor(getResources().getColor(R.color.red));
        }
        if (password.matches(PASSWORD_REGEX_LETTER)) {
            tvValidateLetter.setTextColor(getResources().getColor(R.color.green));
        } else {
            tvValidateLetter.setTextColor(getResources().getColor(R.color.red));
        }
        if (password.matches(PASSWORD_REGEX_NUMBER)) {
            tvValidateNumber.setTextColor(getResources().getColor(R.color.green));
        } else {
            tvValidateNumber.setTextColor(getResources().getColor(R.color.red));
        }
        if (password.matches(PASSWORD_REGEX_SPECIAL_CHARACTER)) {
            tvValidateSpecialCharacter.setTextColor(getResources().getColor(R.color.green));
        } else {
            tvValidateSpecialCharacter.setTextColor(getResources().getColor(R.color.red));
        }
        return password.matches(PASSWORD_REGEX_LONG) && password.matches(PASSWORD_REGEX_LETTER)
                && password.matches(PASSWORD_REGEX_NUMBER) && password.matches(PASSWORD_REGEX_SPECIAL_CHARACTER);
    }
}