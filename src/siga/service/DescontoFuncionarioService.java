package siga.service;

public class DescontoFuncionarioService implements DescontoMatriculaService {
    @Override
    public double aplicar(double valorBase) {
        double valorApagar = valorBase * 0.7;
        return  valorApagar;
    }
}
