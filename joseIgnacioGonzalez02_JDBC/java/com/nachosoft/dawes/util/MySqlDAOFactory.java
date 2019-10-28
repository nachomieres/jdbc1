package com.nachosoft.dawes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.nachosoft.dawes.daoimpl.DeptDAO;
import com.nachosoft.dawes.daoimpl.DeptDAOimpl;
import com.nachosoft.dawes.daoimpl.EmpDAO;
import com.nachosoft.dawes.daoimpl.EmpDAOImpl;

public class MySqlDAOFactory {

	private Connection con;
	
	public MySqlDAOFactory() {
		// cargar el driver
			String url="jdbc:mysql://localhost/tema1";
			String usuario="root";
			String password="temporal";
			try {
				con=DriverManager.getConnection(url,usuario,password);
				System.out.println("conexion ok");
				
			} catch (SQLException e) {
				System.out.println("hay un error en la conexi�n"+e.getMessage());
			}
			
}
	
	
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}

	public DeptDAO getDeptDAO() {
		return new DeptDAOimpl(con);
	}
	
	public EmpDAO getEmpDAO () {
		return new EmpDAOImpl(con);
	}
}
