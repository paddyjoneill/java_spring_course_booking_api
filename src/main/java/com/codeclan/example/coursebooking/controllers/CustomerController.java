package com.codeclan.example.coursebooking.controllers;

import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.BookingRepository.BookingRepository;
import com.codeclan.example.coursebooking.repositories.CourseRepository.CourseRepository;
import com.codeclan.example.coursebooking.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/course/{course}")
    public List<Customer> findByBookingsCourseTitle(@PathVariable String course){
        return customerRepository.findByBookingsCourseTitle(course);
    }

    @GetMapping(value = "/search/townandtitle")
    public List<Customer> findByTownAndBookingsCourseTitle(@RequestParam String town, String title){
        return customerRepository.findByTownAndBookingsCourseTitle(town, title);
    }
}
