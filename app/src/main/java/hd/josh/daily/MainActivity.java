package hd.josh.daily;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;

import synesketch.emotion.EmotionalState;
import synesketch.emotion.Empathyscope;

public class MainActivity extends AppCompatActivity {

    private EmotionalState mState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String text = "Our understanding of technology may be advancing at an ever-accelerating rate, but our knowledge of these more vague concepts -- intelligence, consciousness, what the human mind even is -- remains in a ridiculously infantile stage. Technology may be poised to usher in an era of computer-based humanity, but neuroscience, psychology and philosophy are not. The technological singularity may be approaching, but our understanding of psychology, neuroscience and philosophy is far more nebulous, and all of these fields must work in harmony in order for the singularity's promises to be fulfilled. Scientists have made vast advances in technological fields in recent decades, and computers are growing stronger by the year, but a more powerful computer does not equate to a breakthrough in philosophical understanding. More accurately mapping the brain does not mean we understand the mind.";
                    mState = Empathyscope.getInstance().feel(text);
                    Snackbar.make(view, mState.getStrongestEmotion().toString(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
