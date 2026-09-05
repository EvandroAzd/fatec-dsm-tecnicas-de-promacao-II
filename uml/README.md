# Modelagem UML — Sistema Acadêmico

Exercício de modelagem orientada a objetos cobrindo diagrama de classes (entidades, herança, agregação, interface) e diagrama de sequência para o cálculo da mensalidade.

## Diagrama de classes

```mermaid
classDiagram
    class Pessoa {
        <<abstract>>
        -nome: String
        -cpf: String
        #dataNascimento: Date
        +getNome() String
        +getCpf() String
        +getIdade() int
    }

    class Aluno {
        -ra: String
        -matriculas: List~Matricula~
        +getRa() String
        +adicionarMatricula(m: Matricula) void
        +getMatriculas() List~Matricula~
    }

    class Professor {
        -registro: String
        #salario: double
        +getRegistro() String
        +getSalario() double
    }

    class Disciplina {
        -codigo: String
        -nome: String
        -cargaHoraria: int
        +getCodigo() String
        +getNome() String
    }

    class Turma {
        -codigo: String
        -periodo: String
        -alunos: List~Aluno~
        +adicionarAluno(a: Aluno) void
        +removerAluno(a: Aluno) void
        +getAlunos() List~Aluno~
    }

    class Matricula {
        -numero: String
        -dataInicio: Date
        -valorBase: double
        -status: String
        +calcularMensalidade() double
        +getValorBase() double
    }

    class Desconto {
        <<interface>>
        +aplicar(valorBase: double) double
    }

    class DescontoBolsista {
        -percentual: double
        +aplicar(valorBase: double) double
    }

    class DescontoPontualidade {
        -percentual: double
        +aplicar(valorBase: double) double
    }

    class SemDesconto {
        +aplicar(valorBase: double) double
    }

    Pessoa <|-- Aluno
    Pessoa <|-- Professor

    Turma o-- "1..*" Aluno : contém
    Turma --> "1" Disciplina
    Turma --> "1" Professor : ministrada por

    Aluno "1" --> "1..*" Matricula : possui
    Matricula --> "1" Turma : em
    Matricula --> "1" Desconto : usa

    Desconto <|.. DescontoBolsista
    Desconto <|.. DescontoPontualidade
    Desconto <|.. SemDesconto

    classDef interfaceStyle stroke:#818cf8,fill:#eef2ff
    classDef concreteStyle stroke:#fb923c,fill:#fff7ed
    classDef serviceStyle stroke:#2dd4bf,fill:#f0fdfa
    classDef abstractStyle stroke:#a3a3a3,fill:#f5f5f5

    cssClass "Pessoa" abstractStyle
    cssClass "Desconto" interfaceStyle
    cssClass "DescontoBolsista,DescontoPontualidade,SemDesconto" concreteStyle
    cssClass "Matricula" serviceStyle
```

### Decisões de modelagem

| Etapa | Decisão | Justificativa |
|---|---|---|
| 1 | `Pessoa` é abstrata | Nunca existe uma "pessoa genérica" no sistema, só Aluno ou Professor. |
| 2 | Generalização `Pessoa <\|-- Aluno / Professor` | Ambos compartilham identificação e dados pessoais. |
| 3 | `Turma o-- Aluno` (agregação) | O Aluno continua existindo se a Turma for encerrada. |
| 4 | `Matricula --> Desconto` (interface) | Princípio da Inversão de Dependência: `Matricula` depende da abstração, nunca de uma implementação concreta. `SemDesconto` evita `null` (Null Object). |
| — | `Matricula` liga `Aluno` a `Turma` | A matrícula é a ponte entre o aluno e o que ele cursa, e por isso guarda `valorBase` e calcula a mensalidade. |

## Diagrama de sequência — cálculo da mensalidade

```mermaid
sequenceDiagram
    actor Secretaria
    participant Aluno
    participant Matricula
    participant Desconto as Desconto «interface»
    participant DescontoBolsista

    Secretaria->>Aluno: getMatriculas()
    Aluno-->>Secretaria: lista de Matricula

    Secretaria->>Matricula: calcularMensalidade()
    activate Matricula
    Matricula->>Matricula: getValorBase()
    Matricula->>Desconto: aplicar(valorBase)
    activate Desconto
    Note over Desconto,DescontoBolsista: Em tempo de execução,<br/>Desconto é uma instância de DescontoBolsista
    Desconto->>DescontoBolsista: aplicar(valorBase)
    DescontoBolsista-->>Desconto: valorComDesconto
    deactivate Desconto
    Desconto-->>Matricula: valorComDesconto
    Matricula-->>Secretaria: mensalidade
    deactivate Matricula
```

O fluxo mostra `Matricula` chamando `Desconto.aplicar()` sem conhecer qual implementação está por trás — a mesma abstração do diagrama de classes, agora vista em tempo de execução.
