package com.revature.daos;

import com.revature.pojos.Request;
import com.revature.services.DatasourceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RequestDAO implements DatasourceCRUD<Request>{

    Connection connection;

    public RequestDAO() {
        this.connection = DatasourceService.getConnection();
    }

    public RequestDAO(Connection connection) {


    }


    @Override
    public void create(Request request) {
        try {
            String sql = "INSERT INTO Request (Request_type, Status, Refund_total, Request_Id, user_id) VALUES(?, 'false', ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, request.getRequest_type());
            pstmt.setBoolean(3, request.getStatus());
            pstmt.setInt(2, request.getRefund_total());
            pstmt.setInt(3, request.getRequest_Id());
            pstmt.setInt(3, request.getuser_Id());


            pstmt.executeUpdate();
            System.out.println("Request has been submitted");

            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()) {
                Integer key = keys.getInt("user_id");
                Request.setuser_Id(key);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    @Override
    public Request read(int id) {
        Request request = new Request();
        try {
            String sql = "SELECT * FROM Request WHERE Request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet results = pstmt.executeQuery();

            if(results.next()) {
                Request.setRequest_type((results.getInt("Request_type")));
                Request.setStatus(results.getString("Status"));
                Request.setRefund_total(results.getString("Refund_total"));
                Request.setRequest_Id(results.getInt("Request_Id"));
                Request.setuser_Id(results.getBoolean("user_Id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return request;

    }

    @Override
    public List<Request> readAll() {
        List<Request> RequestList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Request";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while(results.next()) {
                Request Request = new Request();
                Request.setRequest_type(results.getString("Request_type"));
                Request.setStatus(results.getBoolean("Status"));
                Request.setRefund_total(results.getInt("Refund_total"));
                Request.setRequest_Id(results.getInt("Request_Id"));
                Request.setuser_Id(results.getInt("user_Id"));
                RequestList.add(Request);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RequestList;
    }


    @Override
    public void update(Request Request) {
        try {
            String sql = "UPDATE Request SET STATUS = ?, Refund_total = ?, Request_type = ?, user_Id = ? WHERE Request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setBoolean(1, Request.getStatus());
            pstmt.setInt(2, Request.getRefund_total());
            pstmt.setString(3, Request.getRequest_type());
            pstmt.setInt(4, Request.getuser_Id());
            pstmt.setInt(5, Request.getRequest_Id());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM Request WHERE Request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement((sql));

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
