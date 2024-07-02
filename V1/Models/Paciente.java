package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paciente extends Pessoa {
    private char sexo;
    private double peso;
    private double altura;
    private String tipoSanguineo;
    private CarteiraDeVacinacao carteiraDeVacinacao;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Paciente(String nome, String dataDeNascimento, String cpf, String telefone, String endereco,
                    char sexo, double peso, double altura, String tipoSanguineo, CarteiraDeVacinacao carteiraDeVacinacao) {
        super(nome, LocalDate.parse(dataDeNascimento, formatter), cpf, telefone, endereco);
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.tipoSanguineo = tipoSanguineo;
        this.carteiraDeVacinacao = carteiraDeVacinacao;
    }

    @Override
    public String toString() {
        return  "------------------------------- \n" +
                "Dados do Paciente:" + "\n" +
                "------------------------------- \n" +
                "Nome:" + this.getNome() + "\n" +
                "Data de Nascimento:" + this.getDataDeNascimento() + "\n" +
                "Peso:" + peso + "\n" +
                "Altura:" + altura + "\n" +
                "Tipo sanguíneo:" + tipoSanguineo + "\n" +
                "sexo:" + sexo + "\n" +
                "------------------------------- \n";
    }
}