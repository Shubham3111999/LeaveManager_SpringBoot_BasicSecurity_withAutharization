package com.CodingNinjas.LeaveXpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.exception.LeaveNotFoundException;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.repository.LeaveRepository;

@Service
public class LeaveService {
	
	@Autowired
	LeaveRepository leaveRepository;

	public LeaveModel getLeaveById(Long id) {
		LeaveModel leave=null;
		
		if(leaveRepository.findById(id).isPresent()) {
			leave=leaveRepository.findById(id).get();
		}else {
			throw new LeaveNotFoundException("Id not found");
		}
		
		return leave;
	}

	public List<LeaveModel> getAllLeave() {
		return leaveRepository.findAll();
	}

	public List<LeaveModel> getAllAcceptedLeave() {
		return leaveRepository.findAllByIsAccepted(true);
	}

	public List<LeaveModel> getAllRejectedLeave() {
		return leaveRepository.findAllByIsAccepted(false);
	}

	public Boolean getLeaveStatusById(Long id) {   ///can need to change return type
		LeaveModel leave=null;
		
		if(leaveRepository.findById(id).isPresent()) {
			leave=leaveRepository.findById(id).get();
		}else {
			throw new LeaveNotFoundException("Id not found");
		}
		return leave.isAccepted();
	}

	public LeaveModel updateLeaveById(Long id, LeaveDto updatedLeave) {
		LeaveModel leave=null;
		
		if(leaveRepository.findById(id).isPresent()) {
			leave=leaveRepository.findById(id).get();
		}else {
			throw new LeaveNotFoundException("Id not found");
		}
		
		leave.setType(updatedLeave.getType());
		leave.setStartDate(updatedLeave.getStartDate());
		leave.setEndDate(updatedLeave.getEndDate());
		leave.setDescription(updatedLeave.getDescription());
		
		
		return leaveRepository.save(leave);
	}

	public void deleteLeave(Long id) {
		leaveRepository.deleteById(id);
		
	}

	public LeaveModel createLeave(LeaveDto leaveRequest) {
		LeaveModel leave=new LeaveModel();
		
		leave.setType(leaveRequest.getType());
		leave.setStartDate(leaveRequest.getStartDate());
		leave.setEndDate(leaveRequest.getEndDate());
		leave.setDescription(leaveRequest.getDescription());
		
		return leaveRepository.save(leave);
	}

	public void approveLeave(Long id) {
		LeaveModel leave=null;
		
		if(leaveRepository.findById(id).isPresent()) {
			leave=leaveRepository.findById(id).get();
		}else {
			throw new LeaveNotFoundException("Id not found");
		}
		
		leave.setAccepted(true);
		
		leaveRepository.save(leave);
		
	}

	public void rejectLeave(Long id) {
		LeaveModel leave=null;
		
		if(leaveRepository.findById(id).isPresent()) {
			leave=leaveRepository.findById(id).get();
		}else {
			throw new LeaveNotFoundException("Id not found");
		}
		
		leave.setAccepted(false);
		
		leaveRepository.save(leave);
		
	}

}
