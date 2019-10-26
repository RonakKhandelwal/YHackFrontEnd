package Utils;

import java.util.List;

import Networking.Callback;
import Networking.Modals.Recommendation;
import Networking.NetworkingUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NetworkTask {
    public static void getRecommendations(final Callback<List<Recommendation>> callback) {
        NetworkingUtils.getUserService()
                .getRecommendations()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Recommendation>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Recommendation> value) {
                        callback.returnResult(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
