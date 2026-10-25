package ThreadSecurityAndSync;

public class Student extends Thread {
    
    private final Library library;
    private final String name;
    private final String bookName;

    public Student(Library library, String name, String bookName) {
        this.library = library;
        this.name = name;
        this.bookName = bookName;
    }

    @Override
    public void run() {
        library.rent(name, bookName);
    }

    public static void main(String[] args) {
        Library library = new Library();

        Runnable task = () -> {
            String[] students = {"Alice", "Bob", "Charlie", "Diana"};
            String[] books = {"Book1", "Book2", "Book3"};
            for (int i = 0; i < 4; i++) {
                new Student(library, students[i], books[i % books.length]).start();
            }
        };

        // Run the task in two separate threads
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}