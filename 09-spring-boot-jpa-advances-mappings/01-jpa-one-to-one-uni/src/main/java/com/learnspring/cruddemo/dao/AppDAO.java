package com.learnspring.cruddemo.dao;

import com.learnspring.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int theId);
}
