package com.dsoumaila.sendmail.repository;

import com.dsoumaila.sendmail.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository
 */
@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
}
