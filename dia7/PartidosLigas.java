package dia7;

class PartidosLigas extends Partidos {
    private int jornada;

    public PartidosLigas(String local, String visitante, String fecha, int jornada) {
        super(local, visitante, fecha);
        this.jornada = jornada;
    }

    @Override
    public String obtenerGanador() {
        if (!finalizado) return "El partido aun esta en juego";
        return cestasLocal > cestasVisitante ? equipoLocal : (cestasVisitante > cestasLocal ? equipoVisitante : "Empate");
    }
}