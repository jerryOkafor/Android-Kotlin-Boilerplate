package me.jerryhanks.kotlindagger

import org.junit.runner.RunWith
import org.junit.runners.Suite


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(ExampleUnitTest::class,MainViewModelTest::class)
class UnitTestSuite

