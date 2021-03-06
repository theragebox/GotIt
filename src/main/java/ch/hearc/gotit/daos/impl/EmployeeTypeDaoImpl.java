package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.EmployeeTypeDao;
import ch.hearc.gotit.entities.EmployeeTypeEntity;

import org.springframework.stereotype.Repository;

@Repository("employeeTypeDao")
public class EmployeeTypeDaoImpl extends BasicDaoImpl<EmployeeTypeEntity, Integer> implements EmployeeTypeDao {

	public EmployeeTypeDaoImpl() {
		super(EmployeeTypeEntity.class);
	}

	@Override
	public EmployeeTypeEntity findByName(String name) {
		return (EmployeeTypeEntity) getCurrentSession()
				.getNamedQuery("EmployeeTypeQuery.findByName")
				.setString("name", name)
				.uniqueResult();
	}
}
