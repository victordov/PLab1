package defPack;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UnivDAO implements DAO<Universitate>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5068467300824574257L;

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public UnivDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public Collection<Universitate> retrieve() {
		Collection<Universitate> colUniv = new ArrayList<Universitate>();
		try {
			String queryString = "SELECT * FROM Universitate";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			Universitate tempUniv = new Universitate();

			while (resultSet.next()) {
				tempUniv.clearUniv();
				tempUniv.setU_id(resultSet.getLong("u_id"));
				tempUniv.setNume_univer(resultSet.getString("nume_univer"));
				tempUniv.setAdresa(resultSet.getString("adresa"));
				tempUniv.setTelefon(resultSet.getString("telefon"));
				colUniv.add(tempUniv);

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
		if (colUniv != null) {
			return colUniv;
		} else
			return null;

	}

	@Override
	public Universitate retrieve(long id) {
		Universitate tempUniv = new Universitate();
		try {
			String queryString = "SELECT * FROM Universitate where u_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, id);
			resultSet = ptmt.executeQuery();
			resultSet.beforeFirst();
			if (resultSet.next()) {
				tempUniv.clearUniv();
				tempUniv.setU_id(resultSet.getLong("u_id"));
				tempUniv.setNume_univer(resultSet.getString("nume_univer"));
				tempUniv.setAdresa(resultSet.getString("adresa"));
				tempUniv.setTelefon(resultSet.getString("telefon"));
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

		return tempUniv;

	}

	@Override
	public boolean create(Universitate t) {
		boolean state = true;
		try {
			String queryString = "INSERT INTO Universitate(u_id, nume_univer, adresa, telefon) VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setLong(1, t.getU_id());
			ptmt.setString(2, t.getNume_univer());
			ptmt.setString(3, t.getAdresa());
			ptmt.setString(4, t.getTelefon());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
			state = true;
		} catch (SQLException e) {
			e.printStackTrace();
			state = false;
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				state = false;
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				state = false;
			}

		}
		return state;

	}

	@Override
	public boolean update(Universitate t) {
		boolean state = true;
		try {
			String queryString = "UPDATE Universitate SET nume_univer=?,adresa=?,telefon=? WHERE u_id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, t.getNume_univer());
			ptmt.setString(2, t.getAdresa());
			ptmt.setString(3, t.getTelefon());
			ptmt.setLong(4, t.getU_id());
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
			state = true;
		} catch (SQLException e) {
			e.printStackTrace();
			state = false;
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
		return state;

	}

	@Override
	public boolean delete(Long id) {
		boolean succes = true;
		try {
			String queryString = "DELETE FROM  Universitate WHERE u_id=?";
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
