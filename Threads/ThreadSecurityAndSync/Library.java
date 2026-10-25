package ThreadSecurityAndSync;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Library {

    private final Map<String, Book> books = new HashMap<>();

    public Library() {
        books.put("Book1", new Book("Book1", 10));
        books.put("Book2", new Book("Book2", 5));
        books.put("Book3", new Book("Book3", 8));
    }

    public void rent(String studentName, String bookName) {
        Book book = books.get(bookName);
        if (book != null) {
            book.rent(studentName);
        } else {
            System.out.println("Book " + bookName + " does not exist in the library.");
        }
    }

    private static class Book {
        private final String title;
        private int copies;
        private final Lock lock = new ReentrantLock(true);

        public Book(String title, int initialCopies) {
            this.title = title;
            this.copies = initialCopies;
        }

        public void rent(String studentName) {
            boolean lockAcquired = false;
            int retries = 0;
            int maxRetries = 5; // Increase retries
            int retryDelay = 500;

            while (retries < maxRetries && copies > 0) {
                try {
                    lockAcquired = lock.tryLock(2, TimeUnit.SECONDS);
                    if (lockAcquired) {
                        if (copies > 0) {
                            System.out.println(studentName + " is borrowing " + title + ".");
                            copies--;  // Decrease the number of available copies
                            System.out.println("Books left: " + copies + " for " + title + " borrowed by: " + studentName);
                            Thread.sleep(1000);  // Simulate time taken to borrow a book
                            break;  // Exit the loop after successful borrow
                        } else {
                            System.out.println("No copies available for " + title + " for " + studentName + " to borrow.");
                            break;
                        }
                    } else {
                        System.out.println(studentName + " Retrying to borrow " + title + "...");
                        retries++;
                        Thread.sleep(retryDelay);  // Delay before retrying
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                } finally {
                    if (lockAcquired) {
                        lock.unlock();
                    }
                }
            }
        }
    }
}