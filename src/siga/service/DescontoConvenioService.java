package siga.service;

public class DescontoConvenioService implements DescontoMatriculaService {
    @Override
    public void aplicar(double valorBase) {
        double valorApagar = valorBase * 0.8;
    }
}
