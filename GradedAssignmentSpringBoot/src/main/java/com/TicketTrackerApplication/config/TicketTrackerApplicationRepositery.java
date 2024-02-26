package com.TicketTrackerApplication.config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TicketTrackerApplication.Model.TicketTrackerApplication; 

public interface TicketTrackerApplicationRepositery extends JpaRepository<TicketTrackerApplication, Integer>  {

}
