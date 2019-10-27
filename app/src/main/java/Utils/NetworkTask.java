package Utils;

import java.util.List;

import Networking.Callback;
import Networking.Modals.QuestionDetailsModal;
import Networking.Modals.Recommendation;
import Networking.Modals.UserStats;
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


    public static void testApi() {
        NetworkingUtils.getUserService()
                .testApi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        System.out.println(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getCause());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public static void getQuestions(final Callback<List<QuestionDetailsModal>> callback){
        NetworkingUtils.getUserService()
                .getQuestions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<QuestionDetailsModal>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<QuestionDetailsModal> value) {
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


    public static void getUserStats(final Callback<UserStats> callback) {
        NetworkingUtils.getUserService()
                .getUserStats()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserStats>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserStats value) {
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
