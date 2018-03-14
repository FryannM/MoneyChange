package com.example.admin.moneychange;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText Ecantidad;
    TextView TV_Resultado;
    double cantidad, resultado;
    Spinner sp_origen, sp_destino;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_origen = findViewById(R.id.spinner_origen);
        sp_destino = findViewById(R.id.spinner_destino);
        Ecantidad = findViewById(R.id.quantity_ID);
        TV_Resultado = findViewById(R.id.resultID);

        FillUpSpinners();

        findViewById(R.id.btn_calcular).setOnClickListener(this);
        findViewById(R.id.btn_cleanData).setOnClickListener(this);

    }


    private void FillUpSpinners() {


        ArrayAdapter<Calculo.Moneda> adapter_origen
                = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, Calculo.Moneda.values());

        ArrayAdapter<Calculo.Moneda> adapter_destino
                = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, Calculo.Moneda.values());

        adapter_origen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_destino.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_origen.setAdapter(adapter_origen);
        sp_destino.setAdapter(adapter_destino);

        sp_origen.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, Calculo.Moneda.values()));
        sp_destino.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, Calculo.Moneda.values()));
    }


    private void CleanData() {

        Ecantidad.setText("");
        TV_Resultado.setText("");

    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_about:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com.do"));
                startActivity(browserIntent);
                break;
            case R.id.menu_close:
                finishAffinity();
                break;

            case R.id.menu_version:{
                    Toast.makeText(getApplicationContext(),
                            "Version 1.2.2 Builder ", Toast.LENGTH_SHORT).show();

                    break;
                }
            case  R.id.menu_restart:{
                recreate();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick( View view ) {

        String money = "$$$";
        switch (view.getId()) {
            case R.id.btn_calcular: {
                Calculo calculo = new Calculo();

                if (!Ecantidad.getText().toString().isEmpty()) {
                    cantidad = Double.parseDouble(Ecantidad.getText().toString());

                    Calculo.Moneda monedaOrigen = Calculo.Moneda.valueOf(sp_origen.getSelectedItem().toString());
                    Calculo.Moneda monedaDestino = Calculo.Moneda.valueOf(sp_destino.getSelectedItem().toString());

                    resultado = calculo.Convert(monedaOrigen, monedaDestino, cantidad);

                    TV_Resultado.setText(String.valueOf(resultado + money));


                    Calculo.Round(resultado);
                }
                break;


            }
            case R.id.btn_cleanData: {

                CleanData();


            }
        }
    }
}














