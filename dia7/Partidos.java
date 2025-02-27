package dia7;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Partidos {
    protected String equipoLocal, equipoVisitante;
    protected int cestasLocal, cestasVisitante;
    protected boolean finalizado;
    protected String fecha;

    public Partidos(String local, String visitante, String fecha) {
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.fecha = fecha;
        this.cestasLocal = 0;
        this.cestasVisitante = 0;
        this.finalizado = false;
    }

    public void registrarPuntosLocal(int puntos) {
        if (!finalizado) cestasLocal += puntos;
    }

    public void registrarPuntosVisitante(int puntos) {
        if (!finalizado) cestasVisitante += puntos;
    }

    public abstract String obtenerGanador();

    public void finalizarPartido() {
        this.finalizado = true;
    }

    public String obtenerInformacion() {
        return "Partido: " + equipoLocal + " vs " + equipoVisitante + " | Fecha: " + fecha +
               " | Puntos: " + cestasLocal + " - " + cestasVisitante + " | Estado: " + (finalizado ? "Finalizado" : "En juego");
    }
}