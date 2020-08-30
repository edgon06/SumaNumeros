package com.example.sumanumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaracion variables de componentes (o "vistas")
    TextView txtSalida;
    EditText txtNum1, txtNum2;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los controles en la vista
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        txtSalida = findViewById(R.id.txtSalida);

        // Asignar comportamiento a los botones

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try{
                        verificar();
                        mostrarResultado(String.valueOf(sumar(
                                Float.parseFloat(txtNum1.getText().toString()),
                                Float.parseFloat(txtNum2.getText().toString())
                        )));
                    }catch(Exception e)
                    {
                        Toast.makeText(MainActivity.this, getText(R.string.mensajeError), Toast.LENGTH_SHORT).show();
                    }
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try{
                        verificar();
                        mostrarResultado(String.valueOf(restar(
                                Float.parseFloat(txtNum1.getText().toString()),
                                Float.parseFloat(txtNum2.getText().toString())
                        )));
                }catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, getText(R.string.mensajeError), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try{
                        verificar();
                        mostrarResultado(String.valueOf(multiplicar(
                                Float.parseFloat(txtNum1.getText().toString()),
                                Float.parseFloat(txtNum2.getText().toString())
                        )));
                }catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, getText(R.string.mensajeError), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try{
                        verificar();
                        mostrarResultado(String.valueOf(dividir(
                                Float.parseFloat(txtNum1.getText().toString()),
                                Float.parseFloat(txtNum2.getText().toString())
                        )));
                }catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, getText(R.string.mensajeError), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Funciones para resolver las operaciones
    private float sumar(float num1, float num2)
    {
        return num1 + num2;
    }

    private float multiplicar(float num1, float num2)
    {
        return num1 * num2;
    }

    private float restar(float num1, float num2)
    {
        return num1 - num2;
    }

    private float dividir(float num1, float num2)
    {
        if(num2==0){
            txtNum2.setError(getText(R.string.mensajeErrorDivision));
            // Toast.makeText(MainActivity.this, getText(R.string.mensajeErrorDivision), Toast.LENGTH_SHORT).show();
        }
        return num1 / num2;
    }

    // Metodo para imprimir el resultado en pantalla
    private void mostrarResultado( String resultado)
    {
        txtSalida.setText(resultado);
    }
    private void verificar()
    {
        if( txtNum1.getText().toString().equals(""))
        {
            txtNum1.setError(getText(R.string.mensajeCasillaVacia));
        }
        if( txtNum2.getText().toString().equals(""))
        {
            txtNum2.setError(getText(R.string.mensajeCasillaVacia));
        }
    }
}
