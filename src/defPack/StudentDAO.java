package defPack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO implements Serializable, DAO<Student> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3319859307933397896L;

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public StudentDAO() {

	}

	@Override
	public Collection<Student> retrieve() {
		Collection<Student> colStud = new ArrayList<Student>();
		try {
			String queryString = "SELECT * FROM student";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			Student tempStud = new Student();

			while (resultSet.next()) {
				tempStud.clearStud();

				tempStud.setS_id(resultSet.getLong("s_id"));
				tempStud.setNume(resultSet.getString("nume"));
				tempStud.setPrenume(resultSet.getString("prenume"));
				tempStud.setGrupa(resultSet.getString("grupa"));
				tempStud.setEmail(resultSet.getString("email"));
				tempStud.setTelFix(resultSet.getString("telFix"));

				colStud.add(tempStud);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return colStud;

	}

	@Override
	public Student retrieve(long id) {
		Student tempStud = new Student();
		try {
			String queryString = "SELECT * FROM student where s_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, id);
			resultSet = ptmt.executeQuery();
			resultSet.beforeFirst();
			if (resultSet.next()) {
				tempStud.clearStud();
				tempStud.setS_id(resultSet.getLong("s_id"));
				tempStud.setNume(resultSet.getString("nume"));
				tempStud.setPrenume(resultSet.getString("prenume"));
				tempStud.setGrupa(resultSet.getString("grupa"));
				tempStud.setEmail(resultSet.getString("email"));
				tempStud.setTelFix(resultSet.getString("telFix"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return tempStud;
	}

	@Override
	public boolean create(Student t) {
		boolean status = true;
		try {
			String queryString = "INSERT INTO student(s_id, nume, prenume,grupa, email, telFix) VALUES(?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, t.getS_id());
			ptmt.setString(2, t.getNume());
			ptmt.setString(3, t.getPrenume());
			ptmt.setString(4, t.getGrupa());
			ptmt.setString(5, t.getEmail());
			ptmt.setString(6, t.getTelFix());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
			status = true;
		} catch (SQLException e) {
			e.printStackTrace();
			status = false;
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				status = false;
			} catch (Exception e) {
				e.printStackTrace();
				status = false;
			}

		}
		return status;
	}

	@Override
	public boolean update(Student t) {
		boolean succes = true;
		try {
			String queryString = "UPDATE student SET nume=?,prenume=?,grupa=?,email=?, telFix=? WHERE s_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, t.getNume());
			ptmt.setString(2, t.getPrenume());
			ptmt.setString(3, t.getGrupa());
			ptmt.setString(4, t.getEmail());
			ptmt.setString(5, t.getTelFix());
			ptmt.setLong(6, t.getS_id());
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
			succes = true;
		} catch (SQLException e) {
			e.printStackTrace();
			succes = false;
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return succes;
	}

	@Override
	public boolean delete(Long id) {
		boolean succes = true;
		try {
			String queryString = "DELETE FROM  student WHERE s_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, id);
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
			succes = true;
		} catch (SQLException e) {
			e.printStackTrace();
			succes = false;
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return succes;
	}

}