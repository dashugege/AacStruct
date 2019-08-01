package com.example.aacstruct;

import android.app.Application;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;


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
        initView();
        addOnListener();
        createViewModel();
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
     * view.setListener(new View.OnClickListerer(){})
     */
    protected abstract void addOnListener();

    /**
     * Listerner ViewModel
     */
    protected abstract void subscribeToModel();


    private void createViewModel(){
        if (getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            try {
                Class<VM> clz = ((Class<VM>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
                baseViewModel = clz.getConstructor(Application.class).newInstance(getApplication());
                getLifecycle().addObserver(new BaseViewModel(getApplication()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            throw new UnsupportedOperationException("please add generic parameter");
        }

    }

}
