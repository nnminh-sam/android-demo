package nnminh.android.nguyennhatminhn21dccn053;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        checkAndRequestPermissions();

        mViewPager = findViewById(R.id.view_pager);
        mBottomNavigationView = findViewById(R.id.bottomNavigation);

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewpagerAdapter);
        mViewPager.setCurrentItem(0);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Tab 1");
        }

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (getSupportActionBar() != null) {
                    switch (position) {
                        case 0:
                            mBottomNavigationView.getMenu().findItem(R.id.gridView).setChecked(true);
                            getSupportActionBar().setTitle("Tab 1");
                            break;
                        case 1:
                            mBottomNavigationView.getMenu().findItem(R.id.listView).setChecked(true);
                            getSupportActionBar().setTitle("Tab 2");
                            break;
                        case 2:
                            mBottomNavigationView.getMenu().findItem(R.id.accountView).setChecked(true);
                            getSupportActionBar().setTitle("Tab 3");
                            break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.gridView:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.listView:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.accountView:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}












