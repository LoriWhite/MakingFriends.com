package user.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class notifications
 */
@WebServlet("/notifications")
public class notifications extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String uname;
	private ArrayList<recievedMessage> text;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public notifications() 
    {
        super();
        text = new ArrayList<recievedMessage>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String recieveError="";	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		//PrintWriter out = response.getWriter();
		HttpSession session1 = request.getSession();
		//response.setContentType("text/html");
		
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
	        Statement st = con.createStatement();
	        String q1 = "select sender, message, date from messages where username = '" + uname + "'";
	        ResultSet r = st.executeQuery(q1);
	        
	        while(r.next())
	        {
	        	String recipient = r.getString("sender");
	        	String message = r.getString("message");
	        	String time = r.getString("date");
	        	text.add(new recievedMessage(recipient, message, time));
	        }
	        
            st.close();
	        con.close();
	      
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		if(text.isEmpty())
		{
			session1.setAttribute("uname",uname);
	      	RequestDispatcher dispatcher = request.getRequestDispatcher("/nonotifications.jsp");
		    dispatcher.forward(request, response);
		}
		else
		{
			System.out.println("messages recieved");
			session1.setAttribute("messages",text);
	      	session1.setAttribute("uname",uname);
	      	RequestDispatcher dispatcher = request.getRequestDispatcher("/notifications.jsp");
		    dispatcher.forward(request, response);
		}
	}

}
