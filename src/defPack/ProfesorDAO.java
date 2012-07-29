package defPack;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ProfesorDAO implements Serializable, DAO<Profesor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4147876920484596173L;

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public Collection<Profesor> retrieve() {
		Collection<Profesor> colProf = new ArrayList<Profesor>();
		try {
			String queryString = "SELECT * FROM Profesor";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			Profesor tempProf = new Profesor();

			while (resultSet.next()) {
				tempProf.clearProf();
				tempProf.setP_id(resultSet.getLong("p_id"));
				tempProf.setNume(resultSet.getString("nume"));
				tempProf.setPrenume(resultSet.getString("prenume"));
				tempProf.setAdresa(resultSet.getString("adresa"));
				colProf.add(tempProf);

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
		return colProf;
	}

	@Override
	public Profesor retrieve(long id) {
		Profesor tempProf = new Profesor();
		try {
			String queryString = "SELECT * FROM Profesor where p_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, id);
			resultSet = ptmt.executeQuery();
			resultSet.beforeFirst();
			if (resultSet.next()) {
				tempProf.clearProf();
				tempProf.setP_id(resultSet.getLong("p_id"));
				tempProf.setNume(resultSet.getString("nume"));
				tempProf.setPrenume(resultSet.getString("prenume"));
				tempProf.setAdresa(resultSet.getString("adresa"));
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
		return tempProf;
	}

	@Override
	public boolean create(Profesor t) {
		boolean status = true;
		try {
			String queryString = "INSERT INTO Profesor(p_id, nume, prenume, adresa) VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, t.getP_id());
			ptmt.setString(2, t.getNume());
			ptmt.setString(3, t.getPrenume());
			ptmt.setString(4, t.getAdresa());
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
	public boolean update(Profesor t) {
		boolean succes = true;
		try {
			String queryString = "UPDATE PROFESOR SET nume=?,prenume=?,adresa=? WHERE p_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, t.getNume());
			ptmt.setString(2, t.getPrenume());
			ptmt.setString(3, t.getAdresa());
			ptmt.setLong(4, t.getP_id());
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
		boolean status = true;
		try {
			String queryString = "DELETE FROM Profesor WHERE p_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, id);
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
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
			}

			catch (SQLException e) {
				e.printStackTrace();
				status = false;
			} catch (Exception e) {
				e.printStackTrace();
				status = false;

			}
		}
		return status;
	}

}
