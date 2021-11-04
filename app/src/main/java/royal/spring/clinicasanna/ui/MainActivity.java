package royal.spring.clinicasanna.ui;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import royal.spring.clinicasanna.DBHelper;
import royal.spring.clinicasanna.FuncionesAdapter;
import royal.spring.clinicasanna.R;
import royal.spring.clinicasanna.RegistroFuncionesVitalesActivity;
import royal.spring.clinicasanna.VerticalSpaceItemDecoration;
import royal.spring.clinicasanna.clases.FuncionesVitales;

public class MainActivity extends AppCompatActivity {

    TextView BtnRegistro;


    ArrayList<FuncionesVitales> listaPedidos;
    RecyclerView RecyclerPedidos;
    FuncionesAdapter adapter;
    //private SwipeRefreshLayout swipeContainer;
    ImageView pin_icon;
    TextView address_selected_textview;
    Button btnMapa;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnRegistro = (TextView) findViewById(R.id.BtnRegistro);

        listaPedidos = new ArrayList<>();
        RecyclerPedidos = (RecyclerView) findViewById(R.id.RecyclerPedidosCab);

        //swipeContainer = (SwipeRefreshLayout)findViewById( R.id.Refreshcars );

        RecyclerPedidos.setLayoutManager(new LinearLayoutManager(this));
        RecyclerPedidos.addItemDecoration(new VerticalSpaceItemDecoration(20)) ;

        dbHelper = new DBHelper(this);

        try {
            CargarFunciones();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        BtnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RegistroFuncionesVitalesActivity.class));

            }
        });
    }


    private void CargarFunciones() throws SQLException {


        List<FuncionesVitales> lis  = new ArrayList<>(); //(ArrayList<FuncionesVitales>) dbHelper.getAll(FuncionesVitales.class);
        lis.add(new FuncionesVitales(1,2,"PASCO RODRIGUEZ NICKER OSCAR","Jr Geishas","12/12/12","ATENDIDO","MÉDICO LUIS"));
        lis.add(new FuncionesVitales(1,2,"JEFERSON FARFAN GUADALUPE","Jr Cucardas 281","12/12/12","ATENDIDO","MÉDICO LUIS"));
        lis.add(new FuncionesVitales(1,2,"MILLET FIGEROA HINOSTROZA","Jr Avrequa","12/12/12","ATENDIDO","MÉDICO LUIS"));
        lis.add(new FuncionesVitales(1,2,"FRANCISCO PIZARRO HUERAS","Jr Combate de angamos","12/12/12","ATENDIDO","MÉDICO LUIS"));
        lis.add(new FuncionesVitales(1,2,"MÍA KHALIFA RAMOS","Jr Santa ana","12/12/12","ATENDIDO","MÉDICO LUIS"));
        lis.add(new FuncionesVitales(1,2,"PAOLA CARBONE GARÍ","Jr Santa Patrica","12/12/12","ATENDIDO","MÉDICO LUIS"));

        listaPedidos = (ArrayList<FuncionesVitales>) lis;


        adapter = new FuncionesAdapter(  listaPedidos,this );
        RecyclerPedidos.setAdapter( adapter );
        adapter.notifyDataSetChanged();
    }


}
