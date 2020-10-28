package com.arthur.rickandmortyapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashActivity : Activity() {

    private var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
    }

    override fun onResume() {
        super.onResume()
        compositeDisposable.add(Observable.timer(2, TimeUnit.SECONDS)
                .subscribe {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                })
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }
}