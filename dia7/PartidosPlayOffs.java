package dia7;

class PartidoPlayOffs extends Partidos {
    private String ronda;

    public PartidoPlayOffs(String local, String visitante, String fecha, String ronda) {
        super(local, visitante, fecha);
        this.ronda = ronda;
    }

    @Override
    public String obtenerGanador() {
        if (!finalizado) return "El partido aun esta en juego";
        return cestasLocal > cestasVisitante ? equipoLocal : equipoVisitante;
    }

    @Override
    public void finalizarPartido() {
        if (cestasLocal != cestasVisitante) {
            super.finalizarPartido();
        } else {
            System.out.println("No se puede finalizar el partido, hay empate");
        }
    }
}