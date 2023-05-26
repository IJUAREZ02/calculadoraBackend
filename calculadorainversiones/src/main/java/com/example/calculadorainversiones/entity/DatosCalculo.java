package com.example.calculadorainversiones.entity;

public class DatosCalculo {

    private double inversionInicial;
    private double aportacionAnual;
    private int porcentajeIncrementoAnual;
    private int aniosInversion;
    private int rendimientoInversion;

    public double getInversionInicial() {
        return inversionInicial;
    }

    public void setInversionInicial(double inversionInicial) {
        this.inversionInicial = inversionInicial;
    }

    public double getAportacionAnual() {
        return aportacionAnual;
    }

    public void setAportacionAnual(double aportacionAnual) {
        this.aportacionAnual = aportacionAnual;
    }

    public int getPorcentajeIncrementoAnual() {
        return porcentajeIncrementoAnual;
    }

    public void setPorcentajeIncrementoAnual(int porcentajeIncrementoAnual) {
        this.porcentajeIncrementoAnual = porcentajeIncrementoAnual;
    }

    public int getAniosInversion() {
        return aniosInversion;
    }

    public void setAniosInversion(int aniosInversion) {
        this.aniosInversion = aniosInversion;
    }

    public int getRendimientoInversion() {
        return rendimientoInversion;
    }

    public void setRendimientoInversion(int rendimientoInversion) {
        this.rendimientoInversion = rendimientoInversion;
    }

    @Override
    public String toString() {
        return "DatosCalculo{" +
                "inversionInicial=" + inversionInicial +
                ", aportacionAnual=" + aportacionAnual +
                ", porcentajeIncrementoAnual=" + porcentajeIncrementoAnual +
                ", aniosInversion=" + aniosInversion +
                ", rendimientoInversion=" + rendimientoInversion +
                '}';
    }
}
