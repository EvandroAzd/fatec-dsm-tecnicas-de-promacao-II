package siga.service;

public class DescontoConvenioService implements DescontoMatriculaService {
    @Override
    public double aplicar(double valorBase) {
        double valorApagar = valorBase * 0.8;
        return  valorApagar;
    }
}
