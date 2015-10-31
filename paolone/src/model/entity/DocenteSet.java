package model.entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DocenteSet {
//Sezione medtodi pubblici
public int IDDocente;
public String Cognome;
public String Nome;
//Sezione Costruttori
public DocenteSet()
{
}
public DocenteSet(int IDDocente)
{
this.estrai(IDDocente);
}
private void estrai(int iDDocente) {
// TODO Auto-generated method stub
String sql = "Select * from Docente where IDDocente = ?";
Connessione oConnessione = new Connessione();
try {
oConnessione.apri();
PreparedStatement pstDocente = oConnessione.objConn.prepareStatement(sql);
pstDocente.setInt(1, iDDocente);
ResultSet rsDocente = pstDocente.executeQuery();
rsDocente.next();
this.IDDocente = iDDocente;
this.Cognome = rsDocente.getString("Cognome");
this.Nome = rsDocente.getString("Nome");
oConnessione.chiudi();
} catch (Exception e) {
// TODO: handle exception
}finally{
if (oConnessione.objConn != null) oConnessione.chiudi();
}
}
//Sezione dei metodi operanti sulla tuple
//Sezione metodi operanti su pi� tuple
public static ArrayList<String[]> lista() {
// TODO Auto-generated method stub
String sql = "Select * from Docente";
ArrayList<String[]> elenco = new ArrayList<String[]>();
Connessione oConnessione = new Connessione();
try {
oConnessione.apri();
PreparedStatement pstElenco = oConnessione.objConn.prepareStatement(sql);
ResultSet rsElenco = pstElenco.executeQuery();
while (rsElenco.next())
{
String[] docente = new String [3];
docente[0] = rsElenco.getString("IDDocente");
docente[1] = rsElenco.getString("Cognome");
docente[1] = rsElenco.getString("Nome");
elenco.add(docente);
}
oConnessione.chiudi();
} catch (Exception e) {
// TODO: handle exception
}finally{
if (oConnessione.objConn != null) oConnessione.chiudi();
}
return elenco;
}
public static ArrayList<Integer> listaChiavi() {
// TODO Auto-generated method stub
String sql = "Select IDDocente from Docente";
ArrayList<Integer> elenco = new ArrayList<Integer>();
Connessione oConnessione = new Connessione();
try {
oConnessione.apri();
PreparedStatement pstElenco = oConnessione.objConn.prepareStatement(sql);
ResultSet rsElenco = pstElenco.executeQuery();
while (rsElenco.next())
{
elenco.add(rsElenco.getInt("IDDocente"));
}
oConnessione.chiudi();
} catch (Exception e) {
// TODO: handle exception
}finally{
if (oConnessione.objConn != null) oConnessione.chiudi();
}
return elenco;
}
}