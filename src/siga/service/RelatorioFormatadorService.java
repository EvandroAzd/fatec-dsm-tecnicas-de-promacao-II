package siga.service;

import siga.dao.AlunoDAO;
import siga.dao.MatriculaDAO;

import java.util.List;

public class RelatorioFormatadorService {
    public String formatar(List<MatriculaDAO> matriculas) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Relatório de Alunos ===\n");
        for (MatriculaDAO matricula : matriculas) {
            sb.append(matricula.getNumMatricula())
                    .append(" - ")
                    .append(matricula.getAluno().getNome())
                    .append(" - média: ")
                    .append(matricula.getAluno().getMedia())
                    .append("\n");
        }
        return sb.toString();
    }
}
