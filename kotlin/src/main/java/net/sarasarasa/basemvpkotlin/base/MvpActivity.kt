package net.sarasarasa.basemvpkotlin.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes

import androidx.appcompat.app.AppCompatActivity

@Suppress("UNCHECKED_CAST")
abstract class MvpActivity<in V : IMvpView, P : IMvpPresenter<V>> : AppCompatActivity(), IMvpView {

    protected var mPresenter: P? = null
    protected var isRetainInstance = false
    @LayoutRes
    protected var layoutResID: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutResID?.let { setContentView(it) }

        mPresenter = createPresenter()
        if (mPresenter == null) {
            throw NullPointerException("Presenter is null")
        }
        mPresenter?.attachView(this as V)
        initView()
        bindView()
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
    protected abstract fun bindView()

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}