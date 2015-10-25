package cz.united121.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import cz.united121.rxandroid.view.recyclerView.RecyclerFragment;

public class MainActivity extends AppCompatActivity {
	public static String TAG = MainActivity.class.getName();

	@Bind(R.id.fragment_place)
	FrameLayout mFrameLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, RecyclerFragment.newInstance()).commit();
	}
}
