package ar.com.educacionit.bootcamp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import ar.com.educacionit.bootcamp.Entity;
import ar.com.educacionit.bootcamp.db.AdministradorDeConexiones;

public abstract class BaseCrud<T extends Entity> implements BaseRepository<T> {

	private Class<T> type;
	private String table;

	public BaseCrud(Class<T> type,String table) {
		this.type = type;
		this.table = table;
	}

	@Override
	public void delete(Long id) {
		//eliminar entidad por id
		System.out.println("Eliminandio " + type.getName() + "por id="+id);
		
		String sql = "DELETE FROM "+ this.table + " WHERE ID = ?";

		try(Connection connection = AdministradorDeConexiones.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(sql);
			//                ?
			statement.setLong(1, id);

			int res = statement.executeUpdate();
			if(res > 0) {
				System.out.println("Se elimino el id:" + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Collection<T> findAll() {
		System.out.println("findAll " + type.getName());
		String sql = "SELECT * FROM "+ this.table;
		List<T> list = new ArrayList<>();

		try(Connection connection = AdministradorDeConexiones.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {//hay registro que mirar
				list.add(this.fromResultSetToEntity(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return list;
	}
	
	@Override
	public T getById(Long id) {
		String sql = "SELECT * FROM "+ this.table + " WHERE ID = " + id;

		T entity = null;

		//JDBC: par poder consultar a la tabla via java
		System.out.println(sql);
		try(Connection connection = AdministradorDeConexiones.getConnection()) {
			
			//armar el sql
			PreparedStatement statement = connection.prepareStatement(sql);

			//recibir los datos
			ResultSet resultSet = statement.executeQuery();
			
			//id|col2|colmN
			//procesar los registro
			if(resultSet.next()) {//hay registro que mirar
				//extraigo los datos
				entity = this.fromResultSetToEntity(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Api Reflection
		return entity;
	}
	
	//cada RespositoryImpl debe implementar como extrae la data desde ResultSet
	protected abstract T fromResultSetToEntity(ResultSet res) throws SQLException;
		
	@Override
	public void save(T entidad) {
		String sql ="INSERT INTO " + this.table + this.getSaveSQL();
		System.out.println(sql);
		try(Connection connection = AdministradorDeConexiones.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			saveEntity(entidad, statement);

			statement.executeUpdate();

			ResultSet resKey = statement.getGeneratedKeys();
			if(resKey.next()) {
				entidad.setId(resKey.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	protected abstract String getSaveSQL();
	protected abstract String getUpdateSQL();
	protected abstract void setUpdateSQL(T entidad,PreparedStatement pst) throws SQLException;
	protected abstract void saveEntity(T entidad,PreparedStatement pst) throws SQLException;
	
	@Override
	public void update(T entidad) {
		System.out.println("Actualizando " + type.getName() + entidad);
		String sql ="UPDATE " + this.table + " SET " + this.getUpdateSQL() + "WHERE id = ?";

		try(Connection connection = AdministradorDeConexiones.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(sql);

			setUpdateSQL(entidad, statement);
			
			char[] ar = sql.toCharArray();
			int contador=0;
			for (int i = 0; i < ar.length; i++) {
				if(ar[i]=='?') contador++;
			}
			System.out.println(contador);
			System.out.println("ultimo signo es " + sql.lastIndexOf('?')); 
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public List<T> findBySQL(String sql) {
		List<T> list = new ArrayList<>();

		try(Connection connection = AdministradorDeConexiones.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {//hay registro que mirar
				list.add(this.fromResultSetToEntity(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return list;
	}
}