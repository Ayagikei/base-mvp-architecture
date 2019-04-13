package net.sarasarasa.basemvpkotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

@Suppress("UNCHECKED_CAST")
abstract class MvpFragment<in V : IMvpView, P : IMvpPresenter<V>> : Fragment(), IMvpView {

    protected var mPresenter: P? = null
    protected val isRetainInstance = false

    private var rootView: View? = null

    @get:LayoutRes
    internal abstract val layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        if (mPresenter == null) {
            throw NullPointerException("Presenter is null")
        }

        initView()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View? {
        rootView = inflater.inflate(layoutResId, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
}