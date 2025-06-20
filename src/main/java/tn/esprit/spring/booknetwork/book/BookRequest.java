package tn.esprit.spring.booknetwork.book;

import jakarta.validation.constraints.NotNull;

public record BookRequest(
        Integer id,
        @NotNull(message = "100")
        @NotNull(message = "100")
        String title,
        @NotNull(message = "101")
        @NotNull(message = "101")
        String authorname,
        @NotNull(message = "102")
        @NotNull(message = "102")
        String isbn,
        @NotNull(message = "103")
        @NotNull(message = "103")
        String synopsis,
        boolean shareable
) {

}
