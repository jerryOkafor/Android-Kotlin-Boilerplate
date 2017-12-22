package me.jerryhanks.kotlindagger

import me.jerryhanks.kotlindagger.data.db.UserDaoTest
import me.jerryhanks.kotlindagger.ui.MainActivityTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(MainActivityTest::class, UserDaoTest::class)
class InstrumentedTestSuite
