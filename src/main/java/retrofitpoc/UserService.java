package RetrofitPOC.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
	 
    @GET("users")
    public Call<List<User>> getUsers();
    
    /*@GET("/users/{username}")
    public Call<User> getUser(@Path("username") String username);*/
 
}
