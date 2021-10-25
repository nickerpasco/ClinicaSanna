package royal.spring.clinicasanna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import royal.spring.clinicasanna.ui.MainActivity;

public class InicarLoginActivity extends AppCompatActivity {

    Button button;
    TextView TvRegitro,textView4,textView52;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicar_login);

        button = (Button)findViewById(R.id.button);
        TvRegitro = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView52 = findViewById(R.id.textView52);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_tv);
                button.startAnimation(animFadein);



                startActivity(new Intent(InicarLoginActivity.this, MainActivity.class));

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
}