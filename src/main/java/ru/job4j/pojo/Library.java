package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Head First Java", 500);
        books[1] = new Book("Thinking in Java", 1000);
        books[2] = new Book("Java The Complete Reference", 1500);
        books[3] = new Book("Clean code", 400);
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getTitle() + " - " + book.getPageCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getTitle() + " - " + book.getPageCount());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getTitle())) {
                System.out.println(book.getTitle() + " - " + book.getPageCount());
            }
        }
    }
}

