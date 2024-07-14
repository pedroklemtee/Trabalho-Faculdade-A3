package Models;

import com.sun.source.tree.NewArrayTree;

import java.lang.module.FindException;
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
        System.out.println("Sistema de cadastro de paciente: \n");
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.next();
        System.out.print("Digite a data de nascimento (dd-MM-yyyy): ");
        String dataNascimento = scanner.next();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.next();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.next();
        System.out.print("Digite o endereço: ");
        String endereco = scanner.next();
        System.out.print("Digite o sexo (M/F): ");
        char sexo = scanner.next().charAt(0);
        System.out.print("Digite o peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite a altura: ");
        double altura = scanner.nextDouble();
        System.out.print("Digite o tipo sanguíneo: ");
        String tipoSanguineo = scanner.next();
        
        var carteiraDeVacinacao = new CarteiraDeVacinacao();

        Paciente paciente = new Paciente(nome, dataNascimento, cpf, telefone, endereco, sexo, peso, altura, tipoSanguineo, carteiraDeVacinacao);
        
        this.pacientes.add(paciente);
        
        System.out.println("Paciente registrado com sucesso!");
    }

    public void registrarVacina() {
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
        System.out.println("Digite a especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.println("Digite o turno: ");
        String turno = scanner.nextLine();
        
        var newEnfermeira = new Enfermeira(nome, turno, dataNascimento, cpf, telefone, endereco, especialidade);
        enfermeiras.add(newEnfermeira);

        System.out.println("Vacina registrada com sucesso!");
    }

    public void removerEnfermeira() {
        System.out.println("Sistema de remoção de enfermeiros(as):");
        System.out.println();
        System.out.println("Lista de enfermeiros(as) disponiveis:");
        for (Enfermeira e : enfermeiras){
            e.toString();
        }
        System.out.println("Digite o cpf do(a) enfermeiro(a) que deseja remover: ");
        String cpf = scanner.next();
        
        Enfermeira enfermeira = findEnfermeira(cpf);
        if (enfermeira != null) {
            enfermeiras.remove(enfermeira);
        } else {
            System.out.println("Enfermeira não encontrada!");
        }
    }

    private Enfermeira findEnfermeira(String cpf){
        for(Enfermeira e : enfermeiras){
            if (e.getCpf().equals(cpf)){
                return e;
            }
        }
        return null;
    }

    public void verEnfermeiras() {
        System.out.println("Sistema de vizualizar enfermeiros(as) registrador(as): ");
        if (enfermeiras.stream().count() <= 0) {
            System.out.println("Não há nenhum enfermeiro(a) cadastrado(a) ainda!");
        }
        for (Enfermeira e : enfermeiras) {
            System.out.println(e.toString());
        }
    }

    public void verPacientes() {
        System.out.println("Sistema de vizualizar pacientes registrados: ");
        if(pacientes.stream().count() <= 0 ) {
            System.out.println("Não há nenhum paciente registrado ainda!");
        }
        for (Paciente p : pacientes) {
            System.out.println(p.toString());
        }
    }
    
    public void verCarteiraPaciente ()  {
        System.out.println("Sistema de vizualizar carteira de paciente: ");
        System.out.println("Pacientes registrados: ");
        for (Paciente paciente : pacientes) {
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Cpf: " + paciente.getCpf());
        }
        System.out.println("Digite o cpf do paciente que deseja ver a carteira de vacinação: ");
        
        String cpf = scanner.next();
        
        Paciente paciente = findPaciente(cpf);
        
        System.out.println("Carteira de vacinação do paciente " + paciente.getNome() + " : ");
        paciente.getCarteiraDeVacinacao().mostrarDadosVacinas();
    }

    public void removerPaciente() {
        System.out.println("Sistema de remoção de pacientes:");
        System.out.println();
        System.out.println("Lista de pacientes disponiveis:");
        for (Paciente p : pacientes){
            p.toString();
        }
        System.out.println("Digite o cpf do(a) paciente que deseja remover: ");
        String cpf = scanner.next();

        Paciente paciente = findPaciente(cpf);
        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }

    private Paciente findPaciente(String cpf){
        for(Paciente p : pacientes){
            if (p.getCpf().equals(cpf)){
                System.out.println("Paciente encontrado no sistema de registros!");
                return p;
            }
        }
        return null;
    }
    
    public void informacoesPosto(){
        System.out.println("Informações do posto de saúde:");
        System.out.println("Nome: " + getName());
        System.out.println("Endereço: " + getEndereco());
    }
    
    public void aplicarVacina(){
        System.out.println("Sistema de aplicar vacina:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getNome());
            System.out.println(paciente.getCpf());
        }
        System.out.println("Digite o cpf do paciente que deseja aplicar: ");
        String cpf = scanner.next();
        Paciente paciente = findPaciente(cpf);
        System.out.println("Digite o nome da vacina que deseja aplicar: ");
        for (Vacina v : vacinas){
            v.toString();
        }
        String vacina = scanner.next();
        Vacina vacinaEcontrada = findVacina(vacina);
        
        paciente.getCarteiraDeVacinacao().adicionarVacina(vacinaEcontrada);
    }
    
    private Vacina findVacina(String name){
        for (Vacina v : vacinas){
            if(v.getNome().equals(name)) {
                return v;
            }
        }
        return null;
    }
}
