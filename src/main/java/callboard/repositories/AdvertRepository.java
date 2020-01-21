package callboard.repositories;

import static callboard.utils.DatabaseConnection.getDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import callboard.domain.Advert;


public class AdvertRepository
{
	public Advert createAdvert(Advert advert, Long userId) throws SQLException
	{
		PreparedStatement insertPreparedStatement;
		PreparedStatement checkExistencePreparedStatement;

		String insertQuery = "insert into adverts " + 
				"(user_id, title, body, category, phone_number) values " + 
				"(?, ?, ?, ?, ?)";
		
		String checkExistenceQuery = "select id from users where id = ?"; 
		try (Connection connection = getDBConnection())
		{
			connection.setAutoCommit(false);

			checkExistencePreparedStatement = connection.prepareStatement(checkExistenceQuery);
			checkExistencePreparedStatement.setLong(1, userId);
			ResultSet resultSet = checkExistencePreparedStatement.executeQuery();
			if (!resultSet.next()){
				checkExistencePreparedStatement.close();
				connection.commit();
				return null;
			}

			insertPreparedStatement = connection.prepareStatement(insertQuery);
			insertPreparedStatement.setLong(1, userId);
			insertPreparedStatement.setString(2, advert.getTitle());
			insertPreparedStatement.setString(3, advert.getBody());
			insertPreparedStatement.setString(4, advert.getCategory());
			insertPreparedStatement.setString(5, advert.getPhoneNumber());
			int i = insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();
			connection.commit();
			return advert;
		}
	}

	public Advert getAdvert(Long id) throws SQLException
	{
		PreparedStatement selectPreparedStatement;

		String SelectQuery = "select * from adverts where id = " + id;
		try (Connection connection = getDBConnection())
		{
			connection.setAutoCommit(false);

			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			if (rs.next())
			{
				return new Advert(rs.getLong("id"), //
						rs.getString("title"), //
						rs.getString("body"), //
						rs.getString("category"), //
						rs.getString("phone_number"), // 
						rs.getDate("date_of_creation").toLocalDate(), //
						rs.getLong("user_id"));
			}
			selectPreparedStatement.close();

			connection.commit();
		}
		return null;
	}

	public Collection<Advert> getAdvertsForUser(Long id) throws SQLException
	{
		List<Advert> adverts = new ArrayList<>();
		PreparedStatement selectPreparedStatement;

		String SelectQuery = "select * from adverts where user_id = " + id;
		try (Connection connection = getDBConnection())
		{
			connection.setAutoCommit(false);

			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			while (rs.next())
			{
				adverts.add(new Advert(rs.getLong("id"), //
						rs.getString("title"), //
						rs.getString("body"), //
						rs.getString("category"), //
						rs.getString("phone_number"), 
						rs.getDate("date_of_creation").toLocalDate(),//
						rs.getLong("user_id")));
			}
			selectPreparedStatement.close();

			connection.commit();
		}
		return adverts;
	}

	public void removeAdvert(Long id) throws SQLException
	{
		PreparedStatement statement;

		String query = "delete from adverts where id = ?";
		try (Connection connection = getDBConnection())
		{
			connection.setAutoCommit(false);

			statement = connection.prepareStatement(query);
			statement.setLong(1, id);

			int row = statement.executeUpdate();

			// rows affected
			System.out.println(row);
			statement.close();

			connection.commit();
		}
	}
}
