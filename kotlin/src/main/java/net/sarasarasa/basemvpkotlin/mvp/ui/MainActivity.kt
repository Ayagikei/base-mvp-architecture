package net.sarasarasa.basemvpkotlin.mvp.ui

import android.os.Bundle
import net.sarasarasa.basemvpkotlin.R
import net.sarasarasa.basemvpkotlin.base.MvpActivity
import net.sarasarasa.basemvpkotlin.mvp.contract.MainContract
import net.sarasarasa.basemvpkotlin.mvp.presenter.MainPresenter

class MainActivity : MvpActivity<MainContract.View, MainPresenter>(), MainContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        layoutResID = R.layout.activity_main
        super.onCreate(savedInstanceState)
    }

    override fun initView() {

    }

    override fun bindView() {

    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

}
