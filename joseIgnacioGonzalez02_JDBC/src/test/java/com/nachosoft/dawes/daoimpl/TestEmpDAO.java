package com.nachosoft.dawes.daoimpl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nachosoft.dawes.util.MySqlDAOFactory;

public class TestEmpDAO {

	static MySqlDAOFactory f=new MySqlDAOFactory();
	
	@Test
	public void t1ConectarOK() {
		assertNotNull(f.getCon());
	}

}
