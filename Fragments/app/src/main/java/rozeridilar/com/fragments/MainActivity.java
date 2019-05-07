package rozeridilar.com.fragments;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsStatePagerAdapter sectionsStatePagerAdapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: MainActivity started.");

        sectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);

        //setup view pager
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mSectionsStatePagerAdapter.addFragment(new FragmentOne(),"Fragment1");
        mSectionsStatePagerAdapter.addFragment(new FragmentTwo(),"Fragment2");
        mSectionsStatePagerAdapter.addFragment(new FragmentThree(),"Fragment3");
        viewPager.setAdapter(mSectionsStatePagerAdapter);
    }

    public void changeAdapter(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }


}
