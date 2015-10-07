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
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends Activity{
    Button btn;
    Timer myTimer = null;
    TimerTask timerTask;
    MediaPlayer mediaPlayer;
    EditText et;

    public void clickTHIS(View view) {

        btn = (Button)view.findViewById(R.id.button);

        if(view == btn) {
            View mainview = findViewById(R.id.appster);
            et = (EditText) mainview.findViewById(R.id.editText2);
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.beep_03);
            }
            if (timerTask != null) {
                timerTask.cancel();
                timerTask = null;
                btn.setText("START");
            } else {
                btn.setText("STOP");
                int sec = 3;
                if (et != null) {
                    String s = et.getText().toString();
                    sec = Integer.parseInt(s);
                }
                myTimer = new Timer();
                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        mediaPlayer.start();
                    }
                };
                myTimer.schedule(timerTask, 0, sec * 1000);
            }
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
        if(id == R.id.tea_time_presets) {
            Intent i = new Intent(this, TeaTimeActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
