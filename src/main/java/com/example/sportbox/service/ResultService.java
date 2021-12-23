package com.example.sportbox.service;

import com.example.sportbox.dao.ResultDao;
import com.example.sportbox.model.Result;

import java.util.List;

public class ResultService {
    private ResultDao resultDao = new ResultDao();

    public ResultService() {
    }

    public Result findGroup(int id) {
        return resultDao.findById(id);
    }

    public void saveGroup(Result result) {
        resultDao.save(result);
    }

    public void deleteGroup(Result result) {
        resultDao.delete(result);
    }

    public void updateGroup(Result result) {
        resultDao.update(result);
    }

    public List<Result> findAllGroups() {
        return resultDao.findAll();
    }
}
