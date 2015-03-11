package hristova.androidtests;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

/**
 * Created by radost on 3/11/15.
 */
public class ActivityOneTest extends ActivityUnitTestCase<ActivityOne> {

    private Intent launchIntentOne;
    private Button button;

    public ActivityOneTest(Class<ActivityOne> activityClass) {
        super(activityClass);
    }

    public ActivityOneTest() {
        super(ActivityOne.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        launchIntentOne = new Intent(getInstrumentation().getTargetContext(), ActivityOne.class);
        startActivity(launchIntentOne, null, null);
        button = (Button) getActivity().findViewById(R.id.button);

    }

    public void testPreconditions() {
        assertNotNull("SomeActivity is null", getActivity());
        assertNotNull("Button is null", button);

    }

    @MediumTest
    public void testActivityTwoWasLaunchedWithIntent() {

        button.performClick();

        final Intent launchIntentTwo = getStartedActivityIntent();
        assertNotNull("Intent was null", launchIntentTwo);
        assertTrue(isFinishCalled());

        final String payload =
                launchIntentTwo.getStringExtra(ActivityTwo.EXTRAS_PAYLOAD_KEY);
        assertEquals("Payload is empty", ActivityOne.STRING_PAYLOAD, payload);
    }
}
