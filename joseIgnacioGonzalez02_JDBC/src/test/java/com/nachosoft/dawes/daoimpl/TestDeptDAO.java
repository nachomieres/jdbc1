package com.nachosoft.dawes.daoimpl;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nachosoft.dawes.modelo.DeptVO;
import com.nachosoft.dawes.util.MySqlDAOFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDeptDAO {

	static MySqlDAOFactory f=new MySqlDAOFactory();
	static DeptDAO d;
	
	@Test
	public void t1conectarOK() {
		assertNotNull(f.getCon());
		d = f.getDeptDAO();
		d.eliminarTodo();
		
	}
	@Test
	public void t1InsertarOK() {
		d.insertar(new DeptVO("Maintenace", "Mieres"));
		assertEquals(1,new DeptVO("Production", "Oviedo"));
	}
}
