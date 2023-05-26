package com.example.calculadorainversiones.entity;

public class ResumenResultado {

    private double montoFinal;
    private double gananciaInversion;

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public double getGananciaInversion() {
        return gananciaInversion;
    }

    public void setGananciaInversion(double gananciaInversion) {
        this.gananciaInversion = gananciaInversion;
    }

    @Override
    public String toString() {
        return "ResumenResultado{" +
                "montoFinal=" + montoFinal +
                ", gananciaInversion=" + gananciaInversion +
                '}';
    }
}
