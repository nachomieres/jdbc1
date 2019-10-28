package com.nachosoft.dawes.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nachosoft.dawes.modelo.DeptVO;

public class DeptDAOimpl implements DeptDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public DeptDAOimpl (Connection c) {
		this.con = c;
	}

	public int insertar(DeptVO dept) {
		try {
			// paso 1: creamos una ps con la sentencia sql que no interesa
			ps=con.prepareStatement("insert into dept(dname, loc) values (?,?)");
			
			// paso 2: asigno valor a los parametros
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLoc());
			
			//paso 3: ejecuto la ps
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error al insertar en Departamentos "+e.getMessage());
		}
		return 0;
	}
	
	public int eliminarTodo() {
		try {
			// paso 1: creamos una ps con la sentencia sql de eliminar
			ps=con.prepareStatement("delete from dept");
			
			// paso 3:ejecuto la sentencia
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error al eliminar todo "+e.getMessage());
		}
		return 0;
	}
	
	
}
