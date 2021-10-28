package royal.spring.clinicasanna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class RegistroFuncionesVitalesActivity extends AppCompatActivity {

    EditText edSaturacion, edTemperatura, edPeso, edTalla, edComentario;
    TextInputEditText txtImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_funciones_vitales);
        edSaturacion = findViewById(R.id.edSaturacion);
        edTemperatura = findViewById(R.id.edTemperatura);
        edPeso = findViewById(R.id.edPeso);
        edTalla = findViewById(R.id.edTalla);
        edComentario = findViewById(R.id.edComentario);
        txtImc = findViewById(R.id.txtImc);

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


    }

    public void IMC() {
        if (edPeso.length() != 0 && edTalla.length() != 0) {
            double p = Double.parseDouble(edPeso.getText().toString());
            double t = Double.parseDouble(edTalla.getText().toString());
            double imc = p / (Math.pow(t, 2));
            Log.w("IMC: ", String.valueOf(imc));
            DecimalFormat formato = new DecimalFormat("#0.00");
            txtImc.setText(formato.format(imc));
        }else {
            txtImc.setText("");
        }
    }

}