package devandroid.ofice.listcourse.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.ofice.listcourse.model.Curso;

public class CursoController {

    public List listCursos;



    public List getListCursos(){


        listCursos  = new ArrayList<Curso>();

        listCursos.add( new Curso("SQL Server"));
        listCursos.add( new Curso("Azure DataBase"));
        listCursos.add( new Curso("AWS"));
        listCursos.add( new Curso("Spring Boot"));
        listCursos.add( new Curso("C#"));
        listCursos.add( new Curso("Kotlin"));
        listCursos.add( new Curso("Figma"));
        listCursos.add( new Curso("Flutter"));

        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner(){

        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListCursos().size(); i++) {
            Curso objecto = (Curso) getListCursos().get(i);
            dados.add(objecto.getNome());
        }
        return dados;
    }
}
