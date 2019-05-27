package com.crud.tasks.trello.client;

import com.crud.tasks.config.TrelloConfig;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTest {

    @Before
    public void init() {
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        when(trelloConfig.getTrelloUsername()).thenReturn("kinga515");
    }

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrelloConfig trelloConfig;

    @Test
    public void shouldFetchTrelloBoards() throws URISyntaxException {
        //given
        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
        trelloBoards[0] = new TrelloBoardDto("test_id", "test_board", new ArrayList<>());
        URI url = new URI("http://test.com/members/kinga515/boards?key=test&token=test&fields=name,id&lists=all");

        when(restTemplate.getForObject(url, TrelloBoardDto[].class)).thenReturn(trelloBoards);

        //when
        List<TrelloBoardDto> fetchTrelloBoards = trelloClient.getTrelloBoards();

        //then
        assertEquals(1, fetchTrelloBoards.size());
        assertEquals("test_id", fetchTrelloBoards.get(0).getId());
        assertEquals("test_board", fetchTrelloBoards.get(0).getName());
        assertEquals(new ArrayList<>(), fetchTrelloBoards.get(0).getLists());
    }

    @Test
    public void shouldCreateCard() throws URISyntaxException {
        // given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "Test task",
                "Test description",
                "top",
                "test_id"
        );

        CreatedTrelloCard createdTrelloCard = new CreatedTrelloCard(
                "1",
                "Test task",
                "http://test.com"
        );

        URI uri = new URI("http://test.com/cards?key=test&token=test&name=Test%20task&desc=Test%20description&pos=top&idList=test_id");

        // when
        CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDto);
        when(restTemplate.postForObject(uri, null, CreatedTrelloCard.class)).thenReturn(createdTrelloCard);

        // then
        assertEquals("1", newCard.getId());
        assertEquals("Test task", newCard.getName());
        assertEquals("http://test.com", newCard.getShortUrl());

    }
}