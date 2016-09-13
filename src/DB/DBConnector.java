package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bean.Client;


public class DBConnector
{
	public static String status = "Não conectou...";

	public DBConnector()
	{
		
	}
	public static java.sql.Connection getDBConnector() 
	{
		Connection connection = null;
		
		try
		{
			//MariaDB
			String driverName = "org.mariadb.jdbc.Driver";
		//MYSQL	String driverName = "com.mysql.jdbc.Driver";                        

			Class.forName(driverName);
			String serverName = "localhost";
			String mydatabase ="clientsys";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";        
			String password = "teste";      
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null)
			{
				status = ("STATUS--->Conectado com sucesso!");
				
			} else
			{
				status = ("STATUS--->Não foi possivel realizar conexão");
			}
			return connection;
		} catch (ClassNotFoundException e)
		{
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		}catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;

		}
		
	}
	
	public static String statusConection()
	{
		return status;
	}
	
	public static boolean FechaConexao()
	{
		try
		{
			DBConnector.getDBConnector().close();
			return true;
		}catch (SQLException e) {
			return false;
		}
		
	}
	public static java.sql.Connection ReiniciarConexao() 
	{
		FechaConexao();
		return DBConnector.getDBConnector();
	}
	
	
	public static String insert(Client c, Connection conn)
	{
		String query = "INSERT INTO clients (client_name, client_cnpj, client_address, client_phone, client_email) VALUES ('"+c.getNome()+"', "+c.getCnpj()+", '"+c.getEndereco()+"', "+c.getTelefone()+", '"+c.getEmail()+"');";
		
		try {
			System.out.println(query);
			Statement st = conn.createStatement();
			System.out.println("Passou aqui");	
			boolean rs = st.execute(query);
			System.out.println("Passou aqui 2");
		
			/**
				while (rs.next())
			{
				System.out.println(rs.getInt("client_id"));
				System.out.println(rs.getString("client_name"));
				System.out.println(rs.getInt("client_cnpj"));
				System.out.println(rs.getString("client_address"));
				System.out.println(rs.getInt("client_phone"));
				System.out.println(rs.getString("client_email"));		
			}
			**/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PUTZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
			e.printStackTrace();
			System.out.println("FIM DO PUTZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
		}
		return query;

		
	}
	
	public static void select(Connection c)
	{
		String query = "select * from clients";
		
		try {
			Statement st = c.createStatement();
					
			ResultSet rs = st.executeQuery(query);
		
				while (rs.next())
			{
				System.out.println(rs.getInt("client_id"));
				System.out.println(rs.getString("client_name"));
				System.out.println(rs.getInt("client_cnpj"));
				System.out.println(rs.getString("client_address"));
				System.out.println(rs.getInt("client_phone"));
				System.out.println(rs.getString("client_email"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
