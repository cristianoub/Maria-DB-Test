import java.math.BigInteger;
import java.util.Scanner;

import Bean.Client;
import DB.DBConnector;


public class Executora
{

	public static void main(String[] args) 
	{
		
			//Captura os dados	
		
		Scanner input = new Scanner(System.in);
		// TODO Auto-generated method stub
		Client x = new Client();
		System.out.println("Digite o Nome");
		x.setNome(input.nextLine());
		
		System.out.println("Digite o CNPJ");
		x.setCnpj( Integer.parseInt(input.nextLine()));
		
		System.out.println("Digite o Endereço");
		x.setEndereco(input.nextLine());
		
		System.out.println("Digite o Telefone");
		x.setTelefone( Integer.parseInt(input.nextLine()));
		
		System.out.println("Digite o Email");
		x.setEmail(input.nextLine());
		 
		//Salvar no banco de dados
		DBConnector.insert(x, DBConnector.getDBConnector());
		
		//Mostrar 
		/**
		System.out.println("Este é o nome "+ x.getNome());
		System.out.println("Este é o CNPJ "+ x.getCnpj());
		System.out.println("Este é o Endereço "+ x.getEndereco());
		System.out.println("Este é o Telefone "+ x.getTelefone());
		System.out.println("Este é o Email "+ x.getEmail());
		 
		**/
		 
		
		DBConnector.select(DBConnector.getDBConnector());
		//System.out.println(DBConnector.statusConection());
			
	}

}
