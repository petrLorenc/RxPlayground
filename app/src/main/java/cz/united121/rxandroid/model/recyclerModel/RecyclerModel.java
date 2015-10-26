package cz.united121.rxandroid.model.recyclerModel;

import android.util.Log;

import java.util.List;

import cz.united121.rxandroid.model.data.TestObject;
import cz.united121.rxandroid.model.network.NetworkManager;
import cz.united121.rxandroid.model.network.NetworkService;
import cz.united121.rxandroid.model.recyclerModel.listener.OnUpdateData;
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

		NetworkService networkService = NetworkManager.createNetworkService(NetworkService.class, NetworkService.TEST_ENDPOINT);
		networkService.getAllPosts()
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
