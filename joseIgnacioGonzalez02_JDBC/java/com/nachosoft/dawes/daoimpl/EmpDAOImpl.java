package com.nachosoft.dawes.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nachosoft.dawes.modelo.EmpVO;

public class EmpDAOImpl implements EmpDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EmpDAOImpl (Connection c) {
		this.con = c;
	}

	public int insertar(EmpVO emp) {
		try {
			// paso 1: creamos una ps con la sentencia sql que no interesa
			ps=con.prepareStatement("insert into emp (empNO, ename, hiredate, sal, deptNO) values (?,?,?,?,?)");
			
			// paso 2: asigno valor a los parametros
			ps.setInt(1, emp.getEmpNO());
			ps.setString(2, emp.getEname());
			ps.setDate(3, Date.valueOf(emp.getHiredate()));
			ps.setDouble(4, emp.getSal());						
			ps.setInt(5, emp.getDeptNO());
			//paso 3: ejecuto la ps
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error al insertar en Empleados "+e.getMessage());
		}
		return 0;
	}

	public EmpVO mostrar(int n) {
		try {
			// paso 1: creamos una ps con la sentencia de la consulta
			ps=con.prepareStatement("select empNO, ename, hiredate, sal, deptNO from emp where empNO=?");
			
			//paso 2: asigno valor a los parametros
			ps.setInt(1, n);
			
			// paso 3: ejecutar la consulta
			rs=ps.executeQuery();
			
			// recorro el rs 
			if (rs.next()) {
				// si encuentra el registro, tiene que construir un objeto UsuarioVO
				// con el registro leido de la tabla
				EmpVO emp = new EmpVO(rs.getInt(1), rs.getString(2),rs.getDate(3).toLocalDate(), rs.getFloat(4), rs.getInt(5));
				System.out.println (emp.toString());
				return emp;
				
			} else return new EmpVO();
		} catch (SQLException e) {
			System.out.println("error al consultar por numero de empleado "+e.getMessage());
		}
		return null;
	}
	
	

	public ArrayList<EmpVO> mostrarTodos() {		
		ArrayList<EmpVO> consulta = new ArrayList<EmpVO>();
		try {
			// paso 1: creamos una ps con la sentencia de la consulta
			ps=con.prepareStatement("SELECT empNO, ename, hiredate, sal, deptNO FROM emp");
						
			// paso 2: ejecutar la consulta
			rs=ps.executeQuery();
			
			while (rs.next()) {
				EmpVO e = new EmpVO(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getFloat(4), rs.getInt(5));
				System.out.println(e.toString());
				
				consulta.add(e);
			}		
		} catch (SQLException e) {
			System.out.println("error al consultar toda la tabla"+e.getMessage());
			consulta=null;
			
		}
		return consulta;
	}

	public int eliminarTodo() {
		try {
			// paso 1: creamos una ps con la sentencia sql de eliminar
			ps=con.prepareStatement("delete from emp");
			
			// paso 3:ejecuto la sentencia
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error al eliminar todo "+e.getMessage());
		}
		return 0;
	}

}
