package networking;

import networking.api.UserService;
import networking.adapter.RetrofitAdapter;

public class NetworkingUtils {
    private static UserService userService;

    public static UserService getUserService() {
        if(null == userService){
            userService = RetrofitAdapter.getInstance().create(UserService.class);
        }
        return userService;
    }
}
