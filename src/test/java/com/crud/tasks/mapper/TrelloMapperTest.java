package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.service.TrelloService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @Mock
    TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void shouldMapToBoards() {
        //Given
        List<TrelloListDto> list = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "trelloBoardDto", list);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);
        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(trelloBoardDtos);
        //Then
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1", result.get(0).getId());
        Assert.assertEquals("trelloBoardDto", result.get(0).getName());
        Assert.assertEquals(0, result.get(0).getLists().size());
    }




}