package com.ntt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.keane.dbfw.ResultMapper;
import com.ntt.domain.BookingDetails;
import com.ntt.domain.UserDetails;
import com.ntt.domain.VehicleDetails;

public class SQLMapper {

	
	public static final String FETCHUSERCREDENTIAL="select roleId_8035 from userDetails_8035 where uid_8035=?";
	public static final String FETCHUSERCREDENTIALS="select roleId_8035 from userDetails_8035 where uid_8035=? and upassword_8035=?";
	public static final String REGISTERUSER="insert into userDetails_8035(uid_8035,uname_8035,upassword_8035, ucity_8035, uemail_8035, ucontactnumber_8035, roleId_8035) values(?,?,?,?,?,?,?)";
	public static final String ADDVEHICLEDETAILS="insert into vehicleDetails_8035(vehicleType_8035, vehicleName_8035,bookingPrice_8035, vehicleNumber_8035) values (?,?,?,?)";
	public static final String FETCHVEHICLESS="select * from vehicleDetails_8035";
	public static final String FETCHVEHICLES="select * from vehicleDetails_8035 where vehicleNumber_8035 = ?";
	public static final String ADDDISCOUNT="update vehicleDetails_8035 set vehicleDiscount_8035 = ? where vehicleNumber_8035 = ?";
	public static final String FETCHFEEDBACK="select vehicleNumber_8035, feedback_8035 from vehicledetails_8035 where vehicleNumber_8035 = ?";
	public static final String ADDFEEDBACK="update vehicleDetails_8035 set feedback_8035 = ? where vehicleNumber_8035 = ? ";
	public static final String FETCHBOOKINGS="select * from bookingDetails_8035";
	public static final String ADDBOOKING="insert into bookingDetails_8035(vehicleNumber_8035) values (?)";
	public static final String FETCHCBOOKING="select vD.vehicleType_8035,vD.vehicleName_8035,vD.bookingPrice_8035,vD.vehicleNumber_8035, vD.vehicleDiscount_8035 from vehicleDetails_8035 vD, bookingDetails_8035 where vD.vehicleNumber_8035 = bookingDetails_8035.vehicleNumber_8035 and vd.vehicleNumber_8035 = ?;";
	public static final String FETCHDISCOUNT="select vehicleNumber_8035, vehicleDiscount_8035 from vehicleDetails_8035 where vehicleNumber_8035 = ?";
	public static final String FETCHFINALPRICE="select vehicleNumber_8035, bookingPrice_8035,vehicleDiscount_8035 from vehicleDetails_8035 where vehicleNumber_8035 = ? ";
	
	public static final ResultMapper VEHICLESMAPPER=
		new ResultMapper()
	{
		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			String vType=	rs.getString(1);
			String vName=rs.getString(2);
			float vPrice = rs.getFloat(3);
			String vNumber = rs.getString(4);
			double vDiscount = rs.getDouble(5);
			
			VehicleDetails v=new VehicleDetails(vType, vName, vPrice, vNumber, vDiscount);
				return v;
		}//mapRow
		
	};//Anonymous class
	public static final ResultMapper VEHICLESSMAPPER=
			new ResultMapper()
		{
			@Override
			public Object mapRows(ResultSet rs) throws SQLException {
				String vType=	rs.getString(1);
				String vName=rs.getString(2);
				float vPrice = rs.getFloat(3);
				String vNumber = rs.getString(4);
				double vDiscount = rs.getDouble(5);
				String vFeedback = rs.getString(6);
				
				VehicleDetails v=new VehicleDetails(vType, vName, vPrice, vNumber, vDiscount, vFeedback);
					return v;
			}//mapRow
			
		};//Anonymous class
	
	
	public static final ResultMapper USERCREDMAPPER=
			new ResultMapper()
		{
			@Override
			public Object mapRows(ResultSet rs) throws SQLException {
				int id=	rs.getInt(1);
				//String password = rs.getString(2);
				
				UserDetails cd=new UserDetails(id);
					return cd;
			}//mapRow
			
		};
		
		public static final ResultMapper BOOKINGSMAPPER=
				new ResultMapper()
			{
				@Override
				public Object mapRows(ResultSet rs) throws SQLException {
					String vNumber = rs.getString(1);
					double vPrice = rs.getDouble(2);
					double vDiscount = rs.getDouble(3);
					double vFinalPrice = rs.getDouble(4);
					
					BookingDetails b=new BookingDetails(vNumber, vPrice, vDiscount, vFinalPrice);
						return b;
				}//mapRow
				
			};//Anonymous class
			public static final ResultMapper CBOOKINGMAPPER=
					new ResultMapper()
				{
					@Override
					public Object mapRows(ResultSet rs) throws SQLException {
						String vType=	rs.getString(1);
						String vName=rs.getString(2);
						float vPrice = rs.getFloat(3);
						String vNumber = rs.getString(4);
						double vDiscount = rs.getDouble(5);
						
						VehicleDetails v=new VehicleDetails(vType, vName, vPrice, vNumber, vDiscount);
							return v;
					}//mapRow
					
				};//Anonymous class
				public static final ResultMapper FEEDBACKMAPPER=
						new ResultMapper()
					{
						@Override
						public Object mapRows(ResultSet fdd) throws SQLException {
							String vFeedback=	fdd.getString(1);
							String vNumber = fdd.getString(2);
							
							VehicleDetails fd=new VehicleDetails(vNumber,vFeedback);
								return fd;
						}//mapRow
						
					};//Anonymous class
				public static final ResultMapper DISCOUNTMAPPER=
							new ResultMapper()
						{
							@Override
							public Object mapRows(ResultSet rs) throws SQLException {
								String dVehNum=	rs.getString(1);
								double dVehDisc = rs.getDouble(2);
								
								
								VehicleDetails dVNum=new VehicleDetails(dVehNum,dVehDisc);
									return dVNum;
							}//mapRow
							
						};
				public static final ResultMapper FINALPRICEMAPPER=
								new ResultMapper()
							{
								@Override
								public Object mapRows(ResultSet rs) throws SQLException {
									String dVehNum=	rs.getString(1);
									double dVehBookP = rs.getDouble(2);
									double dVehDisc = rs.getDouble(3);
									
									
									
									
									VehicleDetails dVNum=new VehicleDetails(dVehNum,dVehBookP,dVehDisc);
										return dVNum;
								}//mapRow
								
							};

}
