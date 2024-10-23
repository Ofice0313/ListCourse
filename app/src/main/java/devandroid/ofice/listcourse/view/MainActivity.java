package devandroid.ofice.listcourse.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.ofice.listcourse.R;
import devandroid.ofice.listcourse.model.Curso;
import devandroid.ofice.listcourse.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    String dadosPessoa;
    String dadosOutraPessoa;

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

        Pessoa pessoa = new Pessoa();

        Curso curso = new Curso();

        curso.setNome("Android");
        pessoa.setCurso(curso);
        pessoa.setPrimeiroNome("Marcelo");
        pessoa.setSobrenome("Ofice");
        pessoa.setNumeroTelefone("877312374");

        editPrimeiroNome = findViewById(R.id.edit_primeiro_nome);
        editSobrenome = findViewById(R.id.edit_sobrenome);
        editNomeDoCurso = findViewById(R.id.edit_nome_curso);
        editTelefone = findViewById(R.id.edit_telefone);

        btnLimpar = findViewById(R.id.btn_limpar);
        btnSalvar = findViewById(R.id.btn_salvar);
        btnfinalizar = findViewById(R.id.btn_finalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editNomeDoCurso.setText(pessoa.getCurso().getNome());
        editTelefone.setText(pessoa.getNumeroTelefone());

        Log.i("POO", pessoa.toString());
        int parada = 0;
    }
}