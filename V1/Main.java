import Models.CarteiraDeVacinacao;
import Models.Paciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar vacinação");
            System.out.println("3. Registrar enfermeira");
            System.out.println("4. Remover enfermeira");
            System.out.println("5. Ver enfermeiras");
            System.out.println("6. Ver pacientes");
            System.out.println("7. Informações do posto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    registrarPaciente(scanner);
                    break;
                case 2:
                    registrarVacinacao(scanner);
                    break;
                case 3:
                    registrarEnfermeira(scanner);
                    break;
                case 4:
                    removerEnfermeira(scanner);
                    break;
                case 5:
                    verEnfermeiras();
                    break;
                case 6:
                    verPacientes();
                    break;
                case 7:
                    informacoesPosto();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
    }
}