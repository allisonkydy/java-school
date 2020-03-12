package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/instructors")
public class InstructorController
{
  @Autowired
  private InstructorService instructorService;

  @GetMapping(value = "/instructors",
              produces = {"application/json"})
  public ResponseEntity<?> listAllInstructors()
  {
    return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
  }

  @PostMapping(value = "/instructor",
               consumes = {"application/json"})
  public ResponseEntity<?> addInstructor(@Valid
                                         @RequestBody Instructor instructor)
  {
    instructorService.save(instructor);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(value = "/instructor/{instructid}",
              consumes = {"application/json"})
  public ResponseEntity<?> editInstructor(@RequestBody Instructor instructor,
                                          @PathVariable long instructid)
  {
    instructorService.update(instructor, instructid);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/instructor/{instructid}")
  public ResponseEntity<?> deleteInstructor(@PathVariable long instructid)
  {
    instructorService.delete(instructid);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
