package cz.united121.rxandroid.presenter.recyclerPresenter;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import cz.united121.rxandroid.model.recyclerModel.IRecyclerModel;
import cz.united121.rxandroid.model.recyclerModel.RecyclerModel;
import cz.united121.rxandroid.view.recyclerView.IRecyclerView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Implementation of presenter's interface in MVP
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public class RecyclerPresenter implements IRecyclerPresenter {
	public static final String TAG = RecyclerPresenter.class.getName();

	private IRecyclerView mView;
	private IRecyclerModel mModel;

	public RecyclerPresenter(IRecyclerView iRecyclerView) {
		mView = iRecyclerView;
		mModel = new RecyclerModel();
	}

	@Override
	public void textChangedOnEditView(Observable<? extends String> observable) {
		Log.d(TAG, "textChangedOnEditView");
		observable.filter(text -> text.length() >= 3)
				.debounce(1, TimeUnit.SECONDS)
				.map(text -> "RxJava " + text)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<String>() {
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
					public void onNext(String s) {
						Log.d(TAG, "onNext");
						mView.setTextToTextView(s);
					}
				});
	}
}
