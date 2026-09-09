package siga;

public class FabricaPainel {
    public static Painel criar(String tipoUsuario){
        Painel painel;

        if (tipoUsuario.equals("ALUNO")) {
            painel = new PainelAluno();
        } else if (tipoUsuario.equals("PROFESSOR")) {
            painel = new PainelProfessor();
        } else if (tipoUsuario.equals("COORDENADOR")) {
            painel = new PainelCoordenador();
        } else {
            throw new IllegalArgumentException("Perfil desconhecido: " + tipoUsuario);
        }

        return painel;
    }
}
