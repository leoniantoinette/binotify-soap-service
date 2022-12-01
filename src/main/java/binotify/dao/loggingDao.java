package binotify.dao;

import binotify.formats.*;
import binotify.helpers.*;

import java.sql.*;
public class loggingDao {
    public boolean uploadLog (log log) throws SQLException {
        String query = "INSERT INTO logging (description, IP, endpoint, requested_at) VALUES (?,?,?,NOW())";
        Connection conn = DBConnector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, log.getDescription());
        statement.setString (2, log.getIP());
        statement.setString (3, log.getEndpoint());
        return statement.executeUpdate() > 0;
    }

}
