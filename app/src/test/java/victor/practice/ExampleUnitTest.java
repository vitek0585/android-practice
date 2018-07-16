package victor.practice;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import victor.library.LibraryName;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@Config(sdk = 23, constants = BuildConfig.class)
@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Context applicationContext = RuntimeEnvironment.application.getApplicationContext();
        Context baseContext = RuntimeEnvironment.application.getBaseContext();

        String s = applicationContext.getString(R.string.Name);
        String s1 = baseContext.getString(R.string.Name);
        System.out.print(s);
        System.out.println();
        System.out.print(PackageHelper.getName());

        //System.out.print(applicationContext.getString(victor.practice.test.R.string.app_name));
    }

    @Test
    public void testLibrary(){
        LibraryName lm = new LibraryName();
        System.out.print(lm.getName());
    }
}