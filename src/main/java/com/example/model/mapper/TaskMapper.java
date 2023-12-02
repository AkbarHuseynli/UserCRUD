package com.example.model.mapper;

import com.example.model.dto.TaskDTO;
import com.example.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TaskMapper {
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "deadline", source = "deadline")
    Task taskDTOtoTask(TaskDTO taskDTO);
}
