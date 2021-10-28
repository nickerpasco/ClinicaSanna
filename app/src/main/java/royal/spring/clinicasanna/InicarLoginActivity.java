package royal.spring.clinicasanna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import royal.spring.clinicasanna.clases.Usuario;
import royal.spring.clinicasanna.ui.MainActivity;

public class InicarLoginActivity extends AppCompatActivity {

    Button button;
    TextView TvRegitro,textView4,textView52;
    EditText editText,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicar_login);

        button = (Button)findViewById(R.id.button);
        TvRegitro = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView52 = findViewById(R.id.textView52);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_tv);
                button.startAnimation(animFadein);


                ValidarUsuario();





            }
        });

        TvRegitro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_tv);
                TvRegitro.startAnimation(animFadein);
                startActivity(new Intent(InicarLoginActivity.this,RegistroActivity.class));
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_tv);
                textView4.startAnimation(animFadein);
                startActivity(new Intent(InicarLoginActivity.this,RecuperarContraseniaActivity.class));
            }
        });

        textView52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_tv);
                textView52.startAnimation(animFadein);
                startActivity(new Intent(InicarLoginActivity.this,CambiarContraseniaActivity.class));
            }
        });

    }

    private void ValidarUsuario() {



        DBHelper dbHelper;
        dbHelper = new DBHelper(this); // INSTANCIAR PAPUS
        try {

            List<Usuario> lis = (ArrayList<Usuario>) dbHelper.getAll(Usuario.class);

            if (Acceder(lis)){
                startActivity(new Intent(InicarLoginActivity.this, MainActivity.class));

            }else{
                Toast.makeText(this, "Usuario No encontrado", Toast.LENGTH_SHORT).show();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private boolean Acceder(List<Usuario> lis) {

        String usuario = editText.getText().toString();
        String pass = editText2.getText().toString();


        for (Usuario item : lis){

            if(item.getUsuario().equals(usuario) && item.getUsuario().equals(pass)){

                return true;
            }

        }

        return false;

    }
}