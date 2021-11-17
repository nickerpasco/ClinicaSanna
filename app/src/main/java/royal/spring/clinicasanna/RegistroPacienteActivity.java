package royal.spring.clinicasanna;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import royal.spring.clinicasanna.clases.FuncionesVitales;
import royal.spring.clinicasanna.clases.Paciente;


public class RegistroPacienteActivity extends AppCompatActivity {

    ImageView btnGuardar,btnAtras;
    EditText txtNombre,txtDoc,txtCorreo,txtCelular,txtEdad, txtDireccion, txtSexo,txtSeguro;
    MaterialSpinner SpPacSexo,SpPacSeguro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);

        btnGuardar = findViewById(R.id.BtnPacGuardar);
        btnAtras = findViewById(R.id.atrasPrioridad);
        txtNombre = findViewById(R.id.txtPacNom);
        txtDoc  = findViewById(R.id.txtPacDoc);
        txtCorreo = findViewById(R.id.txtPacCorreo);
        txtCelular = findViewById(R.id.txtPacCel);
        txtEdad = findViewById(R.id.txtPacEdad);
        txtDireccion = findViewById(R.id.txtPacDir);
        SpPacSexo = findViewById(R.id.SpPacSexo);


        LoadAños();


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                GuardarPaciente();

            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void LoadAños() {

        ArrayList arrayList = new ArrayList();
        arrayList.add("Masculino");
        arrayList.add("Femenino");
        arrayList.add("Otros");

        ArrayAdapter<String> adapterSpTipoDocPNuevo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        adapterSpTipoDocPNuevo.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        SpPacSexo.setItems(arrayList);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void GuardarPaciente() {
        if (txtNombre.length() !=0 && txtDoc.length() != 0 && txtCorreo.length() != 0
                && txtCelular.length() != 0 && txtEdad.length() != 0 && txtDireccion.length() != 0) {

            DBHelper dbHelper;
            dbHelper = new DBHelper(this);

            try {

                Paciente paciente = new Paciente();
                paciente.setNombres(txtNombre.getText().toString());
                paciente.setDocumento(txtDoc.getText().toString());
                paciente.setCorreo(txtCorreo.getText().toString());
                paciente.setCorreo(txtCelular.getText().toString());
                paciente.setEdad(Integer.parseInt(txtEdad.getText().toString()));
                paciente.setDireccion(txtDireccion.getText().toString());
                dbHelper.create(paciente);
                Toast.makeText(this, "Datos Registrados", Toast.LENGTH_SHORT).show();
                finish();
            } catch ( SQLException throwables) {
                throwables.printStackTrace();
            }

        }else {Toast.makeText(this, "Complete todos los espacios", Toast.LENGTH_SHORT).show();}
    }

    public static String formatearFecha(Date date) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy

        String strDate = sdfDate.format(date);
        return strDate;
    }
}