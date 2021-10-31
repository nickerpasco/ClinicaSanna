package royal.spring.clinicasanna.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import royal.spring.clinicasanna.R;
import royal.spring.clinicasanna.RegistroFuncionesVitalesActivity;

public class ListaFuncionesVitalesActivity extends AppCompatActivity {

    TextView BtnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_funciones_vitales);

        BtnRegistro =(TextView)findViewById(R.id.BtnRegistro);

        BtnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaFuncionesVitalesActivity.this, RegistroFuncionesVitalesActivity.class));
            }
        });
    }
}
