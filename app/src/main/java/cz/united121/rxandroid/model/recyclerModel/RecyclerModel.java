package cz.united121.rxandroid.model.recyclerModel;

import android.util.Log;

import java.util.List;

import cz.united121.rxandroid.model.data.TestObject;
import cz.united121.rxandroid.model.network.NetworkService;
import cz.united121.rxandroid.model.recyclerModel.listener.OnUpdateData;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Implementation of presenter's interface in MVP
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public class RecyclerModel implements IRecyclerModel {
	public static final String TAG = RecyclerModel.class.getName();

	@Override
	public void updateDataToDatabase(OnUpdateData onUpdateData) {
		Log.d(TAG, "updateDataToDatabase");

		Retrofit retrofit = new Retrofit.Builder()
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(NetworkService.TEST_ENDPOINT)
				.build();
		NetworkService service = retrofit.create(NetworkService.class);

		//NetworkService networkService = NetworkService.createNetworkService(NetworkService.class, NetworkService.TEST_ENDPOINT);
		service.getAllPosts()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<List<TestObject>>() {
					@Override
					public void onCompleted() {
						Log.d(TAG, "onCompleted");

					}

					@Override
					public void onError(Throwable e) {
						Log.d(TAG, "onError");
						e.printStackTrace();
					}

					@Override
					public void onNext(List<TestObject> testObjects) {
						Log.d(TAG, "onNext");
						onUpdateData.onUpdatedDataFinished(testObjects);
					}
				});
	}
}
