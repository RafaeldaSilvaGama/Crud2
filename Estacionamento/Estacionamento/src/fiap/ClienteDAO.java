package fiap;

import java.sql.*;
import java.util.*;

public class ClienteDAO {

	private Connection con;

	public ClienteDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;

	}

	public String inserir(Cliente cliente) {
		String sql = "insert into cliente(idcliente,nomecliente,placa) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());

			if (ps.executeUpdate() > 0) {
				return "Inormações inseridas com sucesso.";
			} else {
				return "Erro ao inserir.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String alterar(Cliente cliente) {
		String sql = "update cliente set nomecliente = ?, placa = ?, where idcliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getPlaca());
			ps.setInt(3, cliente.getIdCliente());

			if (ps.executeUpdate() > 0) {
				return "Informações alteradas com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String excluir(Cliente cliente) {
		String sql = "delete from cliente where idcliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());

			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Ero ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public ArrayList<Cliente> listarCliente(){
			ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
			String sql = "select * from cliente";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Cliente cl = new Cliente();
						cl.setIdCliente(rs.getInt(1));
						cl.setNomeCliente(rs.getString(2));
						cl.setPlaca(rs.getString(3));
						listaCliente.add(cl);
					}
					return listaCliente;
				} else {
					return null;}
				}
				
			 catch (SQLException e) {
				return null;
			} catch (Exception e) {
				return null;
			}
			
		}
		
			}
