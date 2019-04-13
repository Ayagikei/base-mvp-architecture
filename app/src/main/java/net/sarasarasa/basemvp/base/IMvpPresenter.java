package net.sarasarasa.basemvp.base;

/**
 * 封装Presenter层共有的一些显示方法
 */
public interface IMvpPresenter<V extends IMvpView> {

    void attachView(V view);

    void detachView(boolean retainInstance);
}
