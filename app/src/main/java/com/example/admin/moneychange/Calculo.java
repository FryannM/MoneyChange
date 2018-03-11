package com.example.admin.moneychange;

/**
 * Created by Admin on 3/10/2018.
 */

public class Calculo {

    public final double pesos =  1;
    public final double dollar = 1;
    public final double euro = 1;
    public final double dollarstopeso = 49.05;
    public final double dollartoeuro = 0.812513;
    public final  double pesotodollar = 0.02014;
    public final double pesostoeuro = 0.0165346334;
    public final double eurotopesos = 50;


    public final double eurotodollar = 1.230684;
    public   double resultado;
    public  double cantidad ;

       /* dollar to dollar DONE
        * dollar to peso DONE
        * dollar to euro DONE
        *
        * euro to dollar DONE
        * euro to peso  DONE
        *
        * peso to dollar  DONE
        * peso to euro NO DONE
        *
        */

    public double  dollarsToPeso()
    {
        resultado = (dollarstopeso * cantidad * pesos);
        return resultado;
    }
    public double dollarsToEuro()
    {
        resultado = (cantidad *  dollartoeuro *  euro);
        return resultado;
    }

    public double dollarTodollar()
    {
        resultado = (cantidad * dollar * dollar);
        return resultado;
    }

    public double euroTodollar()
    {
        resultado = (cantidad * eurotodollar * dollar);
        return resultado;
    }

    public double pesoTodollar()
    {
        resultado = (cantidad * pesotodollar * dollar);
        return resultado;
    }


    public double EuroToPesos()
    {
        resultado = (cantidad * eurotopesos * euro);
        return resultado;
    }

    public double PesosToEuro()
    {
        resultado = (cantidad * pesostoeuro * euro);
        return resultado;
    }


}
