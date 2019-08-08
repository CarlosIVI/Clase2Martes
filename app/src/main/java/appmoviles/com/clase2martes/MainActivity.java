package appmoviles.com.clase2martes;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //COMPONENTES
    private EditText loginUsernameEt;
    private EditText loginPasswordEt;
    private Button loginLoginBtn;
    private Button loginSignupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUsernameEt = findViewById(R.id.login_username_et);
        loginPasswordEt = findViewById(R.id.login_password_et);
        loginLoginBtn = findViewById(R.id.login_login_btn);
        loginSignupBtn = findViewById(R.id.login_signup_btn);

        loginLoginBtn.setText("OK");
        loginLoginBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = loginUsernameEt.getText().toString();
                        String password = loginPasswordEt.getText().toString();
                        Toast.makeText(MainActivity.this, username+","+password, Toast.LENGTH_SHORT).show();

                    }
                }
        );


        loginSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUpActivity.class);
                i.putExtra( "username",  loginUsernameEt.getText().toString() );
                startActivityForResult(i, 11);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 11 && resultCode == RESULT_OK){
            String resultado = data.getExtras().getString("resultado");
            Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();
        }
    }
}
