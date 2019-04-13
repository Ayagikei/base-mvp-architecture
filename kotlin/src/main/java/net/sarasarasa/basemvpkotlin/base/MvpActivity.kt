package net.sarasarasa.basemvpkotlin.base

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

@Suppress("UNCHECKED_CAST")
abstract class MvpActivity<in V : IMvpView, P : IMvpPresenter<V>> : AppCompatActivity(), IMvpView {

    protected var mPresenter: P? = null
    protected var isRetainInstance = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        if (mPresenter == null) {
            throw NullPointerException("Presenter is null")
        }
        mPresenter?.attachView(this as V)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView(isRetainInstance)
    }

    /**
     * Instantiate a mPresenter instance
     *
     * @return The [MvpPresenter] for this view
     */
    protected abstract fun createPresenter(): P

    protected abstract fun initView()

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}