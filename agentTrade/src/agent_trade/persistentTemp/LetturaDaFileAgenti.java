package agent_trade.persistentTemp;

import java.awt.List;
import java.io.*;
import java.util.Iterator;
import java.util.ArrayList;
import agent_trade.model.M_Agente;
public class LetturaDaFileAgenti
{

public static void main(String[] args)
{
StringBuffer mioSB = null; // Il “destinatario” dell'informazione letta 
ArrayList elencoAgenti = null;
Iterator iteraAgenti = null;

try
{
// Recupero il file dei dati e creo un ObjectInputStream per leggerlo
FileInputStream fis = new FileInputStream("file_db/agenti");
ObjectInputStream ois = new ObjectInputStream(fis);
//mioSB = (StringBuffer) ois.readObject(); // Notate il cast !!!

elencoAgenti = (ArrayList) ois.readObject();


/*Agente a = new Agente();
a= (Agente)ois.readObject();
*/

ois.close();
fis.close();

//Agente a = new Agente(mioSB[0], mioSB[1]);

//System.out.println(a.getNome());


iteraAgenti = elencoAgenti.iterator();
M_Agente a = new M_Agente();
while (iteraAgenti.hasNext()) {
	//System.out.println("dio");
	a = (M_Agente) iteraAgenti.next();
	System.out.println("Agente "+a.getCognome()+ " " +a.getNome()+" id: "+a.getIdAgente()+" password "+a.getPassword());
}
}
catch(Exception e)
{
System.out.println("Eccezione:"  + e.toString());
}
}
}