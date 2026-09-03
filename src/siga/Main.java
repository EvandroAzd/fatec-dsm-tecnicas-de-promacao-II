package siga;

import siga.dao.AlunoDAO;
import siga.dao.MatriculaDAO;
import siga.repository.GravadorMySQL;
import siga.repository.MatriculaRepository;
import siga.repository.RelatorioRepository;
import siga.service.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Refatoração SOLID (código inicial) ===\n");

        List<AlunoDAO> alunos = Arrays.asList(
                new AlunoDAO("Evandro", "azevedo@gmail.com", 9.0, true),
                new AlunoDAO("Maria Silva", "maria@exemplo.edu", 6.0, false),
                new AlunoDAO("João", "joao@exemplo.edu", 7.5, true)
        );

        // PROBLEMA 1 (SRP): uma única classe formata, grava E envia o relatório. RESOLVIDO
        MatriculaRepository repositorio = new GravadorMySQL();
        List <MatriculaDAO> matriculas = Arrays.asList(
                new MatriculaDAO(2026003, alunos.get(0), 1000, TipoDesconto.BOLSISTA, repositorio),
                new MatriculaDAO(2902003, alunos.get(1), 1000, TipoDesconto.VAZIO, repositorio),
                new MatriculaDAO(2125203, alunos.get(2), 1000, TipoDesconto.CONVENIO, repositorio)
        );
        RelatorioFormatadorService relatorioFormatadorService = new RelatorioFormatadorService();
        String conteudo = relatorioFormatadorService.formatar(matriculas);
        RelatorioRepository relatorioRepository = new RelatorioRepository();
        relatorioRepository.salvarEmArquivo(conteudo, "home/Documents");
        EmailService emailService = new EmailService();
        emailService.enviarPorEmail(conteudo, "contato@empresa.com.br");

        // PROBLEMA 2 (OCP): o cálculo usa condicionais que crescem a cada desconto. RESOLVIDO
        DescontoBolsistaService desconto = new DescontoBolsistaService();
        double mensalidade = desconto.aplicar(matriculas.get(0).getValorBase());
        System.out.println("Aluno: " + alunos.get(0).getNome() + "/ Mensalidade (bolsista): R$" + mensalidade);

        SemDescontoService semDesconto = new SemDescontoService();
        double mensalidade2 = semDesconto.aplicar(matriculas.get(1).getValorBase());
        System.out.println("Aluno: " + alunos.get(1).getNome() + "/ Mensalidade (sem desconto): R$" + mensalidade2);

        DescontoConvenioService descontoConvenio = new DescontoConvenioService();
        double mensalidade3 = descontoConvenio.aplicar(matriculas.get(2).getValorBase());
        System.out.println("Aluno: " + alunos.get(2).getNome() + "/ Mensalidade (convênio): R$" + mensalidade3);

        System.out.println();
        // PROBLEMA 3 (DIP): Matricula depende diretamente de GravadorMySQL.
        matriculas.get(0).salvar(mensalidade);
        matriculas.get(1).salvar(mensalidade2);
        matriculas.get(2).salvar(mensalidade3);
    }
}
