package Networking;

import Networking.API.UserService;
import Networking.Adapter.RetrofitAdapter;

public class NetworkingUtils {
    private static UserService userService;

    public static UserService getUserService() {
        if(null == userService){
            userService = RetrofitAdapter.getInstance().create(UserService.class);
        }
        return userService;
    }
}
