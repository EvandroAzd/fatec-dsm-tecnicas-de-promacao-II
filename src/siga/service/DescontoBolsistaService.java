package siga.service;

public class DescontoBolsistaService implements DescontoMatriculaService {
    @Override
    public double aplicar(double valorBase) {
        double valorApagar = valorBase * 0.5;
        return  valorApagar;
    }
}
