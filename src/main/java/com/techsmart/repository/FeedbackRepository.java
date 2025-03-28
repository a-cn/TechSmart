package com.techsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsmart.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
