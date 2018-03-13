package com.example.admin.moneychange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText Ecantidad;
    TextView TV_Resultado;
    double cantidad, resultado;
    Spinner sp_origen, sp_destino;
    String mensaje = "Esto es una prueba";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_origen = findViewById(R.id.spinner_desde);
        sp_destino = findViewById(R.id.spinner_hasta);
        Ecantidad = findViewById(R.id.quantity_ID);
        TV_Resultado = findViewById(R.id.resultID);

        FillSpinners();

        findViewById(R.id.btn_calcular).setOnClickListener(this);
    }


    private void FillSpinners() {


        ArrayAdapter<Calculo.Moneda> adapter_desde
                = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, Calculo.Moneda.values());

        ArrayAdapter<Calculo.Moneda> adapter_hasta
                = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, Calculo.Moneda.values());

        adapter_desde.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_hasta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_origen.setAdapter(adapter_desde);
        sp_destino.setAdapter(adapter_hasta);

        sp_origen.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, Calculo.Moneda.values()));
        sp_destino.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, Calculo.Moneda.values()));
    }

    @Override
    public void onClick( View view )
    {
        Calculo calculo = new Calculo();

        if (!Ecantidad.getText().toString().isEmpty()) {
            cantidad = Double.parseDouble(Ecantidad.getText().toString());

            Calculo.Moneda monedaOrigen = Calculo.Moneda.valueOf(sp_origen.getSelectedItem().toString());
            Calculo.Moneda monedaDestino = Calculo.Moneda.valueOf(sp_destino.getSelectedItem().toString());

            resultado = calculo.Convertir(monedaOrigen, monedaDestino, cantidad);

            TV_Resultado.setText(String.valueOf(resultado));
        }
    }
}






