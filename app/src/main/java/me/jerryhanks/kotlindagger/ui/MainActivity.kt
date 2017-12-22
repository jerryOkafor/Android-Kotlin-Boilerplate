package me.jerryhanks.kotlindagger.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import me.jerryhanks.kotlindagger.R
import me.jerryhanks.kotlindagger.data.db.entity.User
import timber.log.Timber
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {


    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init the mainViewModel
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.loadUsers().observe(this, Observer<List<User>> { users ->
            users?.forEach { user -> Timber.d(user.toString()) }
        })

//
//        //find the main btn
//        val mainBtn = findViewById<Button>(R.id.btn_clickme)
        //set onClick to the main btn
        btnClickMe.setOnClickListener({ Toast.makeText(this, "You Clicked the Main Button", Toast.LENGTH_LONG).show() })

    }


    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return fragmentInjector

    }
}
