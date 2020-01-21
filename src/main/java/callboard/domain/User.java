package callboard.domain;

public class User
{
	private Long id;
	private String name;
	private String surname;
	private String email;
	private String category;

	public User()
	{
	}

	public User(Long id, String name, String surname, String email, String category)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.category = category;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}
}
