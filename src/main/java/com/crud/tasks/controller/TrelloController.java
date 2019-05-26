package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @GetMapping(path = "/boards")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoardDtos = trelloClient.getTrelloBoards();
        trelloBoardDtos.stream()
                .filter(t -> t.getName().contains("Application"))
                .forEach(t -> System.out.println(t.getId() + " " + t.getName()));
    }
}
