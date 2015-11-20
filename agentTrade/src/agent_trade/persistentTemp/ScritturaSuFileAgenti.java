package agent_trade.persistentTemp;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;

import agent_trade.model.M_Agente;
	class ScritturaSuFileAgenti
	{
		

		
	public static void main(String[] args)
	{
		M_Agente ag =new M_Agente("1","fraticelli","antonio","asd");
		M_Agente ag1 =new M_Agente("2","rossi","mario", "asd");
		M_Agente ag2 =new M_Agente("3","bianchi","roberto", "asd");
		M_Agente ag3 =new M_Agente("4","","nessuno", "");


		//StringBuffer mioSB = new StringBuffer(ag.getNome());
		
		
	try 
	{
	// Prima creo il “destinatario”: uno stream di scrittura su file 
	FileOutputStream fos = new FileOutputStream("file_db/agenti");
	// Ora posso scrivere l'oggetto sotto forma di stream di byte e passarlo al file 
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	// Trasformazione dei dati in stream di byte
	
	
	ArrayList list = new ArrayList();
	list.add(ag);
	list.add(ag1);
	list.add(ag2);
	list.add(ag3);

	oos.writeObject(list);

	
	/*oos.writeObject(ag);
	oos.writeObject(ag1);
	oos.writeObject(ag2);
*/
	//oos.write(mioSB);
	oos.close();
	System.out.println("OK");
	}
	catch(Exception e)
	{
	System.out.println("Eccezione: " + e.toString());
	}
	}
	
	
	}
