package agent_trade.persistentTemp;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import agent_trade.model.M_Carni;
import agent_trade.model.M_Dolci;
import agent_trade.model.M_Latticini;
import agent_trade.model.M_Vini;

	class ScritturaSuFileProdotti
	{
		

		
	public static void main(String[] args)
	{
		M_Dolci p =new M_Dolci(1, (float) 1.10 , "Caramelle", "Dolci", "conad", "abc", 2, false, false);
		M_Dolci p1 =new M_Dolci(2, (float) 1.7, "Biscotti", "Dolci", "conad", "abc", 2, false, false);
		M_Dolci p2 =new M_Dolci(3, (float) 3.5, "Pandoro", "Dolci", "conad", "abc", 2, true, false);
		M_Dolci p3 =new M_Dolci(4, 5, "Panettone", "Dolci", "conad", "abc", 2, true, false);

		M_Carni p4 =new M_Carni(5, 18, "Vitello", "Carne", "conad", "abc", 2, "Italia", "girello","1");
		M_Carni p5 =new M_Carni(6, 9, "Maiale", "Carne", "conad", "abc", 2, "Italia", "arista","2");
		M_Carni p6 =new M_Carni(7, 8, "Pollo", "Carne", "conad", "abc", 2, "Italia", "petto","1");
		M_Carni p7 =new M_Carni(8, 4, "Pollo", "Carne", "conad", "abc", 2, "Italia", "coscie","3");

		M_Vini p8 =new M_Vini(9, 12, "Montepulciano", "Vino", "conad", "abc", 2, "rosso","Abruzzo", "cantina");
		M_Vini p9 =new M_Vini(10, 12, "Trebbiano", "Vino", "conad", "abc", 2, "Bianco","Abruzzo", "cantina");
		M_Vini p10 =new M_Vini(11, 13, "Primitivo", "Vino", "conad", "abc", 2, "Bianco","Puglia", "cantina");
		M_Vini p11 =new M_Vini(12, 15, "Falanghina", "Vino", "conad", "abc", 2, "Bianco","Sicilia", "cantina");

		M_Latticini p12 =new M_Latticini(13, 9, "Grana", "Latticini", "conad", "abc", 2, 16, "");
		M_Latticini p13 =new M_Latticini(14, (float) 6.7, "Emmental", "Latticini", "conad", "abc", 2, 6, "");
		M_Latticini p14 =new M_Latticini(15, (float) 1.7, "Mozzarella", "Latticini", "conad", "abc", 2, 0, "");


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
	list.add(p14);




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
