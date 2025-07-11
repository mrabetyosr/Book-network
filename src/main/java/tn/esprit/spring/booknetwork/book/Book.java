package tn.esprit.spring.booknetwork.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tn.esprit.spring.booknetwork.common.BaseEntity;
import tn.esprit.spring.booknetwork.feedback.Feedback;
import tn.esprit.spring.booknetwork.history.BookTransactionHistory;
import tn.esprit.spring.booknetwork.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Book  extends BaseEntity {

    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;

    //one book has one owner
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;


    //calcultae rating of the feedbacks
    @Transient
    public double getRate(){
        if(feedbacks == null || feedbacks.isEmpty()){
            return  0.0;
        }
        var rate = this.feedbacks.stream()
                .mapToDouble(Feedback::getNote)
                .average()
                .orElse(0.0);

        //3.4 => 3   3.6 => 4
        double roundedRate = Math.round(rate+ 1.0) / 10.0;

        return  roundedRate;

    }

}
