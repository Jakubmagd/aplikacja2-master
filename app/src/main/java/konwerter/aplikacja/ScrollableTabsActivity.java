package konwerter.aplikacja;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ScrollableTabsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new AreaFragment(), getString(R.string.area));
        adapter.addFrag(new DataTransferRateFragment(), getString(R.string.data_transfer_rate));
        adapter.addFrag(new DigitalStorageFragment(), getString(R.string.digital_storage));
        adapter.addFrag(new EnergyFragment(), getString(R.string.energy));
        adapter.addFrag(new FrequencyFragment(), getString(R.string.frequency));
        ;
        adapter.addFrag(new LengthFragment(), getString(R.string.length));
        adapter.addFrag(new MassFragment(), getString(R.string.mass));

        adapter.addFrag(new PressureFragment(), getString(R.string.pressure));
        adapter.addFrag(new SpeedFragment(), getString(R.string.speed));
        adapter.addFrag(new TemperatureFragment(), getString(R.string.temperature));
        adapter.addFrag(new TimeFragment(), getString(R.string.time));
        adapter.addFrag(new VolumeFragment(), getString(R.string.volume));
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.scrollable_tabs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_area) {
            // Handle the camera action
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(0);
        } else if (id == R.id.nav_data_transfer_rate) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(1);
        } else if (id == R.id.nav_digital_storage) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(2);
        } else if (id == R.id.nav_energy) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(3);
        } else if (id == R.id.nav_frequency) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(4);

        } else if (id == R.id.nav_length) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(6);
        } else if (id == R.id.nav_mass) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(7);

        } else if (id == R.id.nav_pressure) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(9);
        } else if (id == R.id.nav_speed) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(10);
        } else if (id == R.id.nav_temperature) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(11);
        } else if (id == R.id.nav_time) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(12);
        } else if (id == R.id.nav_volume) {
            ((ViewPager) findViewById(R.id.viewpager)).setCurrentItem(13);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
