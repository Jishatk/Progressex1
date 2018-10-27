package example.com.progressex1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.button2);
        b1=findViewById(R.id.button);
    }

    public void showProg(View v){

      //  ProgressDialog pd=ProgressDialog.show(MainActivity.this,"ProgressBar","Loading ... wait",false);

        final ProgressDialog pd=new ProgressDialog(MainActivity.this);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setTitle("Horizontal progress");
        pd.setMessage("loading...");
        pd.setIndeterminate(false);
        pd.setProgress(10);
        pd.setMax(100);

        final int totalProgressTime = 100;
        final int add=10;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while(jumpTime < totalProgressTime) {
                    try {
                        sleep(300);
                        jumpTime += 5;
                        pd.setProgress(jumpTime);
                        pd.incrementProgressBy(add);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        pd.show();
    }

    public void showNext(View v)
    {
        Intent i1=new Intent(MainActivity.this,DateActivity.class);
        startActivity(i1);
    }
}
