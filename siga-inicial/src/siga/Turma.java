package siga;

import java.util.ArrayList;

public class Turma {
    public ArrayList<Aluno> alunos; //estamos utilizando composição, onde turma contém alunos
    private String semestre;

    public Turma(ArrayList<Aluno> alunos, String semestre) {
        this.alunos = alunos;
        this.semestre = semestre;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
