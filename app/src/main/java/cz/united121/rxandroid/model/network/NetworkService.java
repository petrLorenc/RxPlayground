package cz.united121.rxandroid.model.network;

import java.util.List;

import cz.united121.rxandroid.model.data.TestObject;
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

	@GET("posts")
	Observable<List<TestObject>> getAllPosts();

	@GET("posts/{id}")
	Observable<TestObject> getPostByID(@Path("id") int id);
}
