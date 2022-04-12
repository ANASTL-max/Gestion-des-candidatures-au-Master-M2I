package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	 

	
	//activer/désactiver les candidatures
//    @Modifying
//    @Query("update student a set a.activer=true where a.id=?1")
//    public void ActiverById(Long id);

//    @Modifying
//    @Query("update student a set a.activer=false where a.id=?1")
//    public void DesactiverById(Long id);
	
	
	//Voir les nombres des candidats
//	  @Query("Select COUNT(*) from student a ")
//	  public Long CountStudent();
	 
	//graphe pour les filières des candidats
//    @Query("select  count(*) from student a where a.filiere='smi'")
//    int nbrSmi();
	
	

//	@Query("Select new CountFiliere(a.filiere,Count(a)/(select count(*) from student)*100 from student a Group by a.filiere")
//	List<CountFiliere> listByFiliere();
		
	
	//graphe pour les différents session des semestres
//	@Query("Select new CountSession1(a.s1session,Count(a)/(select count(*) from student)*100 from student a Group by a.s1session")
//	List<CountSession1> listBySession1();

//	@Query("Select new CountSession2(a.s2session,Count(a)/(select count(*) from student)*100 from student a Group by a.s2session")
//	List<CountSession2> listBySession2();
	
//	@Query("Select new CountSession3(a.s3session,Count(a)/(select count(*) from student)*100 from student a Group by a.s3session")
//	List<CountSession3> listBySession3();
	
//	@Query("Select new CountSession4(a.s4session,Count(a)/(select count(*) from student)*100 from student a Group by a.s4session")
//	List<CountSession4> listBySession4();
	
//	@Query("Select new CountSession5(a.s5session,Count(a)/(select count(*) from student)*100 from student a Group by a.s5session")
//	List<CountSession5> listBySession5();
	
//	@Query("Select new CountSession6(a.s6session,Count(a)/(select count(*) from student)*100 from student a Group by a.s6session")
//	List<CountSession6> listBySession6();

	
//	@Query("SELECT * FROM Student GROUP BY filiere order by note Asc")
//	List <Student> findByOrderByNoteAsc();
//	@Query("SELECT * FROM Student GROUP BY filiere order by note Desc")
//	List <Student> findByOrderByNoteDesc();
	
	
//	@Query("SELECT * FROM Student GROUP BY universite order by note Asc")
//	List <Student> findByOrderByNoteAsc();
//	@Query("SELECT * FROM Student GROUP BY universite order by note Desc")
//	List <Student> findByOrderByNoteDesc();
	
	
//	@Query("SELECT * FROM Student GROUP BY faculte order by note Asc")
//	List <Student> findByOrderByNoteAsc();
//	@Query("SELECT * FROM Student GROUP BY faculte order by note Desc")
//	List <Student> findByOrderByNoteDesc();
	

	
}