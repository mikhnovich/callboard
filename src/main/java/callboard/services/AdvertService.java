package callboard.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import callboard.domain.Advert;
import callboard.repositories.AdvertRepository;


public class AdvertService
{
	AdvertRepository advertRepository;

	public AdvertService(AdvertRepository advertRepository)
	{
		this.advertRepository = advertRepository;
	}

	public Advert createAdvert(Advert advert, Long userId)
	{
		try
		{
			return advertRepository.createAdvert(advert, userId);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public Advert getAdvert(Long id)
	{
		try
		{
			return advertRepository.getAdvert(id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void removeAdvert(Long id)
	{
		try
		{
			advertRepository.removeAdvert(id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Collection<Advert> getAllAdvertsForUser(Long id)
	{
		try
		{
			return advertRepository.getAdvertsForUser(id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
