package model.entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connessione {
public Connection objConn;
public void apri()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
this.objConn = DriverManager.getConnection("jdbc:odbc:DBCorso");
}
catch(ClassNotFoundException oErrore)
{
oErrore.printStackTrace();
}catch (SQLException oSql)
{
oSql.printStackTrace();
}
}
public void chiudi()
{
try
{
this.objConn.close();
}catch (SQLException oSql)
{
oSql.printStackTrace();
}
}
}
