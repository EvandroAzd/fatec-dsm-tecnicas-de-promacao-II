# SIGA — Sistema de Gestão Acadêmica Simplificado

**Técnicas de Programação II** · CST em Desenvolvimento de Software Multiplataforma · Fatec Porto Ferreira

## Pré-requisito

JDK 17 ou superior instalado. Para verificar:

```bash
java -version
```

## Como compilar e executar (terminal)

Na raiz do projeto:

```bash
# 1. Criar a pasta de saída (apenas na primeira vez)
mkdir -p bin

# 2. Compilar todos os arquivos fonte
javac -d bin src/siga/*.java

# 3. Executar
java -cp bin siga.Main
```

## Como executar pelo IntelliJ IDEA

1. Abra o IntelliJ IDEA e selecione **File > Open**, apontando para a pasta `siga-inicial`.
2. Aguarde o projeto ser indexado.
3. Abra o arquivo `src/siga/Main.java`.
4. Clique no botão **Run** (▶) ao lado do método `main` ou pressione `Shift + F10`.

## Estrutura do projeto

```
siga-inicial/
├── src/
│   └── siga/
│       ├── Pessoa.java
│       ├── Aluno.java
│       ├── Professor.java
│       ├── Turma.java
│       ├── Matricula.java
│       ├── TipoDesconto.java
│       └── Main.java
└── README.md
```
