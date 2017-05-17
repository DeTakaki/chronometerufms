package br.ufms.detakaki.cronometro;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.textview_title)
    TextView title;
//    @BindView(R.id.textview_clock)
//    TextView clockText;
    @BindView(R.id.button_start)
    Button start;
    @BindView(R.id.button_pause)
    Button pause;
    @BindView(R.id.button_restart)
    Button restart;
    @BindView(R.id.textview_chronometer)
    Chronometer chronometer;

    long timeelapsed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        timeelapsed = 0;
    }

    @OnClick(R.id.button_start)
    void startChronometer(){
        chronometer.setBase(SystemClock.elapsedRealtime() - timeelapsed);
        chronometer.start();
        Log.d("TEST", "onclick start");

    }


    @OnClick(R.id.button_pause)
    void pauseChronometer(){
        timeelapsed = SystemClock.elapsedRealtime() - chronometer.getBase();
        chronometer.stop();
        Log.d("TEST", "onclick stop");

    }

    @OnClick(R.id.button_restart)
    void restartChronometer(){
        chronometer.stop();
        timeelapsed = 0;
        chronometer.setText(R.string.placeholder_timer);
    }

    @Override
    public void onClick(View v) {
    }
}
