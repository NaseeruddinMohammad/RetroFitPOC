package RetrofitPOC.Retrofit;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App {
	public static void main(String[] args) {
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient.build())
				.build();

		// System.out.println(retrofit.toString());

		UserService service = retrofit.create(UserService.class);

		Call<List<User>> callSync = service.getUsers();

		System.out.println(callSync.isExecuted());

		// User user1 = new User();
		try {
			Response<List<User>> response = callSync.execute();
			// Response<List<User>> response1 = callSync1.execute();

			// List<User> user = response.body();
			// System.out.println(response1.body().toString());

			System.out.println(response.body().toString());
			List<User> result = response.body();

			System.out.println("id :: " + result.get(0).getId());
			// System.out.println(response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
