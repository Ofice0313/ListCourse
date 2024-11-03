package devandroid.ofice.listcourse.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.ofice.listcourse.R;
import devandroid.ofice.listcourse.controller.PessoaController;
import devandroid.ofice.listcourse.model.Curso;
import devandroid.ofice.listcourse.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    String dadosPessoa;
    String dadosOutraPessoa;

    PessoaController pessoaController;

    SharedPreferences sharedPreferences;
    public static final String NOME_PREFERENCES = "pref_listaVip";

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeDoCurso;
    EditText editTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnfinalizar;

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

        //O Zero significa o nivel de autorizacao que terá o arquivo, nesta o 0 significa leitura e escrita
        sharedPreferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = sharedPreferences.edit(); // significa que o arquivo esta aberto para edição
        Pessoa pessoa = new Pessoa();

        /*pessoa.setCurso("Java");
        pessoa.setPrimeiroNome("Marcelo");
        pessoa.setSobrenome("Ofice");
        pessoa.setNumeroTelefone("877312374");*/

        editPrimeiroNome = findViewById(R.id.edit_primeiro_nome);
        editSobrenome = findViewById(R.id.edit_sobrenome);
        editNomeDoCurso = findViewById(R.id.edit_nome_curso);
        editTelefone = findViewById(R.id.edit_telefone);

        btnLimpar = findViewById(R.id.btn_limpar);
        btnSalvar = findViewById(R.id.btn_salvar);
        btnfinalizar = findViewById(R.id.btn_finalizar);


        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editNomeDoCurso.setText(pessoa.getCurso());
        editTelefone.setText(pessoa.getNumeroTelefone());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeDoCurso.setText("");
                editTelefone.setText("");
            }
        });

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setNumeroTelefone(editTelefone.getText().toString());
                pessoa.setCurso(editNomeDoCurso.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("primeiroNome: ", pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome: ", pessoa.getSobrenome());
                listaVip.putString("curso: ", pessoa.getCurso());
                listaVip.putString("telefone: ", pessoa.getNumeroTelefone());

                listaVip.apply(); //salva os dados.
                pessoaController.salvar(pessoa);
            }
        });

    }
}