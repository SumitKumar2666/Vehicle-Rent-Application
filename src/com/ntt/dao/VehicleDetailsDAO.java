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
import com.ntt.domain.VehicleDetails;

public class VehicleDetailsDAO {

	static Logger log=Logger.getLogger(UserDetailsDAO.class);
	
	
	// method for Admin operation - add vehicle
	public static int addVehicle(final VehicleDetails v)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper ADDVEHICLE=new ParamMapper()
			{				
				public void mapParams(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setString(1, v.getVehicleType());
					preStmt.setString(2, v.getVehicleName());
					preStmt.setDouble(3, v.getVehicleBPrice());
					preStmt.setString(4, v.getVehicleNumber());
					
				}
				
			};
			
		result=DBHelper.executeUpdate(con,SQLMapper.ADDVEHICLEDETAILS,ADDVEHICLE);
			
			
		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return result;
		
		
	}
	
	// method for admin operation - view vehicles
				public static List getVehicles() throws DBFWException, UserDetailsDAOException, DBConnectionException
				{
					List vehicles=null;
					ConnectionHolder ch=null;
					Connection con=null;
					try {
						ch=ConnectionHolder.getInstance();
						con=ch.getConnection();
						
						log.debug("fetchig");
						
						
						vehicles=DBHelper.executeSelect(con,SQLMapper.FETCHVEHICLESS,SQLMapper.VEHICLESSMAPPER);
								
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
					
					
					return vehicles;
					
				}//getVehicle
	
	// method for customer operation - search vehicle
			public static List getVehicles(final String vehNum) throws DBFWException, UserDetailsDAOException, DBConnectionException
			{
				List vehicles=null;
				ConnectionHolder ch=null;
				Connection con=null;
				try {
					ch=ConnectionHolder.getInstance();
					con=ch.getConnection();
					
					log.debug("fetchig");
					
					final ParamMapper FETCHVEH=new ParamMapper()
					{				
						public void mapParams(PreparedStatement preStmt)
								throws SQLException {
							preStmt.setString(1, vehNum);
							
							
							
						}
						
					};
					
					vehicles=DBHelper.executeSelect(con,SQLMapper.FETCHVEHICLES,FETCHVEH,SQLMapper.VEHICLESMAPPER);
							
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
				
				
				return vehicles;
				
			}//getVehicle
		
		public static int addDiscount(final VehicleDetails v)
			{
				ConnectionHolder ch=null;
				Connection con=null;
				int result=0;
				
				try {
					ch=ConnectionHolder.getInstance();
					con=ch.getConnection();
					
					final ParamMapper ADDDISCOUNT=new ParamMapper()
					{				
						public void mapParams(PreparedStatement preStmt)
								throws SQLException {
							preStmt.setDouble(1, v.getVehicleDiscount());
							preStmt.setString(2, v.getVehicleNumber());
							
							
						}
						
					};
					
				result=DBHelper.executeUpdate(con,SQLMapper.ADDDISCOUNT,ADDDISCOUNT);
//				if(result!=0)
//				{
//					System.out.println("Discount added successfully");
//				}
//				else
//				{
//					System.out.println("Failed to add discount");
//				}
					
				} catch (DBFWException e) {
					e.printStackTrace();
					System.out.println(e);
				} catch (DBConnectionException e) {
					e.printStackTrace();
					System.out.println(e);
				}
				
				return result;
				
				
			}
		public static List getDiscount(final String discVNum) throws DBFWException, UserDetailsDAOException, DBConnectionException
		{
			List vehiclesFeedback=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper DISCOUNTPMAPPER=new ParamMapper()
				{				
					public void mapParams(PreparedStatement preStmt)
							throws SQLException {
						preStmt.setString(1, discVNum);
					
						
						
					}
					
				};
				log.debug("fetchig");
				vehiclesFeedback=DBHelper.executeSelect(con,SQLMapper.FETCHDISCOUNT,DISCOUNTPMAPPER,SQLMapper.DISCOUNTMAPPER);
						
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
			
			
			return vehiclesFeedback;

		}
		
		public static List getFinalPrice(final String discVNum) throws DBFWException, UserDetailsDAOException, DBConnectionException
		{
			List vehiclesFeedback=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper FINALPMAPPER=new ParamMapper()
				{				
					public void mapParams(PreparedStatement preStmt)
							throws SQLException {
						preStmt.setString(1, discVNum);
					
						
						
					}
					
				};
				log.debug("fetchig");
				vehiclesFeedback=DBHelper.executeSelect(con,SQLMapper.FETCHFINALPRICE,FINALPMAPPER,SQLMapper.FINALPRICEMAPPER);
						
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
			
			
			return vehiclesFeedback;

		}
		
		public static List getFeedback(final String feedVehNumber) throws DBFWException, UserDetailsDAOException, DBConnectionException
		{
			List vehiclesFeedback=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				final ParamMapper GETFEEDMAPPER=new ParamMapper()
				{				
					public void mapParams(PreparedStatement preStmt)
							throws SQLException {
						preStmt.setString(1, feedVehNumber);
						
						
				}
				};
				log.debug("fetchig");
				vehiclesFeedback=DBHelper.executeSelect(con,SQLMapper.FETCHFEEDBACK,GETFEEDMAPPER,SQLMapper.FEEDBACKMAPPER);
						
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
			
			
			return vehiclesFeedback;

		}
		
		public static int addFeedback(final String vehnum, final String vehFeed)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper ADDFEEDBACK=new ParamMapper()
				{				
					public void mapParams(PreparedStatement preStmt)
							throws SQLException {
						preStmt.setString(1, vehFeed);
						preStmt.setString(2, vehnum);
						
						
					}
					
				};
				
			result=DBHelper.executeUpdate(con,SQLMapper.ADDFEEDBACK,ADDFEEDBACK);
			if(result!=0)
			{
				System.out.println("Feedback added successfully");
			}
			else
			{
				System.out.println("Failed to add feedback");
			}
				
			} catch (DBFWException e) {
				e.printStackTrace();
				System.out.println(e);
			} catch (DBConnectionException e) {
				e.printStackTrace();
				System.out.println(e);
			}
			
			return result;
			
			
		}
}

