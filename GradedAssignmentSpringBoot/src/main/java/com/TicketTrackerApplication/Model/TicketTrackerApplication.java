package com.TicketTrackerApplication.Model;


import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketTrackerApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tickettitle;
	private String ticketshortdescription;
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ticketcreated")
	private java.util.Date ticketcreated;
	private String content;

}
