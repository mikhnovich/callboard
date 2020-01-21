package callboard.services;

import java.sql.SQLException;

import callboard.domain.User;
import callboard.repositories.UserRepository;


public class UserService
{
	UserRepository userRepository;

	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public User createUser(User user)
	{
		try
		{
			return userRepository.createUser(user);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
