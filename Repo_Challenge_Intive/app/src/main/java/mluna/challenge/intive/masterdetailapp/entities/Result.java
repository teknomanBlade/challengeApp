package mluna.challenge.intive.masterdetailapp.entities;//

import org.json.*;
import java.util.*;


public class Result{

	private String email;
	private Login login;
	private Name name;
	private Picture picture;

	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setLogin(Login login){
		this.login = login;
	}
	public Login getLogin(){
		return this.login;
	}
	public void setName(Name name){
		this.name = name;
	}
	public Name getName(){
		return this.name;
	}
	public void setPicture(Picture picture){
		this.picture = picture;
	}
	public Picture getPicture(){
		return this.picture;
	}


	public Result(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		email = jsonObject.optString("email");
		login = new Login(jsonObject.optJSONObject("login"));
		name = new Name(jsonObject.optJSONObject("name"));
		picture = new Picture(jsonObject.optJSONObject("picture"));
	}


	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("email", email);
			jsonObject.put("login", login.toJsonObject());
			jsonObject.put("name", name.toJsonObject());
			jsonObject.put("picture", picture.toJsonObject());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}