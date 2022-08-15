package fiap;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;


public class Teste {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		Cliente cl = new Cliente();
		ClienteDAO cd = new ClienteDAO(con);
		
		//Metodo inserir
		cl.setIdCliente(1);
		cl.setNomeCliente("Zé");
		cl.setPlaca("JKK1900");
		System.out.println(cd.inserir(cl));
		
		Conexao.fecharConexao(con);
	}

}
