package ar.com.educacionit.bootcamp.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.bootcamp.User;

public class UserRepositoryImpl extends BaseCrud<User> implements UserRepository {

	public UserRepositoryImpl() {
		super(User.class, "USER");
	}
	
	@Override
	protected User fromResultSetToEntity(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong(1);
		String useranme = resultSet.getString(2);
		String password = resultSet.getString(3);

		return new User(id, useranme, password);
	}
	
	@Override
	protected String getSaveSQL() {		
		return "(username,password) values(?,?)";
	}
	@Override
	protected String getUpdateSQL() {		
		return "username = ?, password = ? ";
	}

	@Override
	protected void saveEntity(User entidad, PreparedStatement pst) throws SQLException {
		if(entidad.getId() != null) pst.setLong(3, entidad.getId());
		pst.setString(1, entidad.getUsername());
		pst.setString(2, entidad.getPassword());
	}

	@Override
	protected void setUpdateSQL(User entidad, PreparedStatement pst) throws SQLException {
		pst.setString(1, entidad.getUsername());
		pst.setString(2, entidad.getPassword());
		pst.setLong(3, entidad.getId());
	}
	
}