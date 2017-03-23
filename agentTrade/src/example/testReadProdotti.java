
package example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

import agent_trade.external_system.beverage.ProdottiBeverageJSON;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Vini;

public class testReadProdotti{


//HTTP POST request
	private static void sendPost() throws Exception {

		String url = "http://fratic.altervista.org/prodPost.php";
		URL obj = new URL(url);
	    URLConnection con = obj.openConnection();
		((HttpURLConnection) con).setRequestMethod("POST");
		
	    Gson gson = new Gson();

	    String json = "{\"update\":\"true\"}";
		String urlParameters = "json="+json;


		// invio richiesta post
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		
		//analisi risposta
		int responseCode = ((HttpURLConnection) con).getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		
		while ((inputLine = in.readLine()) != null) {
						
			response.append(inputLine);			
			ProdottiBeverageJSON js = gson.fromJson(inputLine, ProdottiBeverageJSON.class);

//			M_Vini[] prodotti=js.getProdotti();
//
//			int i=0;
//			for (M_Prodotto p : prodotti) {
//				i++;
//				System.out.println("prodottto "+i);
//				System.out.println("idprodotto: "+p.getIdProdotto()+" nome: "+p.getNome());
//			}
			
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}


public static void main(String[] args) throws Exception {

	sendPost();
	
}
}