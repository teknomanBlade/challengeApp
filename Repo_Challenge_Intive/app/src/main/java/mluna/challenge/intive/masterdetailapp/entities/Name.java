package mluna.challenge.intive.masterdetailapp.entities;//

import org.json.*;
import java.util.*;


public class Name{

	private String first;
	private String last;
	private String title;

	public void setFirst(String first){
		this.first = first;
	}
	public String getFirst(){
		return this.first;
	}
	public void setLast(String last){
		this.last = last;
	}
	public String getLast(){
		return this.last;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}



	public Name(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		first = jsonObject.optString("first");
		last = jsonObject.optString("last");
		title = jsonObject.optString("title");
	}


	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("first", first);
			jsonObject.put("last", last);
			jsonObject.put("title", title);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}