package com.poorfellow.spellbookmanager;

import android.test.ActivityInstrumentationTestCase2;
import com.poorfellow.spellbookmanager.ui.activity.ManagerHome;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.poorfellow.spellbookmanager.ui.activity.ManagerHomeTest \
 * com.poorfellow.spellbookmanager.tests/android.test.InstrumentationTestRunner
 */
public class ManagerHomeTest extends ActivityInstrumentationTestCase2<ManagerHome> {

    public ManagerHomeTest() {
        super("com.poorfellow.spellbookmanager", ManagerHome.class);
    }

}
