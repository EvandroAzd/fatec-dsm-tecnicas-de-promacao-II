package siga.service;

public class DescontoFuncionarioService implements DescontoMatriculaService {
    @Override
    public void aplicar(double valorBase) {
        double valorApagar = valorBase * 0.7;
    }
}
