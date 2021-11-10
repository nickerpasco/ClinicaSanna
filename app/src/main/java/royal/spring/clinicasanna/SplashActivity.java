package royal.spring.clinicasanna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import royal.spring.clinicasanna.ui.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {





                SharedPreferences preferences = getSharedPreferences("PrefeM", Context.MODE_PRIVATE);
                String usuario = preferences.getString("Usuario", "");

                if(usuario ==null || usuario.equals("")){
                    startActivity(new Intent(SplashActivity.this,InicarLoginActivity.class));
                }else{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }


            }
        },2000);





    }
}