package com.revature.services;
import com.revature.daos.RequestDAO;
import com.revature.pojos.Request;

import java.util.List;
public class RequestServices {
    private RequestDAO dao;

    public RequestServices() {
        this.dao = new RequestDAO();
    }

    public void saveRequests(Request request) {
        dao.create(request);
    }

    public Request getRequest(int id) {
        return dao.read(id);
    }

    public List<Request> getAllRequest() {
        return dao.readAll();
    }

    public void updateRequests(Request request) {
        dao.update(request);
    }

    public void deleteRequests(int id) {
        dao.delete(id);
    }
}