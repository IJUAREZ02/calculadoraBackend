package com.example.calculadorainversiones.controller;

import com.example.calculadorainversiones.entity.DatosCalculo;
import com.example.calculadorainversiones.entity.ResultadoInversion;
import com.example.calculadorainversiones.entity.ResumenResultado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("calculadora")
@RestController
public class ControllerMain {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Calculadora de Inversiones";
    }

    @PostMapping("/inversion")
    public @ResponseBody ResponseEntity calculoInversion(@RequestBody  DatosCalculo datosCalculo) {
        System.out.println("vvvvvvvvvvvv " + datosCalculo);
        List<ResultadoInversion> calculoInversion = new ArrayList<>();
        List<ResumenResultado> resumenResultado = new ArrayList<>();

        int sumTotalAnio = 0;
        double rendimiento = 0.0;
        double auxSum = 0.0;

        double auxSumAportaciones = 0.0;

        double gananciaTotal = 0.0;

        for (int i = 0; i < datosCalculo.getAniosInversion(); i++) {

            double aportacionTotalAnio =  calculoAportacion(datosCalculo.getAportacionAnual(), datosCalculo.getPorcentajeIncrementoAnual(), i);
            auxSumAportaciones += (int)Math.ceil(aportacionTotalAnio);

            ResultadoInversion resultadoInversion = new ResultadoInversion();
            resultadoInversion.setAnio(i+1);
            resultadoInversion.setAportacion((int)Math.ceil(aportacionTotalAnio));


            if (i == 0) {
                resultadoInversion.setSaldoInicial(datosCalculo.getInversionInicial());
                rendimiento = calcularRendimiento((int)datosCalculo.getInversionInicial(), (int)Math.ceil(aportacionTotalAnio), datosCalculo.getRendimientoInversion());
                double saldoFinal = ((int)datosCalculo.getInversionInicial() + (int)Math.ceil(aportacionTotalAnio)) + rendimiento;
                auxSum = saldoFinal;

                resultadoInversion.setRendimiento((int)rendimiento);
                resultadoInversion.setSaldoInicial((int)datosCalculo.getInversionInicial());
                resultadoInversion.setSaldoFinal(saldoFinal);
            } else {

                resultadoInversion.setSaldoInicial(auxSum);
                rendimiento = calcularRendimiento(auxSum, (int)Math.ceil(aportacionTotalAnio), datosCalculo.getRendimientoInversion());

                double sumaFinal = (auxSum + Math.ceil(aportacionTotalAnio)) + (int)Math.ceil(rendimiento);

                auxSum = sumaFinal;
                resultadoInversion.setRendimiento((int)rendimiento);
                resultadoInversion.setSaldoFinal(auxSum);

            }

            calculoInversion.add(resultadoInversion);

        }

        double gananciaInversion = (auxSum - datosCalculo.getInversionInicial() - auxSumAportaciones);

        ResumenResultado resumenGanancia = new ResumenResultado();
        resumenGanancia.setMontoFinal(auxSum);
        resumenGanancia.setGananciaInversion(gananciaInversion);
        resumenResultado.add(resumenGanancia);

        Map<String, Object> resultadoTabla = new HashMap<>();
        resultadoTabla.put("inversion", calculoInversion);
        resultadoTabla.put("resumen", resumenResultado);

        return new ResponseEntity(resultadoTabla, HttpStatus.OK);
    }


    public static double calculoAportacion(double montoInicial, double tasaInteresAnual, int periodoAnios) {
        double tasaInteres = tasaInteresAnual / 100;
        double aportacion = montoInicial * Math.pow(1 + tasaInteres, periodoAnios);
        return aportacion;
    }

    public static double calcularRendimiento(double montoInicial, double aportacion, double rendimiento) {
        double porcentajeAportacion = rendimiento / 100;
        double montoFinal = (montoInicial + aportacion) * porcentajeAportacion;
        return montoFinal;
    }

}
