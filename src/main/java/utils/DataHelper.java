package utils;

import entity.Author;
import models.post.SavingNewAuthorRq;
import models.post.SavingNewAuthorRs;
import models.post.SavingNewBookRq;
import models.post.SavingNewBookRs;
import steps.requestSteps.RequestSender;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class DataHelper {

    public static Author getRegisteredAuthor() {
        String firstName = randomAlphabetic(10, 50);
        String familyName = randomAlphabetic(10, 50);
        String secondName = randomAlphabetic(10, 50);
        long id = RequestSender.postAuthorResponse(new SavingNewAuthorRq(firstName, familyName, secondName))
                .as(SavingNewAuthorRs.class).getAuthorId();

        return new Author(id, firstName, familyName, secondName);
    }

    public static String getBookTitle() {

        return randomAlphabetic(10, 50);
    }

    public static long getIdRegisteredBook(Author author, String bookTitle) {
        SavingNewBookRq request = new SavingNewBookRq(bookTitle, author);
        SavingNewBookRs response = RequestSender.postBookResponse(request).as(SavingNewBookRs.class);

        return response.getBookId();
    }

    public static Author getUnregisteredAuthor() {
        Author author = new Author();
        author.setId(getRegisteredAuthor().getId() + 100);

        return author;
    }
}
