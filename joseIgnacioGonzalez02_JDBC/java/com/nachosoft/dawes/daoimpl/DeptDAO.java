package com.nachosoft.dawes.daoimpl;

import com.nachosoft.dawes.modelo.DeptVO;

public interface DeptDAO {
	public int insertar (DeptVO dept);
	public DeptVO mostrar (int d);
	public int eliminarTodo();
	
}
