package com.training.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit
fun sleep(time: Long){
    Thread.sleep(time)
}
class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Hot observable 2***********************************************
         *PublishSubject*/

        var subject = PublishSubject.create<String>()
        // observer 1
        subject.subscribe { Log.d(TAG, "observer1 receive: $it") }
        subject.onNext("A")
        sleep(1000)
        subject.onNext("B")
        sleep(1000)
        subject.onNext("C")
        sleep(1000)
        subject.onNext("D")
        sleep(1000)
        // observer 2
        subject.subscribe { Log.d(TAG, "observer2 receive: $it") }
        subject.onNext("E")
        sleep(1000)
        subject.onNext("F")
        sleep(1000)
        subject.onNext("G")
        /*******************************************************************/
    }
}
