package com.aktarulahsan.erp.core.persistence.repository;

import com.aktarulahsan.erp.core.persistence.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);

}


