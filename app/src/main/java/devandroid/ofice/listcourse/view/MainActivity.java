package devandroid.ofice.listcourse.view;

import android.os.Bundle;
import android.util.Log;

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

        pessoa.setPrimeiroNome("Marcelo");
        pessoa.setSobrenome("Ofice");
        pessoa.setNumeroTelefone("877312374");
        pessoa.setCurso(new Curso("Programação"));


        Log.i("POO", pessoa.toString());
        int parada = 0;
    }
}