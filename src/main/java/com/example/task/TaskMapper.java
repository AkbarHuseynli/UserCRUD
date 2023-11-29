package com.example.task;

import com.example.appuser.AppUser;
import com.example.appuser.AppUserDTO;
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
