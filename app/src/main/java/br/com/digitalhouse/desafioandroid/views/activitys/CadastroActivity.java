package br.com.digitalhouse.desafioandroid.views.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.desafioandroid.R;

public class CadastroActivity extends AppCompatActivity {
    private TextInputLayout inputNome;
    private TextInputLayout inputEmail;
    private TextInputLayout inputSenha;
    private TextInputLayout inputRepeatSenha;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initViews();

        aoClicarNoBotaoRegister();

    }

    public void initViews() {
        inputNome = findViewById(R.id.cadastronome);
        inputEmail = findViewById(R.id.cadastroemail);
        inputSenha = findViewById(R.id.inputPassword);
        inputRepeatSenha = findViewById(R.id.inputRepeatPassword);
        btnRegister = findViewById(R.id.btnRegister);

    }

    private void vibrar(int i) {
        Vibrator rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long milliseconds = 30;
        rr.vibrate(milliseconds);
    }

    private void aoClicarNoBotaoRegister() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!inputNome.getEditText().getText().toString().isEmpty() &&
                        !inputEmail.getEditText().getText().toString().isEmpty() &&
                        !inputSenha.getEditText().getText().toString().isEmpty() &&
                        !inputRepeatSenha.getEditText().getText().toString().isEmpty() && inputSenha.getEditText().getText().toString().equals(inputRepeatSenha.getEditText().getText().toString())) {

                    Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);

                    startActivity(intent);
                } else if (!inputSenha.getEditText().getText().toString().equals(inputRepeatSenha.getEditText().getText().toString())) {
                    vibrar(400);
                    inputSenha.setError("As senhas devem ser iguais");
                    inputRepeatSenha.setError("As senhas devem ser iguais");

                } else {
                    vibrar(400);
                    inputNome.setError("Campo obrigatório");
                    inputEmail.setError("Campo obrigatório");
                    inputSenha.setError("Campo obrigatório");
                    inputRepeatSenha.setError("Campo obrigatório");

                }
            }
        });
    }
}
