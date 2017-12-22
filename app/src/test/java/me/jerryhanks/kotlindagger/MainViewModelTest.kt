package me.jerryhanks.kotlindagger

import android.arch.core.executor.testing.InstantTaskExecutorRule
import me.jerryhanks.kotlindagger.data.Repository
import me.jerryhanks.kotlindagger.data.db.entity.User
import me.jerryhanks.kotlindagger.ui.MainViewModel
import me.jerryhanks.kotlindagger.util.LiveDataTestUtil.getValue
import me.jerryhanks.kotlindagger.util.TestUtil
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.isEmptyOrNullString
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito.`when`
import org.mockito.Mockito.isNull

/**
 * @author <@Po10cio> on 11/3/17 for AndroidKotlinBoilerplate
 *
 */
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock private lateinit var repository: Repository

    @Captor private lateinit var userArgumentCaptor: ArgumentCaptor<User>

    private lateinit var mainViewModel: MainViewModel


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mainViewModel = MainViewModel(repository)
    }

    @Test
    fun `loadUsers_whenNoUserSaved`() {
        `when`(repository.loadUsers()).thenReturn(TestUtil.createEmptyUsers())

        val users = getValue(mainViewModel.loadUsers())
        assertThat(users, nullValue())
    }

    @Test
    fun `loadUser_whenUserSaved`() {
        `when`(repository.loadUsers()).thenReturn(TestUtil.createUsers())

        val users = getValue(mainViewModel.loadUsers())
        assertThat(users, notNullValue())

    }
}