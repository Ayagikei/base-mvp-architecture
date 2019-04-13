package net.sarasarasa.basemvpkotlin.base

/**
 * 封装View层共有的一些显示方法
 * 包括Activity和Fragment
 */
interface IMvpView {
    fun showMessage(message: String)
}
