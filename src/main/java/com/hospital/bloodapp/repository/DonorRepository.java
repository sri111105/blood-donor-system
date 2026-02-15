package com.hospital.bloodapp.repository;

import com.hospital.bloodapp.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {
}
