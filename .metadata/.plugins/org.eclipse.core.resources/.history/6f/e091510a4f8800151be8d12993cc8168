package agent_trade.persistentTemp;

import java.awt.List;
import java.io.*;
import java.util.Iterator;
import java.util.ArrayList;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Panettone;
import agent_trade.model.M_Prodotto;
public class LetturaDaFileProdotti
{

public static void main(String[] args)
{
StringBuffer mioSB = null; // Il “destinatario” dell'informazione letta 
ArrayList elencoProdotti = null;
Iterator iteraProdotti = null;

try
{
FileInputStream fis = new FileInputStream("prodotti");
ObjectInputStream ois = new ObjectInputStream(fis);

elencoProdotti = (ArrayList) ois.readObject();


/*Agente a = new Agente();
a= (Agente)ois.readObject();
*/

ois.close();
fis.close();

//Agente a = new Agente(mioSB[0], mioSB[1]);

//System.out.println(a.getNome());


iteraProdotti = elencoProdotti.iterator();
M_Panettone p = new M_Panettone();
int i=0;
while (iteraProdotti.hasNext()) {
	
	p = (M_Panettone) iteraProdotti.next();
	System.out.println(p.getCategoria());	
	System.out.println(i);	
i++;
}
}
catch(Exception e)
{
System.out.println("Eccezione:"  + e.toString());
}
}
}