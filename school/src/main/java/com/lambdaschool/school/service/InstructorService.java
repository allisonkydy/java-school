package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Instructor;

import java.util.ArrayList;

public interface InstructorService
{
  ArrayList<Instructor> findAll();

  Instructor save(Instructor instructor);

  Instructor update(Instructor instructor, long id);

  void delete(long id);
}
