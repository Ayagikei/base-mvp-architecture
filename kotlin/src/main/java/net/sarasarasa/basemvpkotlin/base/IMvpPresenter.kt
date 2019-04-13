package net.sarasarasa.basemvpkotlin.base

/**
 * 封装Presenter层共有的一些显示方法
 */
interface IMvpPresenter<in V : IMvpView> {

    fun attachView(view: V)

    fun detachView(retainInstance: Boolean)
}
