package com.sh.sqltoweb.service;

import com.sh.sqltoweb.dto.DBInfoDto;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class DBInfoService {



    public String dbInfo(DBInfoDto dbInfoDto){

        String connStr = dbInfoDto.getConnString();
        String dbName = dbInfoDto.getDbName();
        String query = String.format("SELECT table_name, column_name, data_type, is_nullable, column_key, column_default, extra " +
                "FROM information_schema.columns " +
                "WHERE table_schema = '%s'",dbName);
        StringBuffer result = new StringBuffer();

        try (Connection connection = DriverManager.getConnection(connStr);
             Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()){
                    for(int i =1; i<=columnCount; i++){
                        result.append(metaData.getColumnLabel(i)).append(": ").append(resultSet.getObject(i)).append(", ");
                    }
/*
                    result.append("\n");
*/
                }
                connection.close();
                return result.toString();
        } catch (SQLException e) {
            return "Query Failed: " + e.getMessage();
        }
    }
}
