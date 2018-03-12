package com.example.admin.moneychange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText Ecantidad, Eresultado;
    double cantidad,Resultado;
    Spinner sp_desde, sp_hasta;
    String mensaje ="Esto es una prueba";
    Calculo calculo = new Calculo();


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_desde = findViewById(R.id.spinner_desde);
        sp_hasta = findViewById(R.id.spinner_hasta);
        Ecantidad = findViewById(R.id.quantity_ID);
        Eresultado = findViewById(R.id.resultID);


        FillSpinners();

        findViewById(R.id.btn_calcular).setOnClickListener(this);

    }



    private void FillSpinners() {

        sp_desde.setAdapter(new ArrayAdapter<Calculo.Monedas>(this, android.R.layout.simple_list_item_1, Calculo.Monedas.values()));
        sp_hasta.setAdapter(new ArrayAdapter<Calculo.Monedas>(this, android.R.layout.simple_list_item_1, Calculo.Monedas.values()));
    }

    @Override
    public void onClick( View view ) {
        cantidad= Double.parseDouble(Ecantidad.getText().toString());
        Resultado = Double.parseDouble(Eresultado.getText().toString());

        Calculo.Monedas Desde = Calculo.Monedas.valueOf(sp_desde.getSelectedItem().toString());
        Calculo.Monedas Hasta = Calculo.Monedas.valueOf(sp_hasta.getSelectedItem().toString());
        char opciones =0;
        switch (opciones)
        {
            case 1: if(sp_desde.equals("Dollars") && (sp_hasta.equals("Pesos")))
            {
                calculo.dollarsToPeso();
                Eresultado.setText("Probando");
            }
        }






    }
}


