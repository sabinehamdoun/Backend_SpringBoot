package com.example.project.Converters;

import com.example.project.Entity.LeaveType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LeaveTypeMapper {
    LeaveTypeMapper INSTANCE = Mappers.getMapper(LeaveTypeMapper.class);
    LeaveTypeDTO LeaveTypeToLeaveTypeDTO(LeaveType leaveType);
    LeaveType LeaveTypeDTOToLeaveType(LeaveTypeDTO leaveTypeDTO);
}
