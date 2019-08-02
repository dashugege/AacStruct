package com.example.aacstruct;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author 慕涵曦
 * @date 2019-08-01
 **/
public class BaseViewModel extends AndroidViewModel implements LifecycleObserver {


    private CompositeDisposable compositeDisposable;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }



    protected void addDisposable(Disposable disposable){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void removeDisposable(){
        if(compositeDisposable != null){
            compositeDisposable.dispose();
        }
    }

}
