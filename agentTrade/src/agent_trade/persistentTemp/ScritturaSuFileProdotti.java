package agent_trade.persistentTemp;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;

import agent_trade.model.M_Panettone;
import agent_trade.model.M_Prodotto;

	class ScritturaSuFileProdotti
	{
		

		
	public static void main(String[] args)
	{
		M_Panettone p =new M_Panettone(1, 1, "caramella", "Dolci", true);
		M_Panettone p1 =new M_Panettone(2, 2, "biscotti", "dolci", true);
		M_Panettone p2 =new M_Panettone(3, 2, "vitello", "carne", true);
		M_Panettone p3 =new M_Panettone(4, 2, "rigatoni", "pasta", true);
		M_Panettone p4 =new M_Panettone(5, 2, "mela", "frutta", true);
		M_Panettone p5 =new M_Panettone(6, 2, "dash", "detersivo", true);
		M_Panettone p6 =new M_Panettone(7, 2, "olio", "alimenti", true);
		M_Panettone p7 =new M_Panettone(8, 2, "passata", "conserve", true);
		M_Panettone p8 =new M_Panettone(9, 2, "maionese", "salse", true);
		M_Panettone p9 =new M_Panettone(10, 2, "lavazza", "caffe", true);
		M_Panettone p10 =new M_Panettone(11, 2, "montepulciano", "vino", true);
		M_Panettone p11 =new M_Panettone(12, 2, "grana", "latticini", true);


		//StringBuffer mioSB = new StringBuffer(ag.getNome());
		
		
	try 
	{
	// Prima creo il “destinatario”: uno stream di scrittura su file 
	FileOutputStream fos = new FileOutputStream("prodotti");
	// Ora posso scrivere l'oggetto sotto forma di stream di byte e passarlo al file 
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	// Trasformazione dei dati in stream di byte
	
	
	ArrayList list = new ArrayList();
	list.add(p);
	list.add(p1);
	list.add(p2);
	list.add(p3);
	list.add(p4);
	list.add(p5);
	list.add(p6);
	list.add(p7);
	list.add(p8);
	list.add(p9);
	list.add(p10);
	list.add(p11);
	



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
