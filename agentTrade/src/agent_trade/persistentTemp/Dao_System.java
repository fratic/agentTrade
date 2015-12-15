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
	public M_Cliente cercaCliente(String cognome, String idAgente) {
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
				if (c.getCognome().equals(cognome)&& c.getIdAgente().equals(idAgente)){
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
	
//	public M_Cliente ricercaCliente(String codFis) {
//		StringBuffer mioSB = null; 
//		ArrayList elencoClienti = null;
//		Iterator iteraClienti = null;
//		try
//		{
//			FileInputStream fis = new FileInputStream("file_db/clienti");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			elencoClienti = (ArrayList) ois.readObject();
//			ois.close();
//			fis.close();
//			
//			iteraClienti = elencoClienti.iterator();
//			M_Cliente c = new M_Cliente();
//			while (iteraClienti.hasNext()) {
//				c = (M_Cliente) iteraClienti.next();
//				if (c.getCodice_fiscale().equals(codFis)){
//					return c;
//				}
//			}
//		}
//		catch(Exception e)
//		{
//		System.out.println("Eccezione:"  + e.toString());
//		}
//		return null;
//	}
	
	public ArrayList cercaClienti(String c, String idAgente){
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
				if(cliente.getCognome().equals(c)&& cliente.getIdAgente().equals(idAgente)){
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
	
	public ArrayList caricaClienti(String idAgente) {
		
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
				if(cliente.getIdAgente().equals(idAgente)){
					elencoClienti.add(cliente);
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Eccezione:"  + e.toString());
		}
		
		return elencoClienti;
		
//		StringBuffer mioSB = null; 
//		ArrayList elencoClienti = null;
//		Iterator iteraClienti = null;
//		try
//		{
//			FileInputStream fis = new FileInputStream("file_db/clienti");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			elencoClienti = (ArrayList) ois.readObject();
//			ois.close();
//			fis.close();
//			
//			iteraClienti = elencoClienti.iterator();
//			M_Cliente c = new M_Cliente();
//			System.out.print(c);
//			while (iteraClienti.hasNext()) {
//				c = (M_Cliente) iteraClienti.next();				
//			}
//			return elencoClienti;
//		}
//		catch(Exception e)
//		{
//			System.out.println("Eccezione:"  + e.toString());
//		}
//		return elencoClienti;		 
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
	
	public void salvaPreventivo(M_Preventivo p) {
		
		cancPreventivo(p.getIdPreventivo());//messo solo per controllare che già non esiste, quando avremo il db non servirà
		
		try 
		{
			FileInputStream fis = new FileInputStream("file_db/preventivi");
			ObjectInputStream ois = new ObjectInputStream(fis);

			ArrayList list = (ArrayList) ois.readObject();
			
			ois.close();
			fis.close();

			list.add(p);
			
			/****alternativa quando scrivo il primo preventivo*

			ArrayList list = new ArrayList();

			list.add(p);
			
			*****/
			

			FileOutputStream fos = new FileOutputStream("file_db/preventivi");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(list);

			oos.close();
//			System.out.println("salvataggio preventivo OK");		
		}
		
		catch(Exception e)
		{
			System.out.println("Eccezione: " + e.toString());
		}
	}
	
	
	public  ArrayList<M_Preventivo> loadPreventivi(String idAgente){
		
		ArrayList<M_Preventivo> elencoPreventivi = null;
		
		try
		{
			FileInputStream fis = new FileInputStream("file_db/preventivi");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			ArrayList< M_Preventivo> a =(ArrayList<M_Preventivo>) ois.readObject();
	
			ois.close();
			fis.close();
			
			Iterator<M_Preventivo> iteraPrev = a.iterator();
			M_Preventivo preventivo = new M_Preventivo();
			elencoPreventivi = new ArrayList();
			
			while(iteraPrev.hasNext()){
				preventivo = (M_Preventivo) iteraPrev.next();
				M_Agente agenteRif = preventivo.getRif_Agente();
				if(agenteRif.getIdAgente().equals(idAgente)){
					elencoPreventivi.add(preventivo);
				}
			}
			
			return elencoPreventivi;
		}
		catch(Exception e)
		{
			System.out.println("Eccezione:"  + e.toString());
		}
		return null;
		
	}

	public M_Preventivo loadPreventivo(String id){
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
	
	public  M_Preventivo cancPreventivo(String id){
		try
		{

			FileInputStream fis = new FileInputStream("file_db/preventivi");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			ArrayList< M_Preventivo> preventivi =(ArrayList<M_Preventivo>) ois.readObject();
	
			ois.close();
			fis.close();
			
			Iterator iteraPreventivi = preventivi.iterator();

			M_Preventivo p;
			
			while (iteraPreventivi.hasNext()) {				
				p = (M_Preventivo) iteraPreventivi.next();
				if (p.getIdPreventivo().equals(id)){
					preventivi.remove(p);
					break;
				}
			}
			

			FileOutputStream fos = new FileOutputStream("file_db/preventivi");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(preventivi);
			
			oos.close();
			fos.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println("Eccezione:"  + e.toString());
		}
		return null;
		
	}
	
	
	/*---------------------------id nuovo prventivo------------------------------*/
	public  void salvaIdPrev(int id) {
				
		try 
		{		

			FileOutputStream fos = new FileOutputStream("file_db/id_prev");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
					
			oos.writeObject(id);

			oos.close();
		}
		
		catch(Exception e)
		{
			System.out.println("Eccezione: " + e.toString());
		}
	}
	
	
	public int loadIdPrev(){
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