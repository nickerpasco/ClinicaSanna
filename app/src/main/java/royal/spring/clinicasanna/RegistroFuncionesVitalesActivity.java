package royal.spring.clinicasanna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;
import java.text.DecimalFormat;

import royal.spring.clinicasanna.clases.FuncionesVitales;
import royal.spring.clinicasanna.ui.ListaFuncionesVitalesActivity;

public class RegistroFuncionesVitalesActivity extends AppCompatActivity {
    ImageView btnRegistroFV, btnAtras;
    EditText edPaciente, edSaturacion, edTemperatura, edPeso, edTalla, edComentario;
    TextInputEditText txtImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_funciones_vitales);
        edPaciente = findViewById(R.id.edPaciente);
        edSaturacion = findViewById(R.id.edSaturacion);
        edTemperatura = findViewById(R.id.edTemperatura);
        edPeso = findViewById(R.id.edPeso);
        edTalla = findViewById(R.id.edTalla);
        edComentario = findViewById(R.id.edComentario);
        txtImc = findViewById(R.id.tiEdIMC);
        btnRegistroFV = findViewById(R.id.BtnRegistroFV);
        btnAtras = findViewById(R.id.btnAtrasFV);

        edPeso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                IMC();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        edTalla.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                IMC();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        btnRegistroFV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GuardarFuncionV();

            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void IMC() {
        if (edPeso.length() != 0 && edTalla.length() != 0) {
            double p = Double.parseDouble(edPeso.getText().toString());
            double t = Double.parseDouble(edTalla.getText().toString());
            double imc = p / (Math.pow(t, 2));
            Log.w("IMC: ", String.valueOf(imc));
            DecimalFormat formato = new DecimalFormat("#0.00");
            txtImc.setText(formato.format(imc));
        } else {
            txtImc.setText("");
        }
    }

    private void GuardarFuncionV() {
        if (edPaciente.length() !=0 && edSaturacion.length() != 0 && edTemperatura.length() != 0
                && edPeso.length() != 0 && edTalla.length() != 0 && txtImc.length() != 0 && edComentario.length() != 0) {

            DBHelper dbHelper;
            dbHelper = new DBHelper(this);
            try {
                FuncionesVitales funcionesV = new FuncionesVitales();
                funcionesV.setPaciente(edPaciente.getText().toString());
                funcionesV.setSaturacion(Double.parseDouble(edSaturacion.getText().toString()));
                funcionesV.setTemperatura(Double.parseDouble(edTemperatura.getText().toString()));
                funcionesV.setPeso(Double.parseDouble(edPeso.getText().toString()));
                funcionesV.setTalla(Double.parseDouble(edTalla.getText().toString()));
                funcionesV.setIMC(Double.parseDouble(txtImc.getText().toString()));
                funcionesV.setComentario(edComentario.getText().toString());
                dbHelper.create(funcionesV);
                Toast.makeText(this, "Datos Registrados", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), ListaFuncionesVitalesActivity.class);
                startActivity(i);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {Toast.makeText(this, "Complete todos los espacios", Toast.LENGTH_SHORT).show();}
    }
}