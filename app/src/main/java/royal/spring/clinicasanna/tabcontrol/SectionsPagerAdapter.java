package royal.spring.clinicasanna.tabcontrol;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import royal.spring.clinicasanna.R;
import royal.spring.clinicasanna.fragmentos.ListaFuncionVitalesFragment;
import royal.spring.clinicasanna.fragmentos.ListadoPacientesFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

   private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ListaFuncionVitalesFragment();
                break;
            case 1:
                fragment = new ListadoPacientesFragment();
                break;
        }
        assert fragment != null;
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
