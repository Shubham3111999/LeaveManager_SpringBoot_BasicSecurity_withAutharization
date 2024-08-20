package com.CodingNinjas.LeaveXpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {

	@Autowired
	LeaveService leaveService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	// @PreAuthorize("hasRole('NORMAL')")
	public LeaveModel getLeaveById(@PathVariable Long id) {
		return leaveService.getLeaveById(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/all")
	// @PreAuthorize("hasRole('NORMAL')")
	public List<LeaveModel> getAllLeave() {
		return leaveService.getAllLeave();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/accepted")
	// @PreAuthorize("hasRole('NORMAL')")
	public List<LeaveModel> getAllAcceptedLeave() {
		return leaveService.getAllAcceptedLeave();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/rejected")
	// @PreAuthorize("hasRole('NORMAL')")
	public List<LeaveModel> getAllRejectedLeave() {
		return leaveService.getAllRejectedLeave();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/status/{id}")
	// @PreAuthorize("hasRole('NORMAL')")
	public Boolean  getLeaveStatusById(@PathVariable Long id) {
		return leaveService.getLeaveStatusById(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public LeaveModel updateLeaveById(@PathVariable Long id, @RequestBody LeaveDto updatedLeave) {
		return leaveService.updateLeaveById(id, updatedLeave);
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	// @PreAuthorize("hasRole('NORMAL')")
	public void deleteLeave(@PathVariable Long id) {
		leaveService.deleteLeave(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/apply")
	// @PreAuthorize("hasRole('NORMAL')")
	public LeaveModel createLeave(@RequestBody LeaveDto leaveRequest) {
		return leaveService.createLeave(leaveRequest);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/accept/{id}")
	@PreAuthorize("hasRole('MANAGER')")
	public void approveLeave(@PathVariable Long id) {
		leaveService.approveLeave(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/reject/{id}")
	@PreAuthorize("hasRole('MANAGER')")
	public void rejectLeave(@PathVariable Long id) {
		leaveService.rejectLeave(id);
	}

}
