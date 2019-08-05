package mluna.challenge.intive.masterdetailapp.entities;//

import org.json.*;
import java.util.*;


public class Login{

	private String md5;
	private String password;
	private String salt;
	private String sha1;
	private String sha256;
	private String username;
	private String uuid;

	public void setMd5(String md5){
		this.md5 = md5;
	}
	public String getMd5(){
		return this.md5;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setSalt(String salt){
		this.salt = salt;
	}
	public String getSalt(){
		return this.salt;
	}
	public void setSha1(String sha1){
		this.sha1 = sha1;
	}
	public String getSha1(){
		return this.sha1;
	}
	public void setSha256(String sha256){
		this.sha256 = sha256;
	}
	public String getSha256(){
		return this.sha256;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getUuid(){
		return this.uuid;
	}



	public Login(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		md5 = jsonObject.optString("md5");
		password = jsonObject.optString("password");
		salt = jsonObject.optString("salt");
		sha1 = jsonObject.optString("sha1");
		sha256 = jsonObject.optString("sha256");
		username = jsonObject.optString("username");
		uuid = jsonObject.optString("uuid");
	}


	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("md5", md5);
			jsonObject.put("password", password);
			jsonObject.put("salt", salt);
			jsonObject.put("sha1", sha1);
			jsonObject.put("sha256", sha256);
			jsonObject.put("username", username);
			jsonObject.put("uuid", uuid);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}