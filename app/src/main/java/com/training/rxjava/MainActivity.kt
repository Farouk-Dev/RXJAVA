package com.training.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Hot observable 1***********************************************
         * create hot observable from a cold observable
         * = ConnectebleObservable*/

        var hot = ConnectableObservable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS).publish()
        hot.connect()

        // observer 1
        hot.subscribe { Log.d(TAG, "observer1 receive: $it") }
        Thread.sleep(3000)
        // observer 2
        hot.subscribe { Log.d(TAG, "observer2 receive: $it") }
        /*******************************************************************/
    }
}
