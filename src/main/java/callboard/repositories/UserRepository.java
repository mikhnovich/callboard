package callboard.repositories;

import static callboard.utils.DatabaseConnection.getDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import callboard.domain.Advert;
import callboard.domain.User;


public class UserRepository
{
	public User createUser(User user) throws SQLException
	{
		PreparedStatement insertPreparedStatement;

		String InsertQuery = "INSERT INTO users " + "(name, surname, email, category) values " + "(?, ?, ?, ?)";
		try (Connection connection = getDBConnection())
		{
			connection.setAutoCommit(false);

			insertPreparedStatement = connection.prepareStatement(InsertQuery);
			insertPreparedStatement.setString(1, user.getName());
			insertPreparedStatement.setString(2, user.getSurname());
			insertPreparedStatement.setString(3, user.getEmail());
			insertPreparedStatement.setString(4, user.getCategory());
			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			connection.commit();
		}
		try (ResultSet generatedKeys = insertPreparedStatement.getGeneratedKeys())
		{
			if (generatedKeys.next())
			{
				user.setId(generatedKeys.getLong(1));
			}
			else
			{
				throw new SQLException("Creating user failed, no ID obtained.");
			}
		}
		return user;
	}

	public Advert getAdvert(Long id)
	{
		Connection connection = getDBConnection();
		try
		{
			connection.createStatement();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return new Advert(1L, "title", "body", "category", "phoneNumber", LocalDate.now(), 1L);
	}

	public Collection<Advert> getAdvertsForUser(Long id)
	{
		Advert advert = new Advert(1L, "title", "body", "category", "phoneNumber", LocalDate.now(), 1L);

		ArrayList<Advert> adverts = new ArrayList<>();
		adverts.add(advert);
		return adverts;
	}

	public void removeAdvert(Long id)
	{

	}
}
