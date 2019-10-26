package com.example.leetcoderecommendation.ui.home;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.leetcoderecommendation.Recommendations;
import com.example.leetcoderecommendation.ui.dashboard.DashboardFragment;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<Fragment> mFragment1;
    private MutableLiveData<Fragment> mFragment2;

    public HomeViewModel() {
        mFragment1 = new MutableLiveData<>();
        mFragment2 = new MutableLiveData<>();
        mFragment1.setValue(new DashboardFragment());
        mFragment2.setValue(new Recommendations());

    }

    public LiveData<Fragment> getFirstFragment() {
        return mFragment1;
    }

    public LiveData<Fragment> getSecondFragment() {
        return mFragment2;
    }
}