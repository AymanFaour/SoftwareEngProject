package application;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import model.User;
import ocsf.client.AbstractClient;

public class Client extends AbstractClient {
	
//	private CpsController _cpsController = new CpsController();

	public Client(String host, int port) {
		super(host, port);
		try {
			this.openConnection();
		} catch (IOException | NullPointerException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		System.out.println("in the handel message from server function");
			JSONObject obj = null;
			//System.out.println(msg);
			try {
				obj = new JSONObject((String)msg);
			} catch (JSONException | NullPointerException e1) {
				System.out.println(msg);
				return;
			}
			try {
				
				if(obj.getString("cmd").equals("login")){
					
					
					if(!obj.getBoolean("result")){
//						_cpsController.SignInFailed();
						System.out.println("Ouch!");
						// TODO: handle re login in the GUI
						return;
					}else{
						System.out.println("reached, the object is: ");
						System.out.println(obj.getJSONObject("userInfo").toString());
//						_cpsController.SignInCallBack();
						// TODO: handle after login in the GUI
						
					}
					//System.out.println(obj.getJSONObject("userInfo").toString()+"11");
				}
				else{
					System.out.println("ksakaoskasok");
				}
			} catch (JsonSyntaxException | JSONException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}


	
	public void request(String string, Object msg) {
		
		if(string.equals("login")){
			try {
				
				JSONObject obj = new JSONObject().put("cmd", string).put("user", (String)msg);

				this.sendToServer(obj.toString());
			} catch (IOException | JSONException | NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				e.printStackTrace();
			}
		}else if(string.equals("signup")){
			try {
				
				JSONObject obj = new JSONObject().put("cmd", string).put("user", (String)msg);

				this.sendToServer(obj.toString());
			} catch (IOException | JSONException | NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				e.printStackTrace();
			}
		}
		
	}


}
