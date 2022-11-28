package binotify.dao;

import binotify.formats.*;
import binotify.helpers.*;

import java.sql.*;

public class subscriptionDao {
    public boolean addSubscription(subscription subscription) throws SQLException {
        String query = "INSERT INTO subscription (creator_id, subscriber_id) VALUES (?,?)";

        Connection conn = DBConnector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, subscription.getCreator_id());
        statement.setInt(2, subscription.getSubscriber_id());

        return statement.executeUpdate() > 0;
    }

    public boolean approveSubscription(subscription subscription) throws SQLException {
        String query = "UPDATE subscription SET status = 'ACCEPTED' WHERE creator_id = ? AND subscriber_id = ?";

        Connection conn = DBConnector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, subscription.getCreator_id());
        statement.setInt(2, subscription.getSubscriber_id());

        return statement.executeUpdate() > 0;
    }

    public boolean rejectSubscription(subscription subscription) throws SQLException {
        String query = "UPDATE subscription SET status = 'REJECTED' WHERE creator_id = ? AND subscriber_id = ?";

        Connection conn = DBConnector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, subscription.getCreator_id());
        statement.setInt(2, subscription.getSubscriber_id());

        return statement.executeUpdate() > 0;
    }

    public boolean checkSubscription(subscription subscription) throws SQLException {
        String query = "SELECT status FROM subscription  WHERE creator_id = ? AND subscriber_id = ?";

        Connection conn = DBConnector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, subscription.getCreator_id());
        statement.setInt(2, subscription.getSubscriber_id());

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        String status = resultSet.getString("status");

        return status.equals("ACCEPTED");
    }
}
