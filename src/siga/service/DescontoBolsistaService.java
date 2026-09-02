package siga.service;

public class DescontoBolsistaService implements DescontoMatriculaService {
    @Override
    public void aplicar(double valorBase) {
        double valorApagar = valorBase * 0.5;
    }
}
