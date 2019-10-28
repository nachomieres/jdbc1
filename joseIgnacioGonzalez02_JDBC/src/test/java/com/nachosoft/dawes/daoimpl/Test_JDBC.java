package com.nachosoft.dawes.daoimpl;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nachosoft.dawes.modelo.DeptVO;
import com.nachosoft.dawes.modelo.EmpVO;
import com.nachosoft.dawes.util.MySqlDAOFactory;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test_JDBC {
	static MySqlDAOFactory f=new MySqlDAOFactory();
	static DeptDAO d;
	static EmpDAO e;

	@Test
	public void t1conectarOK() {
		assertNotNull(f.getCon());
		d = f.getDeptDAO();
		e = f.getEmpDAO();
		e.eliminarTodo();
		d.eliminarTodo();		
	}
	
	@Test
	public void t2InsertarDeptOK() {
		d.insertar(new DeptVO(50, "Maintenace", "Mieres"));
		assertEquals(1,d.insertar(new DeptVO(60, "Production", "Oviedo")));
	}
	
	@Test
	public void t3MostrarDeptOK() {
		assertNotNull(d.mostrar(60));
	}

	@Test
	public void t4InsertarEmpOK () {
		e.insertar(new EmpVO(11085295, "NACHO", LocalDate.of(2008, 01, 02), 3000, 50));
		assertEquals(1, e.insertar(new EmpVO(11085296, "NACHO2", LocalDate.of(2008, 01, 02), 3000, 60)));
	}
	
	@Test
	public void t5MostrarEmpOK() {
		assertNotNull(e.mostrar(11085295));
	}
	
	@Test 
	public void t6mostrarTodosEmpOK() {
		assertNotNull(e.mostrarTodos());
	}
}
