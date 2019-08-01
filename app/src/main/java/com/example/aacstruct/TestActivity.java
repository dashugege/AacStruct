package com.example.aacstruct;

import android.app.Application;

import androidx.annotation.NonNull;

/**
 * @author hongjiang
 * @date 2019-08-01
 **/
public class TestActivity extends BaseActivity{


    @Override
    protected int setLayoutId() {
        return 0;
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

    static class TT extends BaseViewModel{


        public TT(@NonNull Application application) {
            super(application);
        }
    }
}
