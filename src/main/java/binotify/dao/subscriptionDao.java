package binotify.dao;

import binotify.formats.*;
import binotify.helpers.*;

import java.sql.*;
import java.util.*;

public class subscriptionDao {
    public List<subscription> getSubscription() throws SQLException {
        String query = "SELECT * FROM subscription WHERE status = 'PENDING'";

        Connection conn = DBConnector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        List<subscription> subscriptionList = new ArrayList<subscription>();
        while (resultSet.next()) {
            int creator_id = resultSet.getInt("creator_id");
            int subscriber_id = resultSet.getInt("subscriber_id");
            String status = resultSet.getString("status");
            subscription s = new subscription(creator_id, subscriber_id);
            s.setStatus(status);
            subscriptionList.add(s);
        }
        return subscriptionList;
    }

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

    public List<subscription> getAllSubscription() throws SQLException {
        String query = "SELECT * FROM subscription";

        Connection conn = DBConnector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        List<subscription> subscriptionList = new ArrayList<subscription>();
        while (resultSet.next()) {
            int creator_id = resultSet.getInt("creator_id");
            int subscriber_id = resultSet.getInt("subscriber_id");
            String status = resultSet.getString("status");
            subscription s = new subscription(creator_id, subscriber_id);
            s.setStatus(status);
            subscriptionList.add(s);
        }
        return subscriptionList;
    }
}
