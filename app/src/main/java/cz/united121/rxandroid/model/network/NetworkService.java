package cz.united121.rxandroid.model.network;

import java.util.List;

import cz.united121.rxandroid.model.data.TestObject;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Retrofit network interface
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public interface NetworkService {
	String TAG = NetworkService.class.getName();
	String TEST_ENDPOINT = "http://jsonplaceholder.typicode.com/";


	static <T> T createNetworkService(final Class<T> tClass, final String endPoint) {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(endPoint)
				.build();
		T service = retrofit.create(tClass);
		return service;
	}

	@GET("posts")
	Observable<List<TestObject>> getAllPosts();

	@GET("posts/{id}")
	Observable<TestObject> getPostByID(@Path("id") int id);
}
