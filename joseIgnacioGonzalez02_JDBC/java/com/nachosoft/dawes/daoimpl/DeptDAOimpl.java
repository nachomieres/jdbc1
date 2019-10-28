package com.nachosoft.dawes.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nachosoft.dawes.modelo.DeptVO;
import com.nachosoft.dawes.modelo.EmpVO;

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
			ps=con.prepareStatement("insert into dept(deptNO, dname, loc) values (?,?,?)");
			
			// paso 2: asigno valor a los parametros
			ps.setInt(1, dept.getDeptNO());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());
			
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

	public DeptVO mostrar(int d) {
		try {
			// paso 1: creamos una ps con la sentencia de la consulta
			ps=con.prepareStatement("select deptNO, dname, loc from dept where deptNO=?");
			
			//paso 2: asigno valor a los parametros
			ps.setInt(1, d);
			
			// paso 3: ejecutar la consulta
			rs=ps.executeQuery();
			
			// recorro el rs 
			if (rs.next()) {
				// si encuentra el registro, tiene que construir un objeto UsuarioVO
				// con el registro leido de la tabla
				DeptVO dep = new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println(dep.toString());
				return dep;
				
			} else return new DeptVO();
		} catch (SQLException e) {
			System.out.println("error al consultar por nif "+e.getMessage());
		}
		return null;
	}	
}
