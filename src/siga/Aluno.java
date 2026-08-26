package siga;

/**
 * Sistema de Gestão Acadêmica Simplificado (SIGA)
 * Técnicas de Programação II - Fatec de Porto Ferreira
 *
 * ATENÇÃO: código INICIAL da disciplina.
 * Esta classe apresenta, propositalmente, problemas de orientação a objetos
 * que serão corrigidos na atividade prática da Aula 1.
 *
 * Problema principal: os atributos são PÚBLICOS, expondo o estado interno
 * do objeto e permitindo que qualquer código o coloque em um estado inválido
 * (por exemplo, uma média negativa ou maior que 10).
 */
public class Aluno extends Pessoa {

    // Atributos públicos: violação do encapsulamento.

    /*A classe Aluno violava o encapsulamento por conter modificador de acesso do tipo público,
    onde qualquer classe fora do relacionamento de herança poderia ter acesso. Foi substituído
    pelo modificador private, respeitando a herança onde apenas sub-classes tem acesso.
     */

    /*
    private String matricula; - O tipo primitivo String foi substituido pelo de referência Matricula,
    criando assim um relacionamento de associação
    */
    private Matricula matricula;
    private double media;

    // Sem construtor: o objeto pode ser criado em estado incompleto/inconsistente.
    //Para correção podemos colocar uma condição caso a media seja menor do que zero
//    public Aluno(String nome, Matricula matricula, double media) {
//        if(media < 0){
//            System.out.println("Media invalido!");
//            return;
//        }else{
//            this.media = media;
//            this.nome = nome;
//            this.matricula = matricula;
//            this.ativo = true;
//        }
//    }

    //Dessa forma o objeto nem chega a ser instaciado, lançando um exceção antes
    public Aluno(String nome, Matricula matricula, double media) {
        if (media < 0 || media > 10) {
            throw new IllegalArgumentException("Media invalida!");
        }
        this.media = media;
        this.nome = nome;
        this.matricula = matricula;
        this.ativo = true;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public double getMedia() {
        return media;
    }

    //corrigi o erro de lançar media invalida lançando uma exceção, sendo assim o objeto não pode ser instaciado
    public void setMedia(double media) {
        if (media < 0 || media > 10) {
            throw new IllegalArgumentException("Media invalida!");
        }else{
            this.media = media;
        }
    }

    @Override
    public String toString() {
        return "Matricula do Aluno: " + matricula.getNumMatricula() + "\n" +
                "Nome do Aluno: " + this.nome + "\n" +
                "Media: " + this.media + "\n" +
                "Ativo: " + this.ativo + "\n";
    }
}
