package me.jerryhanks.kotlindagger.util

import org.mockito.ArgumentCaptor

/**
 * @author <@Po10cio> on 11/3/17 for AndroidKotlinBoilerplate
 *
 *
 * Returns ArgumentCaptor.capture() as nullable type to avoid java.lang.illegalStateException
 * when null is returned
 *
 * Sometimes there are situations where I need to assert the arguments that are passed into a
 * service, but that arguments are instantiated within a method that you want to test and in
 * which case it cannot be asserted using a plain JUnit test.
 */

fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()