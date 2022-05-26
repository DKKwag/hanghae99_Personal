package com.hanhae99.personalstudy1.controller;

import com.hanhae99.personalstudy1.domain.Board;
import com.hanhae99.personalstudy1.domain.BoardRepository;
import com.hanhae99.personalstudy1.domain.BoardRequestDto;
import com.hanhae99.personalstudy1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        return boardRepository.findAllByOrderByLastupdatedDateDesc();
    }

    @GetMapping("/api/boards/password/{id}")
    public String pwBoards(@PathVariable Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return board.getPassword();
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id,@RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }
}
