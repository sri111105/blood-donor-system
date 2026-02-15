package com.hospital.bloodapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.bloodapp.model.Donor;
import com.hospital.bloodapp.repository.DonorRepository;

@RestController
@CrossOrigin
@RequestMapping("/blood")
public class DonorController {

    private final DonorRepository donorRepository;

    public DonorController(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    // GET all donors
    @GetMapping
    public List<Donor> getDonors() {
        return donorRepository.findAll();
    }

    // POST add donor
    @PostMapping
    public Donor addDonor(@RequestBody Donor donor) {
        System.out.println("NAME RECEIVED = " + donor.getName());
        return donorRepository.save(donor);
    }

    // DELETE donor by id
    @DeleteMapping("/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorRepository.deleteById(id);
        return "Deleted";
    }
}
