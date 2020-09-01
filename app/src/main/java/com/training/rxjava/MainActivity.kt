package com.training.rxjava

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.create<Any> { emitter ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                }

                override fun onTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {
                    if (charSequence.length > 0)
                        emitter.onNext(charSequence)
                }

                override fun afterTextChanged(editable: Editable) {}
            })
        }.doOnNext { Log.d(TAG, "upStream : $it") }
            .debounce(2,TimeUnit.SECONDS) // add delay to the observer before catching data
            .subscribe { Log.d(TAG, "downStream : $it") }
    }
}
