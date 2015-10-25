package cz.united121.rxandroid.model.recyclerModel.listener;

import java.util.List;

import cz.united121.rxandroid.model.data.TestObject;

/**
 * TODO add class description
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public interface OnUpdateData {
	void onUpdatedDataFinished(List<TestObject> testObjects);
}
