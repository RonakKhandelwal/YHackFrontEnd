package Networking.API;

import java.util.List;

import Networking.Modals.Recommendation;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserService {

    @GET("/recommendation/")
    Observable<List<Recommendation>> getRecommendations();
}
