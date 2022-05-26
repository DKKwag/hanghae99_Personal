package com.hanhae99.personalstudy1.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Board extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;


    public Board(String subject, String username, String password, String contents) {
        this.subject = subject;
        this.username = username;
        this.password = password;
        this.contents = contents;
    }

    public Board(BoardRequestDto requestDto){
        this.subject = requestDto.getSubject();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    public void update(BoardRequestDto requestDto){
        this.subject = requestDto.getSubject();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }
}
