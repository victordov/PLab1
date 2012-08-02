package defPack;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CursDAO implements Serializable, DAO<Curs> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -380776877416367670L;

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public CursDAO() {

	}

	@Override
	public Collection<Curs> retrieve() {

		Collection<Curs> colCurs = new ArrayList<Curs>();
		try {
			String queryString = "SELECT * FROM Curs";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			Curs tempCurs = new Curs();

			while (resultSet.next()) {

				tempCurs.setC_id(resultSet.getLong("c_id"));
				tempCurs.setNume_curs(resultSet.getString("nume_curs"));
				tempCurs.setU_id(resultSet.getLong("u_id"));
				tempCurs.setP_id(resultSet.getLong("p_id"));

				colCurs.add(tempCurs);

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

		return colCurs;

	}

	@Override
	public Curs retrieve(long id) {
		Curs tempCurs = new Curs();
		try {
			String queryString = "SELECT * FROM Curs where c_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, id);
			resultSet = ptmt.executeQuery();
			resultSet.beforeFirst();
			if (resultSet.next()) {

				tempCurs.setC_id(resultSet.getLong("c_id"));
				tempCurs.setNume_curs(resultSet.getString("nume_curs"));
				tempCurs.setU_id(resultSet.getLong("u_id"));
				tempCurs.setP_id(resultSet.getLong("p_id"));
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
		return tempCurs;
	}

	@Override
	public boolean create(Curs t) {
		boolean status = true;
		try {
			String queryString = "INSERT INTO Curs(c_id, nume_curs, u_id, p_id) VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, t.getC_id());
			ptmt.setString(2, t.getNume_curs());
			ptmt.setLong(3, t.getU_id());
			ptmt.setLong(4, t.getP_id());
			ptmt.executeUpdate();
			System.out.println("Curs nou a fost adaugat in tabel");
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
	public boolean delete(Long id) {
		boolean succes = true;
		try {
			String queryString = "DELETE FROM Curs WHERE c_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, id);
			ptmt.executeUpdate();
			System.out.println("Tabelul a fost reinnoit");
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
	public boolean update(Curs t) {
		boolean succes = true;
		try {
			String queryString = "UPDATE Curs SET nume_curs=?,u_id=?,p_id=? WHERE c_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, t.getNume_curs());
			ptmt.setLong(2, t.getU_id());
			ptmt.setLong(3, t.getP_id());
			ptmt.setLong(4, t.getC_id());
			ptmt.executeUpdate();
			System.out.println("Tabelul a fost reinnoit");
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
