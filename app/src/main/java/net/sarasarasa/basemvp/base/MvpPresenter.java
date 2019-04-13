package net.sarasarasa.basemvp.base;

/**
 * Presenter 需要实现AttachView和DetachView两个方法防止内存泄漏和空指针异常
 *
 * @param <V>
 */
public abstract class MvpPresenter<V extends IMvpView> implements IMvpPresenter<V> {

    protected V mRootView;

    /**
     * Set or attach the view to this mPresenter
     */
    public void attachView(V view) {
        mRootView = view;
    }

    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * <code>Activity.detachView()</code> or <code>Fragment.onDestroyView()</code>
     */
    public void detachView(boolean retainInstance) {
        mRootView = null;
    }
}
