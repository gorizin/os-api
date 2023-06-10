package com.igor.os.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.os.domain.OS;


public interface OSRepository extends JpaRepository<OS, Integer> {

}
