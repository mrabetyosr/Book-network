package tn.esprit.spring.booknetwork.history;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tn.esprit.spring.booknetwork.book.Book;
import tn.esprit.spring.booknetwork.common.BaseEntity;
import tn.esprit.spring.booknetwork.user.User;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BookTransactionHistory extends BaseEntity {

    //user relationship
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    //book relationship
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    private boolean returned;
    private boolean returnApproved;

}
