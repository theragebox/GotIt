package ch.hearc.gotit.daos;

import ch.hearc.gotit.entities.UserEntity;

public interface UserDao extends BasicDao<UserEntity, Integer> {
	
	public UserEntity findByUsername(String username);
}
