package com.andres.alianzabe.repository;

import com.andres.alianzabe.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


//    @Query("select u from User u where u.documentNumber = :documentNumber and u.documentType = :documentType and u.documentIssueDate = :documentIssueDate")
//    User findUser(@Param("documentNumber") String documentNumber, @Param("documentType") String documentType, @Param("documentIssueDate") LocalDate documentIssueDate);

}
