package tn.esprit.spring.booknetwork.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.booknetwork.book.Book;

import java.util.List;
import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Integer> {

    @Query("""
            select history
            from  BookTransactionHistory history
            where history.user.id = :userId 
""")
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Integer userId);



    @Query("""
            select history
            from  BookTransactionHistory history
            where history.book.owner.id = :userId 
""")
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Integer userId);


    @Query("""
            SELECT 
            (count(*) > 0) AS isBorrowed
            FROM BookTransactionHistory bookTransactionHistory
            WHERE bookTransactionHistory.user.id = :userId
            AND bookTransactionHistory.book.id = :bookId  
            AND bookTransactionHistory.returnApproved =false 
            """)
    boolean isAlreadyBorrowedByUser(Integer bookId, Integer userId);

    @Query("""
         SELECT transaction
         FROM BookTransactionHistory  transaction
         WHERE transaction.user.id= :userId
         AND transaction.book.id = :bookId
         AND transaction.returnApproved = false
""")
   Optional<BookTransactionHistory> findByBookIdAndUserId(Integer bookId, Integer userId);


    @Query("""
         SELECT transaction
         FROM BookTransactionHistory  transaction
         WHERE transaction.book.owner.id= :userId
         AND transaction.book.id = :bookId
          AND transaction.returned = true
         AND transaction.returnApproved = false
""")
    Optional<BookTransactionHistory> findByBookIdAndOwnerId(Integer bookId, Integer userId);
}
