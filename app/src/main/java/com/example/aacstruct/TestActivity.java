package com.example.aacstruct;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author hongjiang
 * @date 2019-08-01
 **/
public class TestActivity extends BaseActivity<TestActivity.TT>{


    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void addOnListener() {

    }

    @Override
    protected void subscribeToModel() {

    }

    @Override
    protected TT initViewModel() {
        return new TT(getApplication());
    }

    static class TT extends BaseViewModel{


        public TT(@NonNull Application application) {
            super(application);
        }
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void aa(){
            System.out.println("true = " + true);
        }
    }
}
