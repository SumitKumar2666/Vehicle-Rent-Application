package com.keane.dbfw;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultMapper {
	public Object mapRows(ResultSet rs) throws SQLException;
}
