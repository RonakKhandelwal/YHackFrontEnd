package Networking.API;

import java.util.List;

import Networking.Modals.QuestionDetailsModal;
import Networking.Modals.Recommendation;
import Networking.Modals.TestApi;
import Networking.Modals.UserStats;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserService {

    @GET("/recommendation/")
    Observable<List<Recommendation>> getRecommendations();

    @GET("/get_user_stats")
    Observable<UserStats> getUserStats();

    @GET("/recommendationSystem")
    Observable<String> testApi();

    @GET("questions")
    Observable<List<QuestionDetailsModal>> getQuestions();
}
