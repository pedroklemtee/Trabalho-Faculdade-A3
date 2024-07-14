package Models;

import java.util.StringTokenizer;

public class Vacina {
    
    private String nome;
    private int dosesDisponiveis;
    private String fabricante;
    
    public Vacina(String nome, int dosesDisponiveis, String fabricante){
        this.nome = nome;
        this.dosesDisponiveis = dosesDisponiveis;
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getDosesDisponiveis() {
        return dosesDisponiveis;
    }

    public void setDosesDisponiveis(int dosesDisponiveis) {
        this.dosesDisponiveis = dosesDisponiveis;
    }
    
    @Override
    public String toString() {
        return "Vacina{" +
                "nome='" + nome + '\'' +
                ", dosesDisponiveis=" + dosesDisponiveis +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
