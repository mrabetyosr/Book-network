package tn.esprit.spring.booknetwork.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {

    private Integer id ;
    private String title;
    private  String authorName;
    private String  synopsis;
    private String isbn;
    private String owner;
    private byte[] cover ;
    private double rate; //moyenne de feedback
    private boolean archived;
    private boolean shareable;
}
