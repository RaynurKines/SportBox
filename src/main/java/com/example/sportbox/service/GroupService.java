package com.example.sportbox.service;

import com.example.sportbox.dao.GroupDao;
import com.example.sportbox.dao.StudentDao;
import com.example.sportbox.model.Group;
import com.example.sportbox.model.Result;
import com.example.sportbox.model.Student;

import java.util.List;

public class GroupService {
    private GroupDao groupDao = new GroupDao();

    public GroupService() {
    }

    public Group findGroup(int id) {
        return groupDao.findById(id);
    }

    public Group findGroupByName(String name) {return groupDao.findByName(name);}

    public void saveGroup(Group group) {
        groupDao.save(group);
    }

    public void deleteGroup(Group group) {
        groupDao.delete(group);
    }

    public void updateGroup(Group group) {
        groupDao.update(group);
    }

    public List<Group> findAllGroups() {
        return groupDao.findAll();
    }

}
