package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
 @Autowired
 private StudentRepository repository;
 public void save(Student student) {
  repository.save(student);
 }
 
//public Long CountStudent() {
// return StudentRepository.CountStudent();
//}
 
// public int nbrSmi() {
//	 return StudentRepository.nbrSmi();
// }
 
//    public List<CountFiliere> listByFiliere() {
//	 return StudentRepository.listByFiliere();
// }
 
//public List<CountSession1> listBySession1() {
//return StudentRepository.listBySession1();
//}
 
//public List<CountSession2> listBySession2() {
//return StudentRepository.listBySession2();
//}
 
//public List<CountSession3> listBySession3() {
//return StudentRepository.listBySession3();
//}

//public List<CountSession4> listBySession4() {
//return StudentRepository.listBySession4();
//}

//public List<CountSession5> listBySession5() {
//return StudentRepository.listBySession5();
//}

//public List<CountSession6> listBySession6() {
//return StudentRepository.listBySession6();
//}
 
 
//public List<Student> findByOrderByNoteAsc() {
//return StudentRepository.findByOrderByNoteAsc();
//}
 
//public List<Student> findByOrderByNoteDesc() {
//return StudentRepository.findByOrderByNoteDesc();
//}
 

}