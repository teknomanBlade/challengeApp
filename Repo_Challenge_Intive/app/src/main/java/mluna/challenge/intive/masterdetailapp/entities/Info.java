package mluna.challenge.intive.masterdetailapp.entities;//

import org.json.*;
import java.util.*;


public class Info{

	private int page;
	private int results;
	private String seed;
	private String version;

	public void setPage(int page){
		this.page = page;
	}
	public int getPage(){
		return this.page;
	}
	public void setResults(int results){
		this.results = results;
	}
	public int getResults(){
		return this.results;
	}
	public void setSeed(String seed){
		this.seed = seed;
	}
	public String getSeed(){
		return this.seed;
	}
	public void setVersion(String version){
		this.version = version;
	}
	public String getVersion(){
		return this.version;
	}



	public Info(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		page = jsonObject.optInt("page");
		results = jsonObject.optInt("results");
		seed = jsonObject.optString("seed");
		version = jsonObject.optString("version");
	}


	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("page", page);
			jsonObject.put("results", results);
			jsonObject.put("seed", seed);
			jsonObject.put("version", version);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}