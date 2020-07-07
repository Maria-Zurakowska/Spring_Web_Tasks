package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
         return trelloClient.getTrelloBoards();

//        Zadanie 22.2.3
//        trelloBoards.stream()
//                .filter(b -> b.getId() != null && b.getName() != null)
//                .filter(b -> b.getName().equals("Kodilla"))
//                .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
    }
        // POST request
        @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
        public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloClient.createNewCard(trelloCardDto);
    }
}