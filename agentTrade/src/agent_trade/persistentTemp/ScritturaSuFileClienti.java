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
		M_Cliente cl =new M_Cliente(1, "graziani", "ciccio", "frtnhjyu78","dhsadhdhd","roma","57885", "via roma 156", "asd@asd.it", "123456", "123456", "7891011");
		M_Cliente cl1 =new M_Cliente(2, "del piero", "alex", "xg4y6tgh", "hghgkhjgkh","roma","57885", "via milano 14", "asd@asd.it", "654321", "123456", "1110987");
		M_Cliente cl2 =new M_Cliente(3, "inzaghi", "pippo", "gn56ty", "mbmbnbm", "roma","57885","via torino 6", "asd@asd.it", "545455646", "123456", "21321321");
		M_Cliente cl3 =new M_Cliente(3, "fratic", "antoni", "rtur6567th", "jughgj","roma","57885", "via parigi 16", "asd@asd.it", "544213", "123456", "1876452");
		M_Cliente cl4 =new M_Cliente(3, "sansone", "giovanni", "4567hrfthr", "oioioio","roma","57885", "via verona 26", "asd@asd.it", "1211313", "123456", "554545");
		M_Cliente cl5 =new M_Cliente(3, "bonucci", "leonardo", "rthth6546", "asasasas","roma","57885", "via carpi 136", "asd@asd.it", "211321", "123456", "");
		M_Cliente cl6 =new M_Cliente(3, "chiellini", "giorgio", "456hhgfhd", "lplplplpl","roma","57885", "via nonso 12", "asd@asd.it", "000000", "123456", "22222");
		M_Cliente cl7 =new M_Cliente(3, "barzagli", "andrea", "drty5yu56", "klakssjaks","roma","57885", "via bari9", "asd@asd.it", "888888", "123456", "99999");


		//StringBuffer mioSB = new StringBuffer(ag.getNome());
		
		
	try 
	{
	// Prima creo il “destinatario”: uno stream di scrittura su file 
	FileOutputStream fos = new FileOutputStream("file_db/clienti");
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
//	System.out.println("OK");
	}
	catch(Exception e)
	{
	System.out.println("Eccezione: " + e.toString());
	}
	}
	
	
	}
