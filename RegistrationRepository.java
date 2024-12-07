package com.klef.jfsd.ps48.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.jfsd.ps48.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
