package com.example.aacstruct;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 慕涵曦
 * @param <VM>
 */
public abstract class BaseActivity<VM extends BaseViewModel> extends AppCompatActivity {

    protected VM baseViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSaveInstanceState(savedInstanceState);
        setContentView(setLayoutId());
        baseViewModel = initViewModel() ;
        initView();
        addOnListener();
        getLifecycle().addObserver(baseViewModel);
    }

    /**
     * get savedInstanceState
     * @param savedInstanceState
     */
    protected void getSaveInstanceState(Bundle savedInstanceState){

    }

    /**
     * R.layout.xxx
     * @return layout id
     */
    protected abstract int setLayoutId();

    /**
     * init View finalViewById
     */
    protected abstract void initView();

    /**
     * View.setListener(new View.OnClickListerer(){})
     */
    protected abstract void addOnListener();

    /**
     * create ViewModel
     * @return
     */
    protected abstract VM initViewModel();

    /**
     * Listerner ViewModel
     */
    protected abstract void subscribeToModel();

}
