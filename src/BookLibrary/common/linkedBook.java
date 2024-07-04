package BookLibrary.common;

//a class to represent the variables in book.csv
import java.util.LinkedList;

public class linkedBook {
	//initialize variables
	public static String book_id;
	public static String goodreads_book_id;
	public static String best_book_id;
	public static String work_id;
	public static String books_count;
	public static String isbn;
	public static String isbn13;
	public static String authors;
	public static String original_publication_year;
	public static String original_title;
	public static String title;
	public static String language_code;
	public static String average_rating;
	public static String ratings_count;
	public static String work_ratings_count;
	public static String work_text_reviews_count;
	public static String ratings_1;
	public static String ratings_2;
	public static String ratings_3;
	public static String ratings_4;
	public static String ratings_5;
	public static String image_url;
	
	//initialize searching lists
	public static LinkedList<String> book_ids = new LinkedList<String>();
	public static LinkedList<String> goodreads_ids = new LinkedList<String>();
	public static LinkedList<String> best_ids = new LinkedList<String>();
	public static LinkedList<String> work_ids = new LinkedList<String>();
	public static LinkedList<String> count = new LinkedList<String>();
	public static LinkedList<String> isbns = new LinkedList<String>();
	public static LinkedList<String> thirteens = new LinkedList<String>();
	public static LinkedList<String> auths = new LinkedList<String>();
	public static LinkedList<String> pub_year = new LinkedList<String>();
	public static LinkedList<String> orig_titles = new LinkedList<String>();
	public static LinkedList<String> titles = new LinkedList<String>();
	public static LinkedList<String> codes = new LinkedList<String>();
	public static LinkedList<String> avg_ratings = new LinkedList<String>();
	public static LinkedList<String> ratings_counts = new LinkedList<String>();
	public static LinkedList<String> work_counts = new LinkedList<String>();
	public static LinkedList<String> text_reviews_counts = new LinkedList<String>();
	public static LinkedList<String> rat1 = new LinkedList<String>();
	public static LinkedList<String> rat2 = new LinkedList<String>();
	public static LinkedList<String> rat3 = new LinkedList<String>();
	public static LinkedList<String> rat4 = new LinkedList<String>();
	public static LinkedList<String> rat5 = new LinkedList<String>();
	public static LinkedList<String> urls = new LinkedList<String>();
	
	//lists for sorting
	public static LinkedList<String> sortAuths = new LinkedList<String>();
	public static LinkedList<String> sortPubYear = new LinkedList<String>();
	
	//method to create the book
	public void createBook(int startIndex, int lastIndex) {
		
		book_id = (String) Book_LibraryLinked.bookLibrary.get(startIndex);
		goodreads_book_id = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 1);
		best_book_id = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 2);
		work_id = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 3);
		books_count = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 4);
		isbn = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 5);
		isbn13 = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 6);
		authors = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 7);
		original_publication_year = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 8);
		original_title = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 9);
		title = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 10);
		language_code = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 11);
		average_rating = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 12);
		ratings_count = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 13);
		work_ratings_count = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 14);
		work_text_reviews_count = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 15);
		ratings_1 = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 16);
		ratings_2 = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 17);
		ratings_3 = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 18);
		ratings_4 = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 19);
		ratings_5 = (String) Book_LibraryLinked.bookLibrary.get(startIndex + 20);
		image_url = (String) Book_LibraryLinked.bookLibrary.get(lastIndex);
		prepareSearchLists();
	}
	
	public void prepareSearchLists() {
		book_ids.add(book_id);
		goodreads_ids.add(goodreads_book_id);
		best_ids.add(best_book_id);
		work_ids.add(work_id);
		count.add(books_count);
		isbns.add(isbn);
		thirteens.add(isbn13);
		auths.add(authors);
		sortAuths.add(authors);
		pub_year.add(original_publication_year);
		sortPubYear.add(original_publication_year);
		orig_titles.add(original_title);
		titles.add(title);
		codes.add(language_code);
		avg_ratings.add(average_rating);
		ratings_counts.add(ratings_count);
		work_counts.add(work_ratings_count);
		text_reviews_counts.add(work_text_reviews_count);
		rat1.add(ratings_1);
		rat2.add(ratings_2);
		rat3.add(ratings_3);
		rat4.add(ratings_4);
		rat5.add(ratings_5);
		urls.add(image_url);

	}
}
