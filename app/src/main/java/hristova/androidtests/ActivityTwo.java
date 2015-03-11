package hristova.androidtests;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ActivityTwo extends Activity {

    public final static String EXTRAS_PAYLOAD_KEY
            = "hristova.androidtests.EXTRAS_PAYLOAD_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        final String stringPayload = getIntent().getStringExtra(EXTRAS_PAYLOAD_KEY);

        if (stringPayload != null) {
            ((TextView) findViewById(R.id.textView2)).setText(stringPayload);
        }
    }


    /**
     * Factory method to create a launch Intent for this activity.
     *
     * @param context the context that intent should be bound to
     * @param payload the payload data that should be added for this intent
     * @return a configured intent to launch this activity with a String payload.
     */
    public static Intent makeIntent(Context context, String payload) {
        return new Intent(context, ActivityTwo.class).putExtra(EXTRAS_PAYLOAD_KEY, payload);
    }


}
