package cz.united121.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
	public static String TAG = MainActivity.class.getName();


	@Bind(R.id.main_edit)
	EditText mEditText;
	@Bind(R.id.main_text)
	TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);


		RxTextView.textChanges(mEditText)
				.filter(text -> text.length() >= 3)
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
						mTextView.setText(s);
					}
				});
	}
}
