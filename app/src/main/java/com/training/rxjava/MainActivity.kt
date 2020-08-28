package com.training.rxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    private lateinit var observer: Observer<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*factory method: create()**************************************/
        val observable =
            Observable.create(ObservableOnSubscribe<Int> {
                for (i in 0..5) it.onNext(i)
                it.onComplete()
            })

        /********************************************************/
        /*factory method : just()**************************************/
        val observable1 =
            Observable.just(0, 1, 2, 3, 4, 5)

        /********************************************************/

        /*factory method : fromArray()**************************************/
        var array = arrayOf(0, 1, 2, 3, 4, 5)
        val observable2 =
            Observable.fromArray(array)

        /********************************************************/
        /*factory method : range()**************************************/
        val observable3 =
            Observable.range(0, 5)
        /********************************************************/

        observer = object : Observer<Any?> {
            override fun onSubscribe(d: @NonNull Disposable?) {
                Log.d(TAG, "onSubscribe :")
            }

            override fun onNext(o: Any?) {
                Log.d(TAG, "onNext :$o")
            }

            override fun onError(e: @NonNull Throwable?) {
                Log.d(TAG, "onError :$e")
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete :")
            }
        }
//Modify here
//        observable.subscribe(observer as Observer<Any?>)
//        observable1.subscribe(observer as Observer<Any?>)
//        observable2.subscribe(observer as Observer<Any?>)
        observable3.subscribe(observer as Observer<Any?>)

    }
}
