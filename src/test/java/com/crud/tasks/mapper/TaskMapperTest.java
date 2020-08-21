package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "task", "content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals("task", task.getTitle());
        assertEquals(taskDto.getId(), task.getId());
        assertEquals("content", task.getContent());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1L, "task", "content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertNotNull(taskDto);
        assertEquals("task", taskDto.getTitle());
        assertEquals(task.getId(),taskDto.getId());
        assertEquals("content", taskDto.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "task", "content"));
        taskList.add(new Task(1L, "task2", "content2"));
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(2,taskDtoList.size());
        assertEquals(taskList.size(), taskDtoList.size());
        assertEquals(taskList.get(0).getId(), taskDtoList.get(0).getId());
        assertEquals(taskList.get(0).getTitle(), taskDtoList.get(0).getTitle());
        assertEquals(taskList.get(0).getContent(), taskDtoList.get(0).getContent());


    }
}
