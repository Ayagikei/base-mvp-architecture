package net.sarasarasa.basemvp.mvp.ui;

import android.os.Bundle;

import net.sarasarasa.basemvp.R;
import net.sarasarasa.basemvp.base.MvpActivity;
import net.sarasarasa.basemvp.mvp.contract.MainContract;
import net.sarasarasa.basemvp.mvp.presenter.MainPresenter;

public class MainActivity extends MvpActivity<MainContract.Presenter> implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutResID = R.layout.activity_main;
        super.onCreate(savedInstanceState);
    }

    @Override
    protected MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void bindView() {

    }

    @Override
    protected void initView() {

    }

}
