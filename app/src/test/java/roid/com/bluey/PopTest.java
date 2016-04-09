package roid.com.bluey;

import android.app.Activity;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import roid.com.bluey.activity.BlueyActivity;

import static junit.framework.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ubu on 4/9/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=19)
public class PopTest {

    TextView txt;

    @Before
    public void setUp() {
        Activity activity = Robolectric.setupActivity(BlueyActivity.class);
        txt = (TextView) activity.findViewById(R.id.text);
    }

    @Test
    public void titleIsCorrect() throws Exception {
        assertThat(txt.getText().toString() ).isEqualTo("Hello Bluey!");

    }

}
