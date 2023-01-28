package com.prestamos.pe.helper;

public class Helper {

    public static double calcularInteres(int cuotas){
        double interes = 0;
        if(cuotas >=0 && cuotas <= 3){
            interes = 0.01;
        } else if (cuotas >3 && cuotas <= 6) {
            interes = 0.02;
        } else if (cuotas >6 && cuotas <= 11) {
            interes = 0.04;
        } else if (cuotas >11) {
            interes = 0.05;
        }
        return interes;
    }

}
