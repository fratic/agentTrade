package agent_trade.persistentTemp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Prodotto;

public class Dao_System {

	private static Dao_System instance;

	public static Dao_System getInstance(){

		return ((instance == null) ? instance = new Dao_System() : instance);	
	}
	
	/*
	__________AGENTE_________________
	*/
	public M_Agente loadAgente(String user) {
		
		StringBuffer mioSB = null; 
		ArrayList elencoAgenti = null;
		Iterator iteraAgenti = null;
		try
		{
			FileInputStream fis = new FileInputStream("file_db/agenti");
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
		 		  
	}
	
	
	
	/*
	___________CLIENTE_________________
	*/
	public M_Cliente cercaCliente(String cognome) {
		StringBuffer mioSB = null; 
		ArrayList elencoClienti = null;
		Iterator iteraClienti = null;
		try
		{
			FileInputStream fis = new FileInputStream("file_db/clienti");
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
	}
	
	public ArrayList cercaClienti(String c){
		ArrayList elencoClienti = null;
		ArrayList Clienti = null;
		Iterator iteraClienti = null;
		
		try{
			FileInputStream fis = new FileInputStream("file_db/clienti");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Clienti = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			
			iteraClienti = Clienti.iterator();
			M_Cliente cliente = new M_Cliente();
			elencoClienti = new ArrayList();
			while(iteraClienti.hasNext()){
				cliente = (M_Cliente) iteraClienti.next();
				if(cliente.getCognome().equals(c)){
					//System.out.println("cognome:"  + cliente.getCognome());
					elencoClienti.add(cliente);
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Eccezione:"  + e.toString());
		}
		
		return elencoClienti;
	}
	
	public ArrayList caricaClienti() {
		
		StringBuffer mioSB = null; 
		ArrayList elencoClienti = null;
		Iterator iteraClienti = null;
		try
		{
			FileInputStream fis = new FileInputStream("file_db/clienti");
			ObjectInputStream ois = new ObjectInputStream(fis);
			elencoClienti = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			
			iteraClienti = elencoClienti.iterator();
			M_Cliente c = new M_Cliente();
			while (iteraClienti.hasNext()) {
				c = (M_Cliente) iteraClienti.next();				
			}
			return elencoClienti;
		}
		catch(Exception e)
		{
			System.out.println("Eccezione:"  + e.toString());
		}
		return elencoClienti;		 
	}
	
	public void nuovoCliente(M_Cliente c) {
		try
		{
		
		FileInputStream fis = new FileInputStream("file_db/clienti");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ArrayList list = (ArrayList) ois.readObject();
		
		ois.close();
		fis.close();
		
		list.add(c);

		FileOutputStream fos = new FileOutputStream("file_db/clienti");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(list);
		
		oos.close();
		fos.close();
		
		}
		catch(Exception e)
		{
		System.out.println("Eccezione: " + e.toString());
		}

	}
	 
	public void modificaCliente(M_Cliente c){
		
		cancellaCliente(c);
		nuovoCliente(c);
		
	}	 
	
	public void cancellaCliente(M_Cliente c){
		
		String codFis = c.getCodice_fiscale();
		ArrayList elencoClienti = null;
		Iterator iteraClienti = null;
		try
		{
			FileInputStream fis = new FileInputStream("file_db/clienti");
			ObjectInputStream ois = new ObjectInputStream(fis);
			elencoClienti = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			
			iteraClienti = elencoClienti.iterator();
			M_Cliente cliente = new M_Cliente();
			while (iteraClienti.hasNext()) {
				cliente = (M_Cliente) iteraClienti.next();
				if (cliente.getCodice_fiscale().equals(codFis)){
					elencoClienti.remove(cliente);
					break;					
		
				}	

			}
			

			FileOutputStream fos = new FileOutputStream("file_db/clienti");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(elencoClienti);
			
			oos.close();
			fos.close();
		}
		catch(Exception e)
		{
		System.out.println("Eccezione:"  + e.toString());
		}
		
		
	}

	/*
	 ________________________PRODOTTI_______________________________
	*/
	
	public M_Prodotto loadProdotto(int idProdotto) {
		
		StringBuffer mioSB = null; 
		ArrayList elencoProdotti = null;
		Iterator iteraProdotti = null;

		try
		{
			FileInputStream fis = new FileInputStream("file_db/prodotti");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			elencoProdotti = (ArrayList) ois.readObject();

			ois.close();
			fis.close();

			iteraProdotti = elencoProdotti.iterator();
			M_Prodotto p;
			int i=0;
			while (iteraProdotti.hasNext()) {				
				p = (M_Prodotto) iteraProdotti.next();
				if (idProdotto==p.getIdProdotto()){
					return p;
				}
			}
		}
		catch(Exception e)
		{
		System.out.println("Eccezione:"  + e.toString());
		}
		return null;
		}
	
	
	
	public ArrayList caricaProdotti() {
		
		StringBuffer mioSB = null; 
		ArrayList elencoProdotti = null;
		Iterator iteraProdotti = null;

		try
		{
			FileInputStream fis = new FileInputStream("file_db/prodotti");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			elencoProdotti = (ArrayList) ois.readObject();

			ois.close();
			fis.close();

			return elencoProdotti;
		}
		catch(Exception e)
		{
		System.out.println("Eccezione:"  + e.toString());
		}
		return null;
		}

	
	/*
	 * _____________________PREVENTIVI_____________________
	 */
	
	public static void salvaPreventivo(M_Preventivo p) {
		
		try 
		{
			FileInputStream fis = new FileInputStream("file_db/preventivi");
			ObjectInputStream ois = new ObjectInputStream(fis);

			ArrayList list = (ArrayList) ois.readObject();
			
			ois.close();
			fis.close();

			list.add(p);
			
			/****alternativa quando scrivo io primo preventivo

			ArrayList list = new ArrayList();

			list.add(p);
			
			***/
			

			FileOutputStream fos = new FileOutputStream("file_db/preventivi");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(list);

			oos.close();
			System.out.println("salvataggio preventivo OK");		
		}
		
		catch(Exception e)
		{
			System.out.println("Eccezione: " + e.toString());
		}
	}
	
	
	public static ArrayList<M_Preventivo> loadPreventivi(){
		try
		{
			FileInputStream fis = new FileInputStream("file_db/preventivi");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			ArrayList< M_Preventivo> a =(ArrayList<M_Preventivo>) ois.readObject();
	
			ois.close();
			fis.close();
			
			return a;
		}
		catch(Exception e)
		{
			System.out.println("Eccezione:"  + e.toString());
		}
		return null;
		
	}

	public static M_Preventivo loadPreventivo(String id){
		try
		{
			FileInputStream fis = new FileInputStream("file_db/preventivi");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			ArrayList< M_Preventivo> a =(ArrayList<M_Preventivo>) ois.readObject();
	
			ois.close();
			fis.close();
			
			Iterator iteraPreventivi = a.iterator();

			M_Preventivo p;
			
			while (iteraPreventivi.hasNext()) {				
				p = (M_Preventivo) iteraPreventivi.next();
				if (p.getIdPreventivo().equals(id)){
					return p;
				}
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Eccezione:"  + e.toString());
		}
		return null;
		
	}
	
	/*---------------------------id nuovo prventivo------------------------------*/
	public static void salvaIdPrev(int id) {
		
		try 
		{		

			FileOutputStream fos = new FileOutputStream("file_db/id_prev");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
					
			oos.writeObject(id);

			oos.close();
			System.out.println("salvataggio id preventivo OK");		
		}
		
		catch(Exception e)
		{
			System.out.println("Eccezione: " + e.toString());
		}
	}
	
	
	public static int loadIdPrev(){
		try
		{
			FileInputStream fis = new FileInputStream("file_db/id_prev");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			int id =(int) ois.readObject();
	
			ois.close();
			fis.close();
						
			return id;
		}
		catch(Exception e)
		{
			System.out.println("Eccezione:"  + e.toString());
		}
		return 0;
		
	}
}