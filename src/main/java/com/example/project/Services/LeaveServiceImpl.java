package com.example.project.Services;

import com.example.project.Converters.LeaveDTO;
import com.example.project.Converters.LeaveMapper;
import com.example.project.Entity.Leave;
import com.example.project.Repositories.LeaveRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveServiceImpl implements LeaveService{

    private LeaveRepository leaveRepository;
    private LeaveMapper leaveMapper;

    public LeaveServiceImpl(LeaveRepository leaveRepository, LeaveMapper leaveMapper) {
        this.leaveRepository = leaveRepository;
        this.leaveMapper = leaveMapper;
    }

    @Override
    public List<LeaveDTO> getAll() {
        List<LeaveDTO> leaves = leaveRepository.findAll().stream().map( leave -> {
            LeaveDTO leaveDto = leaveMapper.LeaveToLeaveDTO(leave);
            return leaveDto;
        }).collect(Collectors.toList());

        return leaves;
    }

    @Override
    public void submitLeave(LeaveDTO leaveDTO) {
        Leave leaveToSubmit = leaveMapper.LeaveDTOToLeave(leaveDTO);
        leaveRepository.saveAndFlush(leaveToSubmit);
    }

    @Override
    public Page<Leave> getLeavesByEmployeeAndLeaveType(int employeeId, String leaveType, Pageable pageable) {
        return leaveRepository.findByEmployeeIdAndLeaveTypeOrderById(employeeId, leaveType, pageable);
    }

    public List<Leave> getLeavesByRangeDate(Date fromDate, Date toDate){
        return leaveRepository.findLeavesByFromDateAndToDate(fromDate, toDate);
    }

    @Override
    public List<Leave> getLeavesByLeaveType(String leaveType) {
        return leaveRepository.findByLeaveType(leaveType);
    }




}
