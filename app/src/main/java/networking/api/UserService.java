package networking.api;

import java.util.List;

import networking.Modals.QuestionDetailsModal;
import networking.Modals.Recommendation;
import networking.Modals.UserStats;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserService {

    @GET("/recommendation/")
    Observable<List<Recommendation>> getRecommendations();

    @GET("/get_user_stats")
    Observable<UserStats> getUserStats();

    @GET("/recommendationSystem")
    Observable<String> testApi();

    @GET("/question")
    Observable<List<QuestionDetailsModal>> getQuestions();
}
