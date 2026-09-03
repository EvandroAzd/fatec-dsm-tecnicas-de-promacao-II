# SIGA — Refatoração SOLID

## Code smells encontrados no código original

| Code smell | Onde | Descrição |
|---|---|---|
| **God Class** | `RelatorioAluno.java` | A classe acumulava três responsabilidades distintas: formatar, gravar em disco e enviar e-mail. Qualquer mudança em uma dessas áreas exigia mexer na mesma classe. |
| **Long Method / Conditional Complexity** | `Matricula.java` — `calcularMensalidade()` | O método usava uma cadeia de `if/else` por tipo de desconto. A cada novo tipo, era necessário abrir e modificar o método, aumentando o risco de regressão. |
| **Inappropriate Intimacy** | `Matricula.java` | A classe instanciava `GravadorMySQL` diretamente com `new`, criando acoplamento rígido com uma implementação concreta de persistência. Trocar o banco de dados exigiria modificar a classe de negócio. |
| **Divergent Change** | `Matricula.java` | Por misturar lógica de desconto e lógica de persistência, a classe tinha múltiplos motivos para mudar: regras de negócio e infraestrutura. |