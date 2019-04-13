package net.sarasarasa.basemvp.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("unchecked")
public abstract class MvpActivity<P extends IMvpPresenter> extends AppCompatActivity implements IMvpView {

    protected P mPresenter;
    protected boolean isRetainInstance = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("Presenter is null");
        }
        mPresenter.attachView(this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView(isRetainInstance);
    }

    /**
     * Instantiate a mPresenter instance
     *
     * @return The {@link MvpPresenter} for this view
     */
    protected abstract P createPresenter();

    protected abstract void initView();

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}