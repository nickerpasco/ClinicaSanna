package royal.spring.clinicasanna;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import royal.spring.clinicasanna.clases.Usuario;

public class RegistroActivity extends AppCompatActivity {

    ImageView BtnGuardar,atrasPrioridad;
    ProgressDialog mPDialog;
    EditText TxtTxtApellidos,TxtUsuario,TxtContrasenia,TxtCelularPNuevo,TxtCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        BtnGuardar = (ImageView)findViewById(R.id.BtnGuardar);
        atrasPrioridad = (ImageView)findViewById(R.id.atrasPrioridad);
        TxtTxtApellidos = (EditText)findViewById(R.id.TxtNombresApellidos);
        TxtUsuario = (EditText)findViewById(R.id.TxtUsuario);
        TxtContrasenia = (EditText)findViewById(R.id.TxtContrasenia);
        TxtCelularPNuevo = (EditText)findViewById(R.id.txtPacCel);
        TxtCorreo = (EditText)findViewById(R.id.TxtCorreo);

        atrasPrioridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                EsperarTask d = new EsperarTask();
                d.setContext(RegistroActivity.this);
                d.execute();

                 */
                GuardarUsuario();
            }
        });
    }

    private void GuardarUsuario() {
        DBHelper dbHelper;
        dbHelper = new DBHelper(this); // INSTANCIAR PAPUS
        try {
            Usuario usuario = new Usuario();

            if(TxtTxtApellidos.getText().equals("")){
                Toast.makeText(this, "Ingrese Apellido", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TxtUsuario.getText().equals("")){
                Toast.makeText(this, "Ingrese Usuario", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TxtContrasenia.getText().equals("")){
                Toast.makeText(this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TxtCelularPNuevo.getText().equals("")){
                Toast.makeText(this, "Ingrese Celular", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TxtCorreo.getText().equals("")){
                Toast.makeText(this, "Ingrese Correo", Toast.LENGTH_SHORT).show();
                return;
            }

            usuario.setApellidosNombres(TxtTxtApellidos.getText().toString());
            usuario.setCelular(TxtCelularPNuevo.getText().toString());
            usuario.setContrasenia(TxtContrasenia.getText().toString());
            usuario.setCorreo(TxtCorreo.getText().toString());
            usuario.setUsuario(TxtUsuario.getText().toString());
            dbHelper.create(usuario);
            List<Usuario> lis = (ArrayList<Usuario>) dbHelper.getAll(Usuario.class);
            Toast.makeText(this, "Usuario : " + lis.get(0).getUsuario()  +" Registrado ", Toast.LENGTH_SHORT).show();
            finish();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    private class EsperarTask extends AsyncTask<Void,Void,Void>
    {

        private Context mContext;
        void setContext(Activity context) {
            mContext = context;
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mPDialog = new ProgressDialog(mContext);
                    mPDialog.setMessage("Guardando...");
                    mPDialog.setIndeterminate(true);
                    mPDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    mPDialog.setCancelable(false);
                    mPDialog.show();
                }
            });
        }

        @Override
        protected Void doInBackground(Void... voids) {
            GuardarUsuario();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {


            try{


                if (mPDialog != null)
                    mPDialog.dismiss();
                Toast.makeText(RegistroActivity.this, "Se guardó correctamente..", Toast.LENGTH_SHORT).show();
            }catch(Exception e){

                e.printStackTrace();

            }
        }
    }
}