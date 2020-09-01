package com.training.rxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    private lateinit var observer: Observer<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.just(1,2,3,4,5)
            .subscribeOn(Schedulers.io())// the first observeOn() will be taken into consideration
            .doOnNext { item ->  Log.d(TAG, "upStream :$item ,current thread :${Thread.currentThread().name}")}  // upStream
            .observeOn(Schedulers.io())
            .observeOn(Schedulers.computation()) // the last observeOn() will be taken into consideration
            .subscribe { item ->  Log.d(TAG, "downStream :$item,current thread :${Thread.currentThread().name}") } //downStream
    }
}
