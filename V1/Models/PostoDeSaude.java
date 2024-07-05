package Models;

import com.sun.source.tree.NewArrayTree;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Scanner;

public class PostoDeSaude implements IRegistro {
    private String name;
    private String endereco;
    private Scanner scanner;
    List<Paciente> pacientes = new ArrayList<>();
    List<Vacina> vacinas = new ArrayList<>();
    List<Enfermeira> enfermeiras = new ArrayList<>();

    public PostoDeSaude(String name, String endereco){
        this.name = name;
        this.endereco = endereco;
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }
    
    public String getEndereco(){
        return endereco;
    }

    @Override
    public void registrarPaciente(){
        System.out.println("Sistema de cadastro de paciente:");
        System.out.println();
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a data de nascimento (dd-MM-yyyy): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);
        System.out.print("Digite o peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite a altura: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Digite o tipo sanguíneo: ");
        String tipoSanguineo = scanner.nextLine();
        
        var carteiraDeVacinacao = new CarteiraDeVacinacao();

        Paciente paciente = new Paciente(nome, dataNascimento, cpf, telefone, endereco, sexo, peso, altura, tipoSanguineo, carteiraDeVacinacao);
        
        this.pacientes.add(paciente);
        
        System.out.println("Paciente registrado com sucesso!");
    }

    public void registrarVacinacao() {
        System.out.println("Sistema de cadastro de vacina:");
        System.out.println();
        System.out.println("Nome da nova vacina:");
        String nome = scanner.next();
        System.out.println("Doses disponiveis:");
        int dosesDisponiveis = scanner.nextInt();
        System.out.println("Fabricante da vacina:");
        String fabricante = scanner.next();

        var newVacina = new Vacina(nome, dosesDisponiveis, fabricante);
        vacinas.add(newVacina);

        System.out.println("Vacina registrada com sucesso!");
    }

    public void registrarEnfermeira() {
        System.out.println("Sistema de registro de enfermeira:");
        System.out.println();
        System.out.print("Digite o nome do enfermeiro(a): ");
        String nome = scanner.nextLine();
        System.out.print("Digite a data de nascimento (dd-MM-yyyy): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);
        System.out.print("Digite o peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite a altura: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Digite o tipo sanguíneo: ");
        String tipoSanguineo = scanner.nextLine();
    }

    public void removerEnfermeira() {
        System.out.println("Remover enfermeira");
    }

    public void verEnfermeiras() {
        System.out.println("Ver enfermeiras");
    }

    public void verPacientes() {
        System.out.println("Ver pacientes");
    }
    
    public void informacoesPosto(){
        System.out.println("Informações do posto de saúde:");
        System.out.println("Nome: " + getName());
        System.out.println("Endereço: " + getEndereco());
    }
}
