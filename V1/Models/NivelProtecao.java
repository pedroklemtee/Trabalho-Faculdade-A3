package Models;

public enum NivelProtecao {
    NAO_VACINADO_REGULARMENTE,
    VACINADO_REGULARMENTE;

    public static NivelProtecao determinarNivel(int numeroVacinas) {
        return (numeroVacinas >= 3) ? VACINADO_REGULARMENTE : NAO_VACINADO_REGULARMENTE;
    }
}
