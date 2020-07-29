package com.viber.scheduler.dao;

import com.viber.scheduler.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao extends JpaRepository<Job, Long> {
}
