package binotify.services;

import binotify.formats.*;
import binotify.dao.*;
import javax.jws.*;
import java.util.*;
import java.net.*;
import java.io.*;

@WebService
public class SubscriptionServicesImpl implements SubscriptionServices {
    private subscriptionDao subscriptionDao = new subscriptionDao();
    private loggingDao loggingDao = new loggingDao();

    @Override
    public subscription[] getSubscription(String ip, String endpoint) throws Exception {
        List<subscription> list = this.subscriptionDao.getSubscription();
        subscription[] res = new subscription[list.size()];
        for (int i = 0; i < list.size(); i++) {
            subscription s = new subscription(list.get(i).getCreator_id(), list.get(i).getSubscriber_id());
            s.setStatus(list.get(i).getStatus());
            res[i] = s;
        }
        // upload log
        log log = new log(
            "menanggapi permintaan subscription request",
            ip,
            endpoint
        );
        try {
            this.loggingDao.uploadLog(log);
        } catch (Exception e) {
            throw new Exception("Error while uploading log");
        }
        return res;



    }

    @Override
    public boolean addSubscription(String ip, String endpoint, int creator_id, int subscriber_id) {
        System.out.println("ip " + ip + " endpoint " + endpoint);
        subscription subscription = new subscription(creator_id, subscriber_id);
        boolean res = false;
        try {
            res = this.subscriptionDao.addSubscription(subscription);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // upload log
        log log = new log(
                "menanggapi request subscription",
                ip,
                endpoint
        );
        try {
            this.loggingDao.uploadLog(log);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public boolean approveSubscription(String ip, String endpoint, int creator_id, int subscriber_id) {
        System.out.println("approveSubscription creator_id " + creator_id + " subscriber_id " + subscriber_id);
        subscription subscription = new subscription(creator_id, subscriber_id);
        boolean res = false;
        try {
            res = this.subscriptionDao.approveSubscription(subscription);
            if (res) {
                String url = "http://localhost:8080/binotify-app/src/php/subscription/approve.php";
                String post_params = "creatorID=" + creator_id + "&subscriberID=" + subscriber_id;
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");

                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(post_params);
                wr.flush();
                wr.close();

                int responseCode = con.getResponseCode();
                System.out.println("POST Response Code :: " + responseCode);

                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    // print result
                    System.out.println(response.toString());
                } else {
                    System.out.println("POST request not worked");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // upload log
        log log = new log(
                "menanggapi approve subscription",
                ip,
                endpoint
        );
        try {
            this.loggingDao.uploadLog(log);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;

    }

    @Override
    public boolean rejectSubscription(String ip, String endpoint, int creator_id, int subscriber_id) {
        System.out.println("rejectSubscription creator_id " + creator_id + " subscriber_id " + subscriber_id);
        subscription subscription = new subscription(creator_id, subscriber_id);
        boolean res = false;
        try {
            res = this.subscriptionDao.rejectSubscription(subscription);
            if (res) {
                String url = "http://localhost:8080/binotify-app/src/php/subscription/reject.php";
                String post_params = "creatorID=" + creator_id + "&subscriberID=" + subscriber_id;
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");

                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(post_params);
                wr.flush();
                wr.close();

                int responseCode = con.getResponseCode();
                System.out.println("POST Response Code :: " + responseCode);

                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    // print result
                    System.out.println(response.toString());
                } else {
                    System.out.println("POST request not worked");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // upload log
        log log = new log(
                "menanggapi reject subscription",
                ip,
                endpoint
        );
        try {
            this.loggingDao.uploadLog(log);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public boolean checkSubscription(String ip, String endpoint, int creator_id, int subscriber_id) {
        subscription subscription = new subscription(creator_id, subscriber_id);
        boolean res = false;
        try {
            res = this.subscriptionDao.checkSubscription(subscription);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // upload log
        log log = new log(
                "menanggapi check subscription",
                ip,
                endpoint
        );
        try {
            this.loggingDao.uploadLog(log);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

}
