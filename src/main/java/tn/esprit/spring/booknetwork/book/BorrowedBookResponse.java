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
public class BorrowedBookResponse {

    private Integer id ;
    private String title;
    private  String authorName;
    private String isbn;
    private double rate; //moyenne de feedback
    private boolean returned;
    private boolean returnApproved;
}
