import Models.CarteiraDeVacinacao;
import Models.Paciente;
import Models.PostoDeSaude;
import com.sun.source.tree.CaseTree;

import java.security.PrivateKey;
import java.util.Scanner;

public class Main {
    
    private static PostoDeSaude postoDeSaude;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        registrarPostoDeSaude(scanner);
        
        int opcao;

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1. Registrar vacina");
            System.out.println("2. Registrar enfermeira");
            System.out.println("3. Remover enfermeira");
            System.out.println("4. Ver enfermeiras");
            System.out.println("5. Registrar paciente");
            System.out.println("6. Remover paciente");
            System.out.println("7. Ver pacientes");
            System.out.println("8. Ver carteira de vacinação de paciente especifico");
            System.out.println("9. Informações do posto");
            System.out.println("10. Aplicar vacina");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    postoDeSaude.registrarVacina(); 
                    break;
                case 2:
                    postoDeSaude.registrarEnfermeira(); // 
                    break;
                case 3:
                    postoDeSaude.removerEnfermeira(); //
                    break;
                case 4:
                    postoDeSaude.verEnfermeiras(); //
                    break;
                case 5 :
                    postoDeSaude.registrarPaciente(); //
                    break;
                case 6 :
                    postoDeSaude.removerPaciente(); // 
                    break;
                case 7:
                    postoDeSaude.verPacientes(); //
                    break;
                case 8:
                    postoDeSaude.verCarteiraPaciente(); //
                    break;
                case 9:
                    postoDeSaude.informacoesPosto(); //
                    break;
                case 10:
                    postoDeSaude.aplicarVacina();
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
    
        private static void registrarPostoDeSaude(Scanner scanner) {
        
            System.out.println("Cadastro do Posto de Saúde:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            postoDeSaude = new PostoDeSaude(nome, endereco);
            System.out.println("Posto de Saúde cadastrado com sucesso!");
        }    
    
}