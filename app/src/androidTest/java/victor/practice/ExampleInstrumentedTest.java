package victor.practice;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import dao.AutoDatabase;
import dao.CarStore;
import models.Car;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    AutoDatabase db;
    CarStore store;
    @Rule
    public ActivityTestRule<MainActivity> mActivity = new ActivityTestRule<>(MainActivity.class);
    @Before
    public void setUp() {
        db=AutoDatabase.create(InstrumentationRegistry.getTargetContext(), true);
        store=db.carStore();
    }
    @After
    public void tearDown() {
        db.close();
    }
    @Test
    public void create() {
        List<Long> cars = store.insert(new Car("Bmw", new Date(Calendar.getInstance().getTimeInMillis())));
        assertThat(cars, Matchers.<Long>hasSize(1));
        assertThat(cars,Matchers.hasItems(cars.get(0)));
        onView(withId(R.id.hello)).check(ViewAssertions.matches(isDisplayed()));
    }
}
