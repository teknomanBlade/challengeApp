package mluna.challenge.intive.masterdetailapp.entities;//

import org.json.*;
import java.util.*;


public class Picture{

	private String large;
	private String medium;
	private String thumbnail;

	public void setLarge(String large){
		this.large = large;
	}
	public String getLarge(){
		return this.large;
	}
	public void setMedium(String medium){
		this.medium = medium;
	}
	public String getMedium(){
		return this.medium;
	}
	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}
	public String getThumbnail(){
		return this.thumbnail;
	}



	public Picture(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		large = jsonObject.optString("large");
		medium = jsonObject.optString("medium");
		thumbnail = jsonObject.optString("thumbnail");
	}


	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("large", large);
			jsonObject.put("medium", medium);
			jsonObject.put("thumbnail", thumbnail);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}