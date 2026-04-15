# Desafio Técnico - Gestão de Funcionários

Este é um projeto desenvolvido em Java como resolução de um desafio técnico prático para a vaga de Desenvolvedor(a) Júnior. O projeto consiste em um sistema simples de gestão de funcionários da indústria, que realiza diversas operações de manipulação de dados utilizando recursos modernos do Java.

## 🚀 Tecnologias Utilizadas

- **Java** (versão 17)
- **Java Streams API e Lambdas:** Para filtragem, mapeamento, ordenação e agrupamento de dados de forma funcional.
- **`java.time` API:** Utilização de `LocalDate`, `Period` e `DateTimeFormatter` para manipulação de datas de forma moderna e segura.
- **`java.math.BigDecimal`:** Para cálculos financeiros precisos de salários.
- **Collections Framework:** Uso intensivo de `List` e `Map` (`ArrayList`, etc).

## 📋 Funcionalidades Implementadas

O sistema executa sequencialmente as seguintes operações:

1. **Inserção de Dados:** Adiciona uma lista inicial de funcionários contendo Nome, Data de Nascimento, Salário e Função.
2. **Remoção de Registro:** Remove da lista o funcionário com o nome "João".
3. **Listagem Formatada:** Imprime todos os funcionários com datas formatadas no padrão brasileiro (`dd/MM/yyyy`) e salários no formato de moeda (`R$`).
4. **Reajuste Salarial:** Aplica um aumento de 10% no salário de todos os funcionários usando `BigDecimal`.
5. **Agrupamento por Função:** Utiliza a API de Streams (`Collectors.groupingBy`) para agrupar os funcionários em um `Map` de acordo com a sua função e, em seguida, imprime os grupos.
6. **Filtro por Mês de Aniversário:** Localiza e imprime os funcionários que fazem aniversário nos meses de Outubro (10) e Dezembro (12).
7. **Identificação do Mais Velho:** Encontra o funcionário mais velho da lista e imprime seu nome e sua idade atualizada calculada dinamicamente.
8. **Ordenação Alfabética:** Imprime a lista completa de funcionários ordenada por ordem alfabética.
9. **Totalização dos Salários:** Soma e exibe o valor total da folha de pagamento da empresa.
10. **Cálculo de Salários Mínimos:** Calcula e imprime quantos salários mínimos (considerando o valor de R$ 1212,00) cada funcionário recebe.

## 🛠️ Como Executar

1. Certifique-se de ter o **JDK 17** instalado em sua máquina.
2. Clone o repositório ou faça o download dos arquivos.
3. Compile e execute a classe `Principal.java` presente no pacote `org.desafio`.

```bash
# Navegue até o diretório do código-fonte
cd src/main/java

# Compile as classes
javac org/desafio/model/Funcionario.java org/desafio/Principal.java

# Execute a classe principal
java org.desafio.Principal
```

## ✒️ Autor

Projeto desenvolvido como parte de um processo seletivo / desafio técnico.
