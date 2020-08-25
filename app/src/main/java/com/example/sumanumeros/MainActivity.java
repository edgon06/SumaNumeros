package com.example.sumanumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaracion variables de componentes
    TextView txtSalida;
    EditText txtNum1, txtNum2;
    Button btnSumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        btnSumar = findViewById(R.id.btnSuma);
        txtSalida = findViewById(R.id.txtSalida);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try{
                        mostrarResultado(String.valueOf(sumar(Float.parseFloat(txtNum1.getText().toString()), Float.parseFloat(txtNum2.getText().toString()))));
                    }catch(Exception e)
                    {
                        Toast.makeText(MainActivity.this, "Revisa que los datos sean adecuados.", Toast.LENGTH_SHORT).show();
                    }

            }
        });


    }

    private float sumar(float num1, float num2)
    {
        return num1 + num2;
    }

    private void mostrarResultado( String resultado)
    {
        txtSalida.setText(resultado);
    }
}
