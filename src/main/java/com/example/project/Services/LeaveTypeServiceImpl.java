package com.example.project.Services;

import com.example.project.Converters.LeaveTypeDTO;
import com.example.project.Converters.LeaveTypeMapper;
import com.example.project.Entity.LeaveType;
import com.example.project.Repositories.LeaveTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{
    private final LeaveTypeRepository leaveTypeRepository;
    private final LeaveTypeMapper leaveTypeMapper;

    public LeaveTypeServiceImpl(LeaveTypeRepository leaveTypeRepository, LeaveTypeMapper leaveTypeMapper) {
        this.leaveTypeRepository = leaveTypeRepository;
        this.leaveTypeMapper = leaveTypeMapper;
    }

    @Override
    public void newLeaveType(LeaveTypeDTO leaveTypeDTO) {
        LeaveType leaveTypeToAdd = leaveTypeMapper.LeaveTypeDTOToLeaveType(leaveTypeDTO);
        leaveTypeRepository.saveAndFlush(leaveTypeToAdd);
    }
}
