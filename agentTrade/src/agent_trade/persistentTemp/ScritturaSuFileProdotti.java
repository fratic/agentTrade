package agent_trade.persistentTemp;

import java.io.*;
import java.util.ArrayList;

import agent_trade.model.M_Dolci;
import agent_trade.model.M_Latticini;

	class ScritturaSuFileProdotti
	{
		

		
	public static void main(String[] args)
	{
		M_Dolci p =new M_Dolci(1, 1, "caramella", "Dolci", true);
		M_Dolci p1 =new M_Dolci(2, 2, "biscotti", "dolci", true);
		M_Dolci p2 =new M_Dolci(3, 2, "vitello", "carne", true);
		M_Dolci p3 =new M_Dolci(4, 2, "rigatoni", "pasta", true);
		M_Dolci p4 =new M_Dolci(5, 2, "mela", "frutta", true);
		M_Dolci p5 =new M_Dolci(6, 2, "dash", "detersivo", true);
		M_Dolci p6 =new M_Dolci(7, 2, "olio", "alimenti", true);
		M_Dolci p7 =new M_Dolci(8, 2, "passata", "conserve", true);
		M_Dolci p8 =new M_Dolci(9, 2, "maionese", "salse", true);
		M_Dolci p9 =new M_Dolci(10, 2, "lavazza", "caffe", true);
		M_Dolci p10 =new M_Dolci(11, 2, "montepulciano", "vino", true);
		M_Latticini p11 =new M_Latticini(12, 2, "grana", "latticini", 16);
		M_Latticini p12 =new M_Latticini(12, 2, "emmental", "latticini", 6);
		M_Latticini p13 =new M_Latticini(12, 2, "mozzarella", "latticini", 0);


		//StringBuffer mioSB = new StringBuffer(ag.getNome());
		
		
	try 
	{
	// Prima creo il “destinatario”: uno stream di scrittura su file 
	FileOutputStream fos = new FileOutputStream("file_db/prodotti");
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
	list.add(p12);
	list.add(p13);




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
