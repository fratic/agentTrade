package model.session;
import java.util.ArrayList;

import model.entity.DocenteSet;
public class Docente {
//Sezione attributi
private int chiave;
private String cognome;
private String nome;
private DocenteSet oggettoSet;
//Sezione metodi lettura / scrittura
public String getCognome() {
return cognome;
}
public void setCognome(String cognome) {
this.cognome = cognome;
}
public String getNome() {
return nome;
}
public void setNome(String nome) {
this.nome = nome;
}
public int getChiave() {
return chiave;
}
//Sezione costruttori
public Docente()
{
this.inizializza();
}
private void inizializza() {
// TODO Auto-generated method stub
this.chiave =0;
this.setCognome("");
this.setNome("");
this.oggettoSet = new DocenteSet();
}
public Docente(int chiave)
{
this.inizializza(chiave);
}
private void inizializza(int chiave) {
// TODO Auto-generated method stub
this.oggettoSet = new DocenteSet(chiave);
this.chiave = chiave;
this.setCognome(oggettoSet.Cognome);
this.setNome(oggettoSet.Nome);
}
//Sezione metodi di oggetto
//Sezione di Classe
public static ArrayList<String[]> elenco ()

{
return DocenteSet.lista();
}
public static ArrayList<Docente> elencoObj ()
{
ArrayList<Docente> elenco = new ArrayList<Docente>();
ArrayList<Integer> chiavi = DocenteSet.listaChiavi();
for (int i = 0; i < chiavi.size(); i++)
{
elenco.add(new Docente(chiavi.get(i)));
}
return elenco;
}
}