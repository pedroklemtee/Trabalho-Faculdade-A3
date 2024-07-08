package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Enfermeira extends Pessoa {
    private String especialidade;
    private String turno;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Enfermeira(String nome, String turno , String dataDeNascimento, String cpf, String telefone, String endereco, String especialidade) {
        super(nome, LocalDate.parse(dataDeNascimento, formatter) , cpf, telefone, endereco);
        this.especialidade = especialidade;
        this.turno = turno;
    }
    

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + '\n' +
                "Cpf: " + getCpf() + '\n' +
                "Turno: " + turno + '\n' +
                "Especialidade: " + getEspecialidade();
    }
}
