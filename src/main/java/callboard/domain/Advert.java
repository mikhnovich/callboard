package callboard.domain;

import java.time.LocalDate;


public class Advert
{
	private Long id;
	private Long userId;
	private String title;
	private String body;
	private String category;
	private String phoneNumber;
	private LocalDate dateOfCreation;
	public Advert()
	{
	}
	public Advert(Long id, String title, String body, String category, String phoneNumber, LocalDate dateOfCreation, Long userId)
	{
		this.id = id;
		this.title = title;
		this.body = body;
		this.category = category;
		this.phoneNumber = phoneNumber;
		this.dateOfCreation = dateOfCreation;
		this.userId = userId;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfCreation()
	{
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation)
	{
		this.dateOfCreation = dateOfCreation;
	}
}
