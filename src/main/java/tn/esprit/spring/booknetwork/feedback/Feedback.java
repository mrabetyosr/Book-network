package tn.esprit.spring.booknetwork.feedback;

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
import tn.esprit.spring.booknetwork.book.Book;
import tn.esprit.spring.booknetwork.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Feedback extends BaseEntity {


    private Double note; //1 TO 5 STARS
    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


}
