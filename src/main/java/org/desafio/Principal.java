package org.desafio;

import org.desafio.model.Funcionario;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("5000"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1995,5,12), new BigDecimal("3000"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("4000"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("4000"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2000"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("3000"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4000"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3500"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("2700"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("3200"), "Gerente"));

        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        funcionarios.forEach(f -> {
            System.out.println(
                          f.getNome() + " | " +
                            f.getFuncao() + " | " +
                                  formatter.format(f.getDataNascimento()) + " | " +
                                  numberFormat.format(f.getSalario())

            );
        });

        funcionarios.forEach(f -> {
            BigDecimal aumento = f.getSalario().multiply(new BigDecimal("0.10"));
            f.setSalario(f.getSalario().add(aumento));
        });

        Map<String, List<Funcionario>>funcionarioporfuncao =
                funcionarios.stream()
                        .collect(Collectors.groupingBy(Funcionario::getFuncao));

        funcionarioporfuncao.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // ordena por nome da função
                .forEach(entry -> {
                    String funcao = entry.getKey();
                    List<Funcionario> listaFuncionarios = entry.getValue();

                    System.out.println("\nFunção: " + funcao);
                    listaFuncionarios.stream()
                            .sorted((a, b) -> a.getNome().compareToIgnoreCase(b.getNome())) // opcional
                            .forEach(f -> System.out.println(
                                    " - " + f.getNome() + " | " +
                                            formatter.format(f.getDataNascimento()) + " | " +
                                            numberFormat.format(f.getSalario())
                            ));
                });

        funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
        })
        .forEach(f -> System.out.println(
                f.getNome() + " | " +
                        f.getFuncao() + " | " +
                        formatter.format(f.getDataNascimento()) + " | " +
                        numberFormat.format(f.getSalario())
        ));

        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("\nFuncionário mais velho: " + maisVelho.getNome() + " - " + idade + " anos");
        }

        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome, String.CASE_INSENSITIVE_ORDER))
                .forEach(f -> System.out.println(
                        f.getNome() + " | " +
                                f.getFuncao() + " | " +
                                formatter.format(f.getDataNascimento()) + " | " +
                                numberFormat.format(f.getSalario())
                ));

        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nTotal dos salários: " + numberFormat.format(total));

        BigDecimal salarioMinimo = new BigDecimal("1212");

        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, java.math.RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " recebe " + qtd + " salários mínimos.");
        });

    }
}

