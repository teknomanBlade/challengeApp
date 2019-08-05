package mluna.challenge.intive.masterdetailapp.entities;

import org.json.*;
import java.util.*;


public class ProfileUser{

	private Info info;
	private ArrayList<Result> results;

	public void setInfo(Info info){
		this.info = info;
	}
	public Info getInfo(){
		return this.info;
	}
	public void setResults(ArrayList<Result> results){
		this.results = results;
	}
	public ArrayList<Result> getResults(){
		return this.results;
	}



	public ProfileUser(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		info = new Info(jsonObject.optJSONObject("info"));
		JSONArray resultsJsonArray = jsonObject.optJSONArray("results");
		if(resultsJsonArray != null){
			ArrayList<Result> resultsArrayList = new ArrayList<>();
			for (int i = 0; i < resultsJsonArray.length(); i++) {
				JSONObject resultsObject = resultsJsonArray.optJSONObject(i);
				resultsArrayList.add(new Result(resultsObject));
			}
			results = resultsArrayList;
		}
	}


	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("info", info.toJsonObject());
			if(results != null && results.size() > 0){
				JSONArray resultsJsonArray = new JSONArray();
				for(Result resultsElement : results){
					resultsJsonArray.put(resultsElement.toJsonObject());
				}
				jsonObject.put("results", resultsJsonArray);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	@Override
	public String toString() {
		return "ProfileUser{" +
				"info=" + info +
				", results=" + results +
				'}';
	}
}