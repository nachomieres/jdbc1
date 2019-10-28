package com.nachosoft.dawes.daoimpl;

import java.util.ArrayList;

import com.nachosoft.dawes.modelo.EmpVO;

public interface EmpDAO {
	public int insertar (EmpVO e);
	public EmpVO mostrar (int n);
	public ArrayList<EmpVO> mostrarTodos ();
	public int eliminarTodo();
}
