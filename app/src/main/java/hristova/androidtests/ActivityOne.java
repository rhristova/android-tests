package hristova.androidtests;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ActivityOne extends Activity {

    public final static String STRING_PAYLOAD = "Started from ActivityOne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Button launchNextButton = (Button) findViewById(R.id.button);
        launchNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ActivityTwo.makeIntent(ActivityOne.this, STRING_PAYLOAD));
                finish();
            }
        });
    }


}
