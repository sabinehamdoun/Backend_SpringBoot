package com.example.project.Converters;

import com.example.project.Entity.Employee;
import com.example.project.Entity.Leave;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LeaveMapper {
    LeaveMapper INSTANCE = Mappers.getMapper(LeaveMapper.class);
    LeaveDTO LeaveToLeaveDTO(Leave leave);
    Leave LeaveDTOToLeave(LeaveDTO leaveDto);
}
