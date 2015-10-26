package cz.united121.rxandroid.model.network;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Network Manager - creating service
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/26/2015}
 **/
public class NetworkManager {
	public static final String TAG = NetworkManager.class.getName();

	public static <T> T createNetworkService(final Class<T> tClass, final String endPoint) {
		Retrofit retrofit = new Retrofit.Builder()
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(endPoint)
				.build();
		T service = retrofit.create(tClass);
		return service;
	}
}
