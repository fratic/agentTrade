package agent_trade.persistentTemp;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
	class ScritturaSuFileClienti
	{
		

		
	public static void main(String[] args)
	{
		M_Cliente cl =new M_Cliente(1, "graziani", "ciccio", "frtnhjyu78", "via roma 156", "asd@asd.it");
		M_Cliente cl1 =new M_Cliente(2, "del piero", "alex", "xg4y6tgh", "via milano 14", "asd@asd.it");
		M_Cliente cl2 =new M_Cliente(3, "inzaghi", "pippo", "gn56ty", "via torino 6", "asd@asd.it");
		M_Cliente cl3 =new M_Cliente(3, "fratic", "antoni", "rtur6567th", "via parigi 16", "asd@asd.it");
		M_Cliente cl4 =new M_Cliente(3, "sansone", "giovanni", "4567hrfthr", "via verona 26", "asd@asd.it");
		M_Cliente cl5 =new M_Cliente(3, "bonucci", "leonardo", "rthth6546", "via carpi 136", "asd@asd.it");
		M_Cliente cl6 =new M_Cliente(3, "chiellini", "giorgio", "456hhgfhd", "via nonso 12", "asd@asd.it");
		M_Cliente cl7 =new M_Cliente(3, "barzagli", "andrea", "drty5yu56", "via bari9", "asd@asd.it");


		//StringBuffer mioSB = new StringBuffer(ag.getNome());
		
		
	try 
	{
	// Prima creo il “destinatario”: uno stream di scrittura su file 
	FileOutputStream fos = new FileOutputStream("clienti");
	// Ora posso scrivere l'oggetto sotto forma di stream di byte e passarlo al file 
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	// Trasformazione dei dati in stream di byte
	
	
	ArrayList list = new ArrayList();
	list.add(cl);
	list.add(cl1);
	list.add(cl2);
	list.add(cl3);
	list.add(cl4);
	list.add(cl5);
	list.add(cl6);
	list.add(cl7);

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
