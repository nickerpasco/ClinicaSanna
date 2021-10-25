package royal.spring.clinicasanna;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import royal.spring.clinicasanna.tabcontrol.SectionsPagerAdapter;

public class ListadosActivity extends AppCompatActivity {
TabLayout tabLayout;
ViewPager viewPagerList;

SectionsPagerAdapter sectionsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listados);

        tabLayout = findViewById(R.id.tabList);
        viewPagerList = findViewById(R.id.viewPagerList);


        sectionsPagerAdapter =  new SectionsPagerAdapter( getSupportFragmentManager(),this);
        viewPagerList.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPagerList);
    }
}