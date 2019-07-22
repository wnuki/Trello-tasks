package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1.1", "testList", false);
        List<TrelloListDto> listDto = Arrays.asList(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1","testBoard",  listDto);
        List<TrelloBoardDto> boardDto = Arrays.asList(trelloBoardDto);

        //When
        List<TrelloBoard> mappedList = trelloMapper.mapToBoards(boardDto);

        //Then
        assertEquals(boardDto.get(0).getId(), mappedList.get(0).getId());
        assertEquals(boardDto.get(0).getName(), mappedList.get(0).getName());
        assertEquals(boardDto.get(0).getLists().get(0).getId(),
                mappedList.get(0).getLists().get(0).getId());
        assertEquals(boardDto.get(0).getLists().get(0).getName(),
                mappedList.get(0).getLists().get(0).getName());
        assertEquals(boardDto.get(0).getLists().get(0).isClosed(),
                mappedList.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("1.1", "testList", false);
        List<TrelloList> list = Arrays.asList(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("1", "test", list);
        List<TrelloBoard> board = Arrays.asList(trelloBoard);

        //When
        List<TrelloBoardDto> mappedList = trelloMapper.mapToBoardsDto(board);

        //Then
        assertEquals(board.get(0).getId(), mappedList.get(0).getId());
        assertEquals(board.get(0).getName(), mappedList.get(0).getName());
        assertEquals(board.get(0).getLists().get(0).getId(),
                mappedList.get(0).getLists().get(0).getId());
        assertEquals(board.get(0).getLists().get(0).getName(),
                mappedList.get(0).getLists().get(0).getName());
        assertEquals(board.get(0).getLists().get(0).isClosed(),
                mappedList.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void mapToListTest() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1.1", "testList", false);
        List<TrelloListDto> listDto = Arrays.asList(trelloListDto);

        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(listDto);

        //Then
        assertEquals(listDto.get(0).getId(), mappedList.get(0).getId());
        assertEquals(listDto.get(0).getName(), mappedList.get(0).getName());
        assertEquals(listDto.get(0).isClosed(), mappedList.get(0).isClosed());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("1.1", "testList", false);
        List<TrelloList> list = Arrays.asList(trelloList);

        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(list);

        //Then
        assertEquals(list.get(0).getId(), mappedList.get(0).getId());
        assertEquals(list.get(0).getName(), mappedList.get(0).getName());
        assertEquals(list.get(0).isClosed(), mappedList.get(0).isClosed());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card", "description", "pos", "2.0");

        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCardDto.getName(), mappedCard.getName());
        assertEquals(trelloCardDto.getDescription(), mappedCard.getDescription());
        assertEquals(trelloCardDto.getPos(), mappedCard.getPos());
        assertEquals(trelloCardDto.getListId(), mappedCard.getListId());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card", "description", "pos", "2.0");

        //When
        TrelloCardDto mappedCard = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCard.getName(), mappedCard.getName());
        assertEquals(trelloCard.getDescription(), mappedCard.getDescription());
        assertEquals(trelloCard.getPos(), mappedCard.getPos());
        assertEquals(trelloCard.getListId(), mappedCard.getListId());
    }
}