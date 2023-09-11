package ltp2;

import java.util.Scanner;

public class exe4 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int maxEmpregados = 100;
	        String[] nomes = new String[maxEmpregados];
	        int[] codigos = new int[maxEmpregados];
	        int[] numPecas = new int[maxEmpregados];
	        double[] salarios = new double[maxEmpregados];
	        int numEmpregados = 0;
	        double totalSalarios = 0;

	        while (true) {
	            System.out.print("Digite o Nome do Empregado (ou 'sair' para encerrar): ");
	            String nome = scanner.nextLine();
	            if (nome.equalsIgnoreCase("sair")) {
	                break;
	            }

	            if (nome.isEmpty()) {
	                System.out.println("Nome é obrigatório. Tente novamente.");
	                continue;
	            }

	            System.out.print("Digite o Código do Empregado (entre 1 e 999): ");
	            String codigoStr = scanner.nextLine();
	            if (codigoStr.isEmpty()) {
	                System.out.println("Código é obrigatório. Tente novamente.");
	                continue;
	            }

	            int codigo = Integer.parseInt(codigoStr);
	            if (codigo < 1 || codigo > 999) {
	                System.out.println("Código fora do intervalo permitido. Tente novamente.");
	                continue;
	            }

	            System.out.print("Digite o Número de Peças fabricadas: ");
	            String pecasStr = scanner.nextLine();
	            if (pecasStr.isEmpty()) {
	                System.out.println("Número de peças é obrigatório. Tente novamente.");
	                continue;
	            }

	            int pecas = Integer.parseInt(pecasStr);
	            if (pecas <= 0) {
	                System.out.println("Número de peças deve ser maior que zero. Tente novamente.");
	                continue;
	            }

	            nomes[numEmpregados] = nome;
	            codigos[numEmpregados] = codigo;
	            numPecas[numEmpregados] = pecas;
	            salarios[numEmpregados] = calcularSalario(pecas);
	            totalSalarios += salarios[numEmpregados];
	            numEmpregados++;
	        }

	        if (numEmpregados > 0) {
	            System.out.println("\nNome Salário");
	            System.out.println("------------------------------------------");
	            for (int i = 0; i < numEmpregados; i++) {
	                System.out.printf("%-20s %.2f%n", nomes[i], salarios[i]);
	            }
	            System.out.println("Total pago com salários: " + totalSalarios);
	            System.out.println("Média dos salários: " + (totalSalarios / numEmpregados));
	        } else {
	            System.out.println("Nenhum empregado registrado.");
	        }
	    }

	    public static double calcularSalario(int numPecas) {
	        if (numPecas <= 200) {
	            return numPecas * 2.00;
	        } else if (numPecas <= 400) {
	            return numPecas * 2.30;
	        } else {
	            return numPecas * 2.50;
	        }
	    }
}
