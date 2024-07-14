package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarteiraDeVacinacao {
    private List<Vacina> vacinas;

    public CarteiraDeVacinacao() {
        this.vacinas = new ArrayList<>();
    }
    
    public int contarVacinas (){
        return vacinas.size();
    }

    public Vacina getVacinas(){
        if(contarVacinas() != 0) {
            for(Vacina vacina : vacinas) {
                vacina.toString();
            }
        }
        return null;
    }

    public void adicionarVacina(Vacina vacina) {
        vacinas.add(vacina);
    }

    public NivelProtecao getNivelProtecao() {
        return NivelProtecao.determinarNivel(contarVacinas());
    }

    public void mostrarDadosVacinas() {
        if (vacinas.isEmpty()) {
            System.out.println("Nenhuma vacina aplicada.");
        } else {
            System.out.println("Vacinas aplicadas:");
            for (Vacina vacina : vacinas) {
                System.out.println(vacina);
            }
            System.out.println("Nível de proteção: " + getNivelProtecao());
        }
    }
}
