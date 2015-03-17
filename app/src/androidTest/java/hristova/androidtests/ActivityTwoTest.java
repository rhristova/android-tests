package hristova.androidtests;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by radost on 3/17/15.
 */
public class ActivityTwoTest extends ActivityInstrumentationTestCase2<ActivityTwo> {

    public ActivityTwoTest() {
        super(ActivityTwo.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testPreconditions() {
        assertNotNull(getActivity());
    }

    public void testTextViewLabelText() {
        onView(withId(R.id.textView2)).check(matches(withText(R.string.activity_two)));
        
    }
}
