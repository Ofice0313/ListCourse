package devandroid.ofice.listcourse.controller;

import android.util.Log;

import devandroid.ofice.listcourse.model.Pessoa;

public class PessoaController {
    public void salvar(Pessoa pessoa) {

        Log.i("MVC_Controller", "Salvo: " + pessoa.toString());
    }
}
