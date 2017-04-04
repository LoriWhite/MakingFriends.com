package user.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Array;

/**
 * Servlet implementation class message1
 */
@WebServlet("/message")
public class message extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String username;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public message() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String sendError="";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		username = (String) session.getAttribute("uname");
		String recipient = request.getParameter("recipient").toString();
		String message = request.getParameter("message").toString();
		
		if(recipientTest(recipient))
		{
			if(checkMessage(message))
			{
				try
				{
					dbconnect db = new dbconnect();
					Connection con = db.connect();
			        Statement st = con.createStatement();
			        String q1 = "insert into messages (username, sender, message, date)\nselect '" + recipient + "', '" + username + "', '" + message + "', current_timestamp()";
		            ResultSet rs = st.executeQuery(q1);
			        
		            st.close();
			        con.close();
			        
		            out.println("message sent");
            		session.setAttribute("uname", username);
            		RequestDispatcher dispatcher = request.getRequestDispatcher("/matchuser");
            	    dispatcher.forward(request, response);
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else
			{
	           	RequestDispatcher dispatcher = request.getRequestDispatcher("/message.jsp");
		        request.setAttribute("sendError","No Message is Written");
	        	dispatcher.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/message.jsp");
	        request.setAttribute("sendError","Incorrect Recipient");
        	dispatcher.forward(request, response);
		}
		
	}

	public boolean recipientTest(String recipientName)
	{
		boolean check = false;
		matchuser m = new matchuser();
		HashMap<String, Integer> map = m.getUser(username);
		Set s = map.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext())
		{
			Map.Entry e = (Map.Entry) i.next();
			if(e.getKey().equals(recipientName))
				check = true;
		}
		
		return check;
	}
	
	public boolean checkMessage(String messageText)
	{
		boolean check = true;
		if(messageText.equals("") || messageText.matches("[^\\s]+"))
			check = false;
		return check;
	}
}
