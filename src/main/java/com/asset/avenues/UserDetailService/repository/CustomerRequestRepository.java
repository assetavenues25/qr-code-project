package com.asset.avenues.UserDetailService.repository;

import com.asset.avenues.UserDetailService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRequestRepository extends JpaRepository<User, Long> {

}
