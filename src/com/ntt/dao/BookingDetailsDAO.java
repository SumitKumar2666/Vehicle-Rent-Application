package com.ntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.ntt.domain.BookingDetails;

public class BookingDetailsDAO {
	
	static Logger log=Logger.getLogger(BookingDetailsDAO.class);
	
	public static List getBookings() throws DBFWException, UserDetailsDAOException, DBConnectionException
	{
		List bookings=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			bookings=DBHelper.executeSelect(con,SQLMapper.FETCHBOOKINGS,SQLMapper.BOOKINGSMAPPER);
					
		} catch (DBConnectionException e) {
			System.out.println(e);
			throw new DBConnectionException("Unable to connect to db"+e);
		
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		
		
		return bookings;
		
	}//getBooking
	
	public static int addBooking(final BookingDetails b)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper ADDBOOKINGP=new ParamMapper()
			{				
				public void mapParams(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setString(1, b.getVehicleNumber());
				}
				
			};
			
		result=DBHelper.executeUpdate(con,SQLMapper.ADDBOOKING,ADDBOOKINGP);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		return result;
		
		
	}//addBooking
	
	public static List getCBooking(final String vNum) throws DBFWException
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List cBooking=null;
		
		try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
			final ParamMapper CBOOKINGPMAPPER=new ParamMapper()
			{
				@Override
				public void mapParams(PreparedStatement preStmt) throws SQLException {
				preStmt.setString(1,vNum);						
				}
				
			};//Anonymous class
			// going to sql mapper class and executing the 
		cBooking=DBHelper.executeSelect(con,SQLMapper.FETCHCBOOKING, CBOOKINGPMAPPER,SQLMapper.CBOOKINGMAPPER );		
	
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cBooking;
		
	}//getcountry
	


}
