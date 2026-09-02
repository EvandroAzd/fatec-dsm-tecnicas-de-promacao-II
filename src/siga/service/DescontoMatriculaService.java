package siga.service;

import siga.dao.MatriculaDAO;

public class DescontoMatriculaService {
        MatriculaDAO matriculaDAO;

        public double calcularMensalidade() {
        if (matriculaDAO.getTipoDesconto() == TipoDesconto.BOLSISTA) {
            return matriculaDAO.getValorBase() * 0.5;
        } else if (matriculaDAO.getTipoDesconto() == TipoDesconto.CONVENIO) {
            return matriculaDAO.getValorBase() * 0.8;
        } else if (matriculaDAO.getTipoDesconto() == TipoDesconto.FUCIONARIO) {
            return matriculaDAO.getValorBase() * 0.7;
        } else {
            return matriculaDAO.getValorBase(); // NENHUM
        }
    }
}
