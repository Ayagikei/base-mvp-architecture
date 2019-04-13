package net.sarasarasa.basemvp.mvp.contract;

import net.sarasarasa.basemvp.base.IMvpPresenter;
import net.sarasarasa.basemvp.base.IMvpView;

public class MainContract {

    public interface View extends IMvpView {

    }

    public interface Presenter extends IMvpPresenter<View> {

    }

}
