package service;

import java.util.Locale;
import java.util.Scanner;

public class Testes {
    
/*
 1- A prefeitura de uma cidade fez uma pesquisa entre 20 de seus habitantes,
 coletando dados sobre o salário e número de filhos. 
 A prefeitura deseja saber:
    a) média do salário da população;
    b) média do número de filhos;
    c) maior salário;
    d) percentual de pessoas com salário até R$100,00.
 */
    public void teste01(){
        final int pop = 20;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double sal = 0.0;
        double totSal = 0.0;
        double totFil = 0.0;
        double maxSal = 0.0;
        int sal100 = 0;
        for (int i = 1; i <= pop; i++) {
            System.out.print("Entre com o salário do morador " + i + ": ");
            sal = sc.nextDouble();
            System.out.print("Entre com o número de filhos do morador " + i + ": ");
            totFil += sc.nextDouble();
            if (sal <= 100) sal100++;
            if (sal > maxSal) maxSal = sal;
            totSal += sal;
        }
        System.out.printf("Média do salário da população: %.2f%n", totSal/pop);
        System.out.printf("Média do número de filhos: %.2f%n", totFil/pop);
        System.out.printf("Maior salário: %.2f%n", maxSal);
        System.out.printf("Percentual de pessoas com salário até R$100,00: %.1f%%%n", sal100/(double)pop*100.0);
        sc.close();
    }

    /*
     2- Desenvolver um sistema que efetue a soma de todos os números ímpares
      que são múltiplos de três e
      que se encontram no conjunto dos números de 1 até 500.
     */
    public int teste02() {
        int total = 0;
        for (int i = 1; i <= 500; i++) {
            if (i%2 != 0 && i%3 == 0) total += i;
        }
        return total;
    }
}
