package com.example.admin.moneychange;

import android.os.Build;

/**
 * Created by Admin on 3/10/2018.
 */

public class Calculo {
    public static final double dollarToPeso = 49.05;
    public static final double dollarToEuro = 0.812513;
    public static final double pesoToDollar = 0.02014;
    public static final double pesoToEuro = 0.0165346334;
    public static final double euroToPesos = 50;
    public static final double euroToDollar = 1.230684;

    public enum Moneda {
        Pesos,
        Dollars,
        Euros
    }

    public static double Convertir(Moneda origen, Moneda destino, double cantidadOrigen)
    {
         switch (origen){
             case Pesos:
                 switch (destino){
                     case Pesos:
                         return cantidadOrigen;
                     case Dollars:
                         return cantidadOrigen * pesoToDollar;
                     case Euros:
                         return cantidadOrigen * pesoToEuro;
                 }
                 break;
             case Dollars:
                 switch (destino) {
                     case Dollars:
                         return cantidadOrigen;
                     case Pesos:
                         return cantidadOrigen * dollarToPeso;
                     case Euros:
                         return cantidadOrigen * dollarToEuro;
                 }
                 break;
             case Euros:
                 switch (destino) {
                     case Euros:
                         return cantidadOrigen;
                     case Pesos:
                         return cantidadOrigen * euroToPesos;
                     case Dollars:
                         return cantidadOrigen * euroToDollar;
                 }
                 break;
         }
         return cantidadOrigen;
    }
}


