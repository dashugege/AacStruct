package com.example.aacstruct;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author 慕涵曦
 * @date 2019-08-01
 **/
public class BaseViewModel extends AndroidViewModel {


    private CompositeDisposable compositeDisposable;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    private ViewModelProvider.Factory factory ;

    public ViewModelProvider.Factory getFactory(){
        if (null == factory) {
            this.factory = new ViewModelProvider.AndroidViewModelFactory(getApplication());
        }
        return factory;
    }

    protected void addDisposable(Disposable disposable){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void removeDisposable(){
        if(compositeDisposable != null){
            compositeDisposable.dispose();
        }
    }

}
