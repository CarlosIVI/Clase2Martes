package appmoviles.com.clase2martes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText signupNombreEt, signupPassEt, signupRepassEt;
    private Button signupRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        String username = this.getIntent().getExtras().getString("username");

        signupNombreEt = findViewById(R.id.signup_nombre_et);
        signupPassEt = findViewById(R.id.signup_pass_et);
        signupRepassEt = findViewById(R.id.signup_repass_et);
        signupRegBtn = findViewById(R.id.signup_reg_btn);

        signupNombreEt.setText(username);


        signupRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });

    }

    private void validar() {
        String pass = signupPassEt.getText().toString().trim();
        String repass = signupRepassEt.getText().toString().trim();
        if(pass.isEmpty() || repass.isEmpty()){
            Toast.makeText(this, "Uno de los campos esta vacio", Toast.LENGTH_SHORT).show();
            return;
        }
        if(! pass.equals(repass) ){
            Toast.makeText(this, "No coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        //Enviar CallBack
        Intent i = new Intent();
        i.putExtra("resultado", "REGISTRO EXITOSO");
        setResult( RESULT_OK, i );
        finish();

    }
}
