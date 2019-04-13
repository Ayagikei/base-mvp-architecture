package net.sarasarasa.basemvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

@SuppressWarnings("unchecked")
public abstract class MvpFragment<P extends MvpPresenter> extends Fragment implements IMvpView {

    protected P mPresenter;
    protected boolean isRetainInstance = false;
    private View rootView;

    @LayoutRes
    abstract int getLayoutResId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("Presenter is null");
        }

        initView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle state) {
        rootView = inflater.inflate(getLayoutResId(), container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        initView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.detachView(isRetainInstance);
        }

    }

    /**
     * Instantiate a mPresenter instance
     *
     * @return The {@link MvpPresenter} for this view
     */
    protected abstract P createPresenter();

    protected abstract void initView();
}