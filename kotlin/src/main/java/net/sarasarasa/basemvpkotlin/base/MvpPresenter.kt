package net.sarasarasa.basemvpkotlin.base

/**
 * Presenter 需要实现AttachView和DetachView两个方法防止内存泄漏和空指针异常
 * @param <V>
</V> */
abstract class MvpPresenter<V : IMvpView> : IMvpPresenter<V> {

    protected var mView: V? = null

    /**
     * Set or attach the view to this mPresenter
     */
    override fun attachView(view: V) {
        mView = view
    }

    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * `Activity.detachView()` or `Fragment.onDestroyView()`
     */
    override fun detachView(retainInstance: Boolean) {
        mView = null
    }
}
