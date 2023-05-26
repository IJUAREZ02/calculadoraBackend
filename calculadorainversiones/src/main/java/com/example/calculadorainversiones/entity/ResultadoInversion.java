package com.example.calculadorainversiones.entity;

public class ResultadoInversion {

    private int anio;
    private double saldoInicial;
    private double aportacion;
    private int rendimiento;
    private double saldoFinal;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getAportacion() {
        return aportacion;
    }

    public void setAportacion(double aportacion) {
        this.aportacion = aportacion;
    }

    public int getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(int rendimiento) {
        this.rendimiento = rendimiento;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }


    @Override
    public String toString() {
        return "ResultadoInversion{" +
                "anio=" + anio +
                ", saldoInicial=" + saldoInicial +
                ", aportacion=" + aportacion +
                ", rendimiento=" + rendimiento +
                ", saldoFinal=" + saldoFinal +
                '}';
    }
}
