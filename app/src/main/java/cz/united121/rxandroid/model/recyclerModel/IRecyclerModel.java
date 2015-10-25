package cz.united121.rxandroid.model.recyclerModel;

import cz.united121.rxandroid.model.recyclerModel.listener.OnUpdateData;

/**
 * Interface for model in MVP
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public interface IRecyclerModel {
	void updateDataToDatabase(OnUpdateData onUpdateData);
}
