package com.ntt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.ntt.dao.UserDetailsDAOException;
import com.ntt.dao.SQLMapper;
import com.ntt.domain.UserDetails;


public class UserDetailsDAO {

	static Logger log=Logger.getLogger(UserDetailsDAO.class);
	
		

	// for login verify fetching uid and password
		//select id,name from country_081 where id=? and name=?
		public static List getCredentials(final int uid,final String upassword)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			List credentials=null;
			
			
			try {
					ch=ConnectionHolder.getInstance();
					con=ch.getConnection();
				final ParamMapper USERCREDPMAPPER=new ParamMapper()
				{
					@Override
					public void mapParams(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1,uid);
					preStmt.setString(2,upassword);						
					}
					
				};//ananymous class
				// going to sql mapper class and executing the select uid and upassword query to match data
			credentials=DBHelper.executeSelect
			(con,SQLMapper.FETCHUSERCREDENTIALS,USERCREDPMAPPER,SQLMapper.USERCREDMAPPER );		
		
			} catch (DBConnectionException e) {
				System.out.println(e);
				e.printStackTrace();
			} catch (DBFWException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			
		
			return credentials;
			
		}//getCredentials
		
// Method to check if user already exists
		public boolean validateUser(final int UserId) throws UserDetailsDAOException {
			ConnectionHolder ch = null;
			Connection con = null;
			List users = null;

			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt) throws SQLException {
					pStmt.setInt(1, UserId);
				}
			};
			try {
				ch = ConnectionHolder.getInstance();
				con = ch.getConnection();
				users = DBHelper.executeSelect(con, SQLMapper.FETCHUSERCREDENTIAL,
						paramMapper, SQLMapper.USERCREDMAPPER);

			} catch (DBConnectionException e) {
				throw new UserDetailsDAOException(e);
			} catch (DBFWException e) {
				throw new UserDetailsDAOException(e);
			}

			return (users != null && users.size() > 0);

		}
		
		
		public int insertUser(final UserDetails c)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper REGISTERPUSER=new ParamMapper()
				{				
					public void mapParams(PreparedStatement preStmt)
							throws SQLException {
						preStmt.setInt(1, c.getUid());
						preStmt.setString(2, c.getUname());
						preStmt.setString(3, c.getUpassword());
						preStmt.setString(4, c.getUcity());
						preStmt.setString(5, c.getUemail());
						preStmt.setLong(6, c.getUcontactNumber());
						preStmt.setInt(7, c.getRoleId());
					}
					
				};
				
			result=DBHelper.executeUpdate(con,SQLMapper.REGISTERUSER,REGISTERPUSER);
				
				
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
			
			
		}//insert

}
