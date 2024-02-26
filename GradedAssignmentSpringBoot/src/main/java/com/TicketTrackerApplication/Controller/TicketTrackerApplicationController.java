package com.TicketTrackerApplication.Controller;


import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TicketTrackerApplication.Model.TicketTrackerApplication;
import com.TicketTrackerApplication.config.TicketTrackerApplicationService;

@Controller
public class TicketTrackerApplicationController {

	@Autowired
	TicketTrackerApplicationService service;

	@RequestMapping("/")
	public String showAllTickets(Model data) {
		List<TicketTrackerApplication> tApplications = service.getAll();
		data.addAttribute("tApplications", tApplications);
		return "showAllTickets";
	}

	@RequestMapping("/add-record")
	public String addRecord() {
		return "Add-Form";
	}

	@PostMapping("/saveTicketsForm")
	public String saveTicketsForm(@RequestParam String tickettitle, @RequestParam String ticketshortdescription,
			@RequestParam String content, Model data) {
		service.insert(TicketTrackerApplication.builder().tickettitle(tickettitle)
				.ticketshortdescription(ticketshortdescription).content(content).build());
		List<TicketTrackerApplication> tApplications = service.getAll();
		data.addAttribute("tApplications", tApplications);
		return "showAllTickets";
	}

	@GetMapping("/delete-ticket")
	public String deleteTicket(Model data, @RequestParam int Id) {
		service.delete(new TicketTrackerApplication(Id, null, null, null, null));
		List<TicketTrackerApplication> tApplications = service.getAll();
		data.addAttribute("tApplications", tApplications);
		return "showAllTickets";

	}

	@GetMapping("/update-ticket")
	public String updateticket(int Id, Model data) {

		TicketTrackerApplication ticketTrackerApplication = service.updateById(Id);
		if (ticketTrackerApplication != null) {
			data.addAttribute("t1", ticketTrackerApplication);
			return "update-ticket-form";
		} else {
			List<TicketTrackerApplication> lb = service.getAll();
			data.addAttribute("lb", lb);
 
			return "show-allLb"; 

		}
	}

	@PostMapping("/update-save")
	public String ipdateSaveTicketsForm(@RequestParam int id, @RequestParam String tickettitle,
			@RequestParam String ticketshortdescription, @RequestParam String content,
			 Model data) {
		 TicketTrackerApplication t1=service.getById(id); 
		 Date date = t1.getTicketcreated();
		service.insert(new TicketTrackerApplication(id, tickettitle, ticketshortdescription, date, content));
		List<TicketTrackerApplication> tApplications = service.getAll();
		data.addAttribute("tApplications", tApplications);
		return "showAllTickets";
	}

	@GetMapping("/view")
	public String view(int Id, Model data) {

		TicketTrackerApplication ticketTrackerApplication = service.updateById(Id);
		if (ticketTrackerApplication != null) {
			data.addAttribute("t1", ticketTrackerApplication);
			return "view-form";
		} else {
			List<TicketTrackerApplication> lb = service.getAll();
			data.addAttribute("lb", lb);

			return "show-allLb";

		}
	}

	@RequestMapping("/search")
	public String search(@RequestParam String  search, Model data) {

		List<TicketTrackerApplication> tList= service.filter(search); 
		/* TicketTrackerApplication tList=service.getById(search); */ 
		data.addAttribute("tList", tList);
		return "Show-serach-form";
	}

}
