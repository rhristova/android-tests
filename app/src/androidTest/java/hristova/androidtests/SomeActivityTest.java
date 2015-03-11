package hristova.androidtests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by radost on 3/9/15.
 */
public class SomeActivityTest extends ActivityInstrumentationTestCase2<SomeActivity> {

    private SomeActivity activity;
    private Button button;
    private EditText editText;
    private TextView textView;
    private TextView textViewEnter;
    private TextView textViewYour;

    public SomeActivityTest(Class<SomeActivity> activityClass) {
        super(activityClass);
    }

    public SomeActivityTest() {
        super(SomeActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        activity = getActivity();
        button = (Button) activity.findViewById(R.id.button);
        editText = (EditText) activity.findViewById(R.id.editText);
        textView = (TextView) activity.findViewById(R.id.textView);
        textViewEnter = (TextView) activity.findViewById(R.id.textView_enter);
        textViewYour = (TextView) activity.findViewById(R.id.textView_your);


    }

    public void testPreconditions() {
        assertNotNull("SomeActivity is null", activity);
        assertNotNull("Button is null", button);
        assertNotNull("EditText is null", editText);
        assertNotNull("TextView is null", textView);
        assertNotNull("TextView Enter is null", textViewEnter);
        assertNotNull("TextView Your is null", textViewYour);
    }

    public void testButton_labelText() {
        final String expected =
                activity.getString(R.string.click_me);
        final String actual = button.getText().toString();
        assertEquals(expected, actual);
    }

    public void testTextViewEnter_labelText() {
        final String expected =
                activity.getString(R.string.enter_text);
        final String actual = textViewEnter.getText().toString();
        assertEquals(expected, actual);
    }

    public void testTextViewYour_labelText() {
        final String expected =
                activity.getString(R.string.your_text);
        final String actual = textViewYour.getText().toString();
        assertEquals(expected, actual);
    }

    @MediumTest
    public void testButton_layout() {

        final View decorView = activity.getWindow().getDecorView();

        ViewAsserts.assertOnScreen(decorView, button);

        final ViewGroup.LayoutParams layoutParams =
                button.getLayoutParams();
        assertNotNull(layoutParams);
        assertEquals(layoutParams.width, WindowManager.LayoutParams.WRAP_CONTENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @MediumTest
    public void testButton_clickButton() {

        TouchUtils.clickView(this, button);

        String textInEditText = editText.getText().toString();
        String textInTextView = textView.getText().toString();
        assertEquals(textInEditText, textInTextView);

    }


}
