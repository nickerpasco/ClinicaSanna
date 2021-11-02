package royal.spring.clinicasanna.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import royal.spring.clinicasanna.Adaptadores.AdaptaFunciones;
import royal.spring.clinicasanna.DBHelper;
import royal.spring.clinicasanna.R;
import royal.spring.clinicasanna.RegistroFuncionesVitalesActivity;
import royal.spring.clinicasanna.clases.FuncionesVitales;
import royal.spring.clinicasanna.clases.Usuario;

public class ListaFuncionesVitalesActivity extends AppCompatActivity {

    TextView BtnRegistro;
    RecyclerView rvListaFunciones;
    AdaptaFunciones adaptaFunciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_funciones_vitales);

        BtnRegistro =(TextView)findViewById(R.id.BtnRegistro);
        rvListaFunciones = findViewById(R.id.rvListaFuncionesV);

        BtnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaFuncionesVitalesActivity.this, RegistroFuncionesVitalesActivity.class));
            }
        });

        DBHelper dbHelper = new DBHelper(this);
        try {
            List<FuncionesVitales> lista = dbHelper.getAll(FuncionesVitales.class);
            adaptaFunciones = new AdaptaFunciones(lista,this);
            rvListaFunciones.setLayoutManager(new LinearLayoutManager(this));
            rvListaFunciones.setAdapter(adaptaFunciones);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
