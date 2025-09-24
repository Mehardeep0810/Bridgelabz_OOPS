

class Book{
    String Title = "Java Programming";
    int PublicationYear = 2025;

}
class Author extends Book{
    String name = "Mehar";
    String bio = "An experienced Java developer and author.";
    public void displayAuthorInfo(){
        System.out.println("Book Title: " + Title);
        System.out.println("Publication Year: " + PublicationYear);
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }

}
public class LibraryManagement {
    public static void main(String [] args){
        Author author = new Author();
        author.displayAuthorInfo();
    }
}


