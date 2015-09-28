package it.backsearch.fooo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.media.MediaPlayer;
import java.util.TimerTask;
import java.util.Timer;

public class MainActivity extends Activity{
    Button btn;
    Timer myTimer = null;
    TimerTask timerTask;
    MediaPlayer mediaPlayer;

    public void clickTHIS(View view) {

        btn = (Button)(view.findViewById(R.id.button));
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.beep_03);
        }
        if(timerTask != null) {
            timerTask.cancel();
            timerTask = null;
            btn.setText("START");
        } else {
            btn.setText("STOP");

            myTimer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    mediaPlayer.start();
                }
            };
            myTimer.schedule(timerTask, 0, 4000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items t:o the action bar if it is present.
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
