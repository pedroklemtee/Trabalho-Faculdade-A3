package Models;

import java.time.LocalDate;

public class Enfermeira extends Pessoa {
    private String especialidade;
    private String turno;

    public Enfermeira(String nome, String turno , LocalDate dataDeNascimento, String cpf, String telefone, String endereco, String especialidade, boolean disponivel) {
        super(nome, dataDeNascimento, cpf, telefone, endereco);
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
}
