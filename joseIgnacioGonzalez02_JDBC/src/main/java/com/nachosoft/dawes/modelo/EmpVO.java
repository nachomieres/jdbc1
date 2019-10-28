package com.nachosoft.dawes.modelo;

import java.time.LocalDate;

public class EmpVO {
	private float comm;
	private int deptNO;
	private int empNO;
	private String ename;
	private LocalDate hiredate;
	private String job;
	private int mgr;
	private float sal;
	
	public EmpVO(float comm, int deptNO, int empNO, String ename, LocalDate hiredate, String job, int mgr, float sal) {
		super();
		this.comm = comm;
		this.deptNO = deptNO;
		this.empNO = empNO;
		this.ename = ename;
		this.hiredate = hiredate;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
	}
	
	public EmpVO(String ename, LocalDate hiredate, float sal) {
		super();
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
	}
	
	

	public EmpVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getComm() {
		return comm;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	public int getDeptNO() {
		return deptNO;
	}

	public void setDeptNO(int deptNO) {
		this.deptNO = deptNO;
	}

	public int getEmpNO() {
		return empNO;
	}

	public void setEmpNO(int empNO) {
		this.empNO = empNO;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public LocalDate getHiredate() {
		return hiredate;
	}

	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(comm);
		result = prime * result + deptNO;
		result = prime * result + empNO;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + ((hiredate == null) ? 0 : hiredate.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + mgr;
		result = prime * result + Float.floatToIntBits(sal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpVO other = (EmpVO) obj;
		if (Float.floatToIntBits(comm) != Float.floatToIntBits(other.comm))
			return false;
		if (deptNO != other.deptNO)
			return false;
		if (empNO != other.empNO)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (hiredate == null) {
			if (other.hiredate != null)
				return false;
		} else if (!hiredate.equals(other.hiredate))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (mgr != other.mgr)
			return false;
		if (Float.floatToIntBits(sal) != Float.floatToIntBits(other.sal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmpVO [comm=" + comm + ", deptNO=" + deptNO + ", empNO=" + empNO + ", ename=" + ename + ", hiredate="
				+ hiredate + ", job=" + job + ", mgr=" + mgr + ", sal=" + sal + "]";
	}
	
	
	
	
}
