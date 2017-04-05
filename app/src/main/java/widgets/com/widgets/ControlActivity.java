package widgets.com.widgets;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ControlActivity extends AppCompatActivity {
    EditText edtName, edtPhone, edtEmail, edtDob, edtPassword;
    RadioButton rbtMale, rbtFemale;
    CheckBox chkTnC;
    Switch swtSubscribe;
    SeekBar skbAge;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        btnSignUp = (Button) findViewById(R.id.btnLogin);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName = (EditText) findViewById(R.id.edtName);
                edtEmail = (EditText) findViewById(R.id.edtEmail);
                edtPhone = (EditText) findViewById(R.id.edtPhone);
                edtDob = (EditText) findViewById(R.id.edtDoB);
                edtPassword = (EditText) findViewById(R.id.edtPassword);
                rbtMale = (RadioButton) findViewById(R.id.rbtMale);
                rbtFemale = (RadioButton) findViewById(R.id.rbtFemale);
                chkTnC = (CheckBox) findViewById(R.id.chkTnC);
                swtSubscribe = (Switch) findViewById(R.id.swtSubscribe);
                skbAge = (SeekBar) findViewById(R.id.skbAge);

                int age = skbAge.getProgress();
                boolean emailValid = false, passValid = false, ageValid = false;
                if(Validator.validateAge(age) == "valid"){
                    ageValid = true;
                }
                else{
                    ageValid = false;
                    Toast.makeText(ControlActivity.this, "Age is Invalid!", Toast.LENGTH_LONG).show();
                    Log.d("Age Testing", Validator.validateAge(age) + " "+ age);
                }

                if(Validator.validEmail(edtEmail.getText().toString())){
                    emailValid = true;
                }
                else {
                    emailValid = false;
                    Toast.makeText(ControlActivity.this, "Email Address is Invalid!", Toast.LENGTH_LONG).show();
                }

                if(Validator.validPassword(edtPassword.getText().toString())){
                    passValid = true;
                }
                else{
                    passValid = false;
                    Toast.makeText(ControlActivity.this, "Password is Invalid!", Toast.LENGTH_LONG).show();
                }
                if(passValid && emailValid && ageValid && chkTnC.isChecked() && swtSubscribe.isChecked()){
                    String email = edtEmail.getText().toString();
                    String name = edtName.getText().toString();
                    String gender;
                    if(rbtMale.isChecked()){
                        gender = "Male";
                    }
                    else{
                        gender = "Female";
                    }
                    String password = edtPassword.getText().toString();
                    Intent i1 = new Intent(ControlActivity.this, ProcessForm.class);
                    i1.putExtra("email", email);
                    i1.putExtra("name", edtName.getText().toString());
                    i1.putExtra("age", age);
                    i1.putExtra("password",password);
                    i1.putExtra("gender", gender);
                    startActivity(i1);
                }
            }
        });
    }
}
