package agent_trade.external_system;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import agent_trade.model.M_Prodotto;

public abstract class SistemaEsterno {

	protected String nomeAzienda;

	

	protected String sendRequest(String url, String parameters) throws IOException {
	
		URL uri = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
		writer.writeBytes(parameters);
		writer.flush();
		writer.close();
		
		if (connection.getResponseCode() != 200) {
			throw new HttpRetryException("Connection response: " + connection.getResponseMessage(),
					connection.getResponseCode());
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String buffer;
		StringBuffer response = new StringBuffer();
		while ((buffer = reader.readLine()) != null) {
			response.append(buffer);
		}
		reader.close();
		return response.toString();
	};
	

	protected abstract String getUrlRicerca();

	protected String serializzaParametri(HashMap<String, String> parameters) {
		StringBuffer parameters_buffer = new StringBuffer();
		Set<String> parameters_name = parameters.keySet();
		for (String parameter_name : parameters_name) {
			String value = parameters.get(parameter_name);
			if (value != null) {
				try {
					parameters_buffer.append(parameter_name + "=" + URLEncoder.encode(value, "UTF-8") + "&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		// Se ci sono parametri concatenati si elimina l'ultima concatenazione
		// "&"
		if (parameters_name.size() > 0)
			parameters_buffer.deleteCharAt(parameters_buffer.length() - 1);
		return parameters_buffer.toString();
	}
	
	public String ricerca(HashMap<String, String> parametri) throws IOException {
		String url = getUrlRicerca();
		String parameters = serializzaParametri(parametri);
		String response = sendRequest(url, parameters);
		return response;
	};
	
	protected abstract ArrayList<M_Prodotto> sincronizzaListino() throws IOException;

	public String getNomeAzienda() {
		return nomeAzienda;
	}
}
