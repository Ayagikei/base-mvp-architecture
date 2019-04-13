package net.sarasarasa.basemvpkotlin.mvp.contract

import net.sarasarasa.basemvpkotlin.base.IMvpPresenter
import net.sarasarasa.basemvpkotlin.base.IMvpView


class MainContract {

    interface View : IMvpView

    interface Presenter : IMvpPresenter<View>

}
