package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySql;
import modelo.cliente;

public class ClienteDAO {
	
	//Create
	
	public static void save(cliente clientes) {
		
		//String sql = "INSERT INTO cliente (nome_cliente, cpf_cliente, nasc_cliente, email_cliente, telefone_cliente, endereco_cliente) VALUES (?, ?, ?, ?, ?, ?)";
		String sql = "INSERT INTO cliente (nome_cliente) VALUES (?)";
		
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySql.createConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, clientes.getNome_cliente());
		
		pstm.execute();
		
	}catch (Exception e) {
		
		e.printStackTrace();
				
	} finally {
		
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}
	
	//Read
	
	public List<cliente> getCliente() {
		
		String sql = "SELECT * FROM cliente";
		
		List<cliente> cliente = new ArrayList<cliente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySql.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				cliente clientes = new cliente();
				
				clientes.setId_cliente(rset.getInt("id_cliente"));
				clientes.setNome_cliente(rset.getString("nome_cliente"));
				
				cliente.add(clientes);
			}
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
		
		
	}
	//Update
	public void update(cliente clientes) {
		
		String sql = "UPDATE cliente SET nome_cliente = ? WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySql.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, clientes.getNome_cliente());
			pstm.setInt(2, clientes.getId_cliente());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			}
	}
	
	//Delete
	public void deleteById(int id) {
		
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySql.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			}
		
	}
	
}
