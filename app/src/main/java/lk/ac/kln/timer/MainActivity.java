package lk.ac.kln.timer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  int counter=100;
    private  boolean running;
    private boolean wasRunning;
    private  static  final String CURRENT_COUNTER="counter";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            counter=savedInstanceState.getInt(CURRENT_COUNTER);
        }
        running=true;

        countDown();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(CURRENT_COUNTER,counter);

    }


    private  void countDown(){

        final TextView textView=findViewById(R.id.textView);
        // textView.setText("hello");

        final Handler handler=new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                //reset the counter
                textView.setText(Integer.toString(counter));
                if(counter==0){
                    counter=99;
                }
                if(running){
                    counter--;
                }

                handler.postDelayed(this,1000);
            }
        });

    }
    @Override
    public void onStart(){
        super.onStart();
        running=true;
    }

    @Override
    public void onStop(){
        super.onStop();
        running=false;
    }
}

