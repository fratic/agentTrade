package agent_trade.persistentTemp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;

public class Dao_System {

	private static Dao_System instance;

	public static Dao_System getInstance(){

		return ((instance == null) ? instance = new Dao_System() : instance);	
	}
	
	/*
	__________AGENTE_________________
	*/
	public M_Agente loadAgente(String user) {
		/*INIZIO CARICAMENTO DA FILE, non lasciare cosi ma creare una funzione temporanea*/
		
		StringBuffer mioSB = null; 
		ArrayList elencoAgenti = null;
		Iterator iteraAgenti = null;
		try
		{
			FileInputStream fis = new FileInputStream("agenti");
			ObjectInputStream ois = new ObjectInputStream(fis);
			elencoAgenti = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			
			iteraAgenti = elencoAgenti.iterator();
			M_Agente a = new M_Agente();
			while (iteraAgenti.hasNext()) {
				a = (M_Agente) iteraAgenti.next();
				if (a.getCognome().equals(user)){
					return a;
				}
			}
		}
		catch(Exception e)
		{
		System.out.println("Eccezione:"  + e.toString());
		}
		return null;
		 		  
		/*fine caricamento da file */
	}
	
	
	
	/*
	___________CLIENTE_________________
	*/
	public M_Cliente cercaCliente(String cognome) {
		/*INIZIO CARICAMENTO DA FILE, non lasciare cosi ma creare una funzione temporanea*/
		StringBuffer mioSB = null; 
		ArrayList elencoClienti = null;
		Iterator iteraClienti = null;
		try
		{
			FileInputStream fis = new FileInputStream("clienti");
			ObjectInputStream ois = new ObjectInputStream(fis);
			elencoClienti = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			
			iteraClienti = elencoClienti.iterator();
			M_Cliente c = new M_Cliente();
			while (iteraClienti.hasNext()) {
				c = (M_Cliente) iteraClienti.next();
				if (c.getCognome().equals(cognome)){
					return c;
				}
			}
		}
		catch(Exception e)
		{
		System.out.println("Eccezione:"  + e.toString());
		}
		return null;
		 
		  
		/*fine caricamento da file */
	}
	
	public ArrayList caricaClienti() {
		/*INIZIO CARICAMENTO DA FILE, non lasciare cosi ma creare una funzione temporanea*/
		
		StringBuffer mioSB = null; 
		ArrayList elencoClienti = null;
		Iterator iteraClienti = null;
		try
		{
			FileInputStream fis = new FileInputStream("clienti");
			ObjectInputStream ois = new ObjectInputStream(fis);
			elencoClienti = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			
			iteraClienti = elencoClienti.iterator();
			M_Cliente c = new M_Cliente();
			while (iteraClienti.hasNext()) {
				c = (M_Cliente) iteraClienti.next();
				System.out.println(c.getCognome()+" "+c.getNome());
				
			}
			return elencoClienti;
		}
		catch(Exception e)
		{
		System.out.println("Eccezione:"  + e.toString());
		}
		return elencoClienti;		 
		  
		/*fine caricamento da file */
	}
	
	public void nuovoCliente(M_Cliente c) {
		try
		{
		
		FileInputStream fis = new FileInputStream("clienti");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ArrayList list = (ArrayList) ois.readObject();
		
		ois.close();
		fis.close();
		
		list.add(c);

		FileOutputStream fos = new FileOutputStream("clienti");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(list);
		
		oos.close();
		fos.close();
		
		/*	
		Iterator iteraClienti = list.iterator();
		M_Cliente cl = new M_Cliente();
		while (iteraClienti.hasNext()) {
			cl = (M_Cliente) iteraClienti.next();
			System.out.println("Cliente "+cl.getCognome()+ " " +cl.getNome());
		}
		
		System.out.println("OK");
		 */
		
		}
		catch(Exception e)
		{
		System.out.println("Eccezione: " + e.toString());
		}

	}
	
	public void modificaCliente(M_Cliente c){
		
	}
	 
	public void cancellaCliente(){
		
	}
	
	
	
}