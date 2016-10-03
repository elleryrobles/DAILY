package hd.josh.daily.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import hd.josh.daily.R;
import hd.josh.daily.adapters.CardFragmentPagerAdapter;
import hd.josh.daily.utils.AppController;
import hd.josh.daily.utils.ShadowTransformer;
import hd.josh.daily.utils.Tools;
import synesketch.emotion.EmotionalState;

public class HomeActivity extends AppCompatActivity {

    private EmotionalState mState;
    private ViewPager mViewPager;
    private CardFragmentPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppController.getInstance().generateTestDays(10);

        mViewPager = (ViewPager) findViewById(R.id.home_entry_viewpager);
        mCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(), Tools.dpToPixels(this, 2));
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);

        mCardShadowTransformer.enableScaling(true);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
