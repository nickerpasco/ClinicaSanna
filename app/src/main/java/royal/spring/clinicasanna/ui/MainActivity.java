package royal.spring.clinicasanna.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
//import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import royal.spring.clinicasanna.DBHelper;
import royal.spring.clinicasanna.FuncionesAdapter;
import royal.spring.clinicasanna.InicarLoginActivity;
import royal.spring.clinicasanna.R;
import royal.spring.clinicasanna.RegistroFuncionesVitalesActivity;
import royal.spring.clinicasanna.VerticalSpaceItemDecoration;
import royal.spring.clinicasanna.clases.Bean;
import royal.spring.clinicasanna.clases.FuncionesVitales;

public class MainActivity extends AppCompatActivity {

    TextView BtnRegistro;


    ArrayList<FuncionesVitales> listaPedidos;
    RecyclerView RecyclerPedidos;
    FuncionesAdapter adapter;
    //private SwipeRefreshLayout swipeContainer;
    ImageView pin_icon,back;
    TextView address_selected_textview;
    Button btnMapa;
    DBHelper dbHelper;


    TextView Daonloaad;
    WritableWorkbook workbook;
    ImageView BtnExcel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnRegistro = (TextView) findViewById(R.id.BtnRegistro);
        BtnExcel = (ImageView) findViewById(R.id.BtnExcel);
        back = (ImageView) findViewById(R.id.back);

        listaPedidos = new ArrayList<>();
        RecyclerPedidos = (RecyclerView) findViewById(R.id.RecyclerPedidosCab);

        //swipeContainer = (SwipeRefreshLayout)findViewById( R.id.Refreshcars );

        RecyclerPedidos.setLayoutManager(new LinearLayoutManager(this));
        RecyclerPedidos.addItemDecoration(new VerticalSpaceItemDecoration(20)) ;

        dbHelper = new DBHelper(this);


        BtnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_tv);
                BtnRegistro.startAnimation(animFadein);
                startActivity(new Intent(MainActivity.this, RegistroFuncionesVitalesActivity.class));

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_tv);
                back.startAnimation(animFadein);


                SharedPreferences preferences = getSharedPreferences("PrefeM", Context.MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = preferences.edit();
                prefsEditor.putString("Usuario", "");
                prefsEditor.clear();
                prefsEditor.commit();




                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
                Intent intent = new Intent(getApplicationContext(), InicarLoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });




        BtnExcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
                else
                {
                    //your code
                    createExcelSheet();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        try {
            CargarFunciones();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.onStart();
    }

    private void CargarFunciones() throws SQLException {


        List<FuncionesVitales> lis  = (ArrayList<FuncionesVitales>) dbHelper.getAll(FuncionesVitales.class);

        listaPedidos = (ArrayList<FuncionesVitales>) lis;


        adapter = new FuncionesAdapter(  listaPedidos,this );
        RecyclerPedidos.setAdapter( adapter );
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();
      //  finish();
    }

    void createExcelSheet() {
        //File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

        String csvFile = "ExcelsheetName.xls";
        java.io.File futureStudioIconFile = new java.io.File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "/" + csvFile);
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        try {
            workbook = Workbook.createWorkbook(futureStudioIconFile, wbSettings);
            createFirstSheet();
//            createSecondSheet();
            //closing cursor
            workbook.write();
            workbook.close();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            File file = new File(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    + "/" + csvFile);
            Uri path = FileProvider.getUriForFile(getApplicationContext(), "com.something.racecalculator.fileprovide", file);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(path, "application/vnd.ms-excel");
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void createFirstSheet() {
        try {
            List<Bean> listdata = new ArrayList<>();

            listdata.add(new Bean("mr","firstName1","middleName1","lastName1"));
            listdata.add(new Bean("mr","firstName1","middleName1","lastName1"));
            listdata.add(new Bean("mr","firstName1","middleName1","lastName1"));
            //Excel sheet name. 0 (number)represents first sheet
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            // column and row title
            sheet.addCell(new Label(0, 0, "NameInitial"));
            sheet.addCell(new Label(1, 0, "firstName"));
            sheet.addCell(new Label(2, 0, "middleName"));
            sheet.addCell(new Label(3, 0, "lastName"));

            for (int i = 0; i < listdata.size(); i++) {
                sheet.addCell(new Label(0, i + 1, listdata.get(i).getInitial()));
                sheet.addCell(new Label(1, i + 1, listdata.get(i).getFirstName()));
                sheet.addCell(new Label(2, i + 1, listdata.get(i).getMiddleName()));
                sheet.addCell(new Label(3, i + 1, listdata.get(i).getLastName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
            return false; //I have tried here true also
        }
        return super.onKeyDown(keyCode, event);
    }

}
