package user.details;

public class recievedMessage 
{
	private String name, message, time;
	
	public recievedMessage(String sender, String text, String timeStamp)
	{
		this.name = sender;
		this.message = text;
		this.time = timeStamp;
	}
	public String getName() 
	{
		return name;
	}

	public String getMessage() 
	{
		return message;
	}

	public String getTime() 
	{
		return time;
	}
	
}
