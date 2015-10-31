package agent_trade.persistentTemp;

import java.io.*;
import java.util.Iterator;
import java.util.ArrayList;
import agent_trade.model.M_Cliente;
public class LetturaDaFileClienti
{

public static void main(String[] args)
{
StringBuffer mioSB = null; // Il “destinatario” dell'informazione letta 
ArrayList elencoClienti = null;
Iterator iteraClienti = null;

try
{
// Recupero il file dei dati e creo un ObjectInputStream per leggerlo
FileInputStream fis = new FileInputStream("clienti");
ObjectInputStream ois = new ObjectInputStream(fis);
//mioSB = (StringBuffer) ois.readObject(); // Notate il cast !!!

elencoClienti = (ArrayList) ois.readObject();


/*Agente a = new Agente();
a= (Agente)ois.readObject();
*/

ois.close();
fis.close();

//Agente a = new Agente(mioSB[0], mioSB[1]);

//System.out.println(a.getNome());


iteraClienti = elencoClienti.iterator();
M_Cliente c = new M_Cliente();
while (iteraClienti.hasNext()) {
	//System.out.println("dio");
	c = (M_Cliente) iteraClienti.next();
	System.out.println("Cliente "+c.getCognome()+ " " +c.getNome());
}
}
catch(Exception e)
{
System.out.println("Eccezione:"  + e.toString());
}
}
}