package BookLibrary.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

//web app that performs library functions
public class Book_LibraryLinked {

	public static LinkedList<String> bookLibrary = new LinkedList<String>();

	public static void main(String[] args) {
		//read the book list
		long startTime = System.currentTimeMillis();
		read_book_record();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Time to read book.csv: " + totalTime + " milliseconds.");
		
		//create all the books
		startTime = System.currentTimeMillis();
		createBooks();
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time to create the books: " + totalTime + " milliseconds.");
		
		//testing the linear search
		System.out.println("Testing linear search...");
		startTime = System.currentTimeMillis();
		int i;
		for (i=0; i<linkedBook.book_ids.size(); i++) {
			String book_id = "" + i;
			int j;
			for (j=0; j<linkedBook.book_ids.size(); j++) {
				if (linkedBook.book_ids.get(j).equals(book_id)) {
					//System.out.println("Book found!     " + linkedBook.titles.get(j) + " by " + linkedBook.auths.get(j));
					break;
				}
			}
		}
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time to complete the example linear search: " + totalTime + " milliseconds.");
		
		runInConsole();
	}
	

	
	//method to run the program in the console
		public static void runInConsole() {
			System.out.println();
			System.out.println();
			System.out.println("Welcome to the Library!");
			System.out.println();
			System.out.println("Please select from the following options: ");
			System.out.println("Show top 10");
			System.out.println("Search for book");
			System.out.println("Show books by author");
			System.out.println("Show books by publication year");
			System.out.println();
			System.out.println("Please type your selection");
			
			
			//pull in selection
			Scanner scnr = new Scanner(System.in);
			String choice = scnr.nextLine();
			
			//use selection to perform request
			performSelect(choice);
		}
		
		//method to perform the requested action
		public static void performSelect(String string) {
			if (string.equals("Show top 10")) {
				showTop10();
			}
			else if (string.equals("Search for book")) {
				searchbook();
			}
			else if (string.equals("Show books by author")) {
				showViaAuthor();
			}
			else if (string.equals("Show books by publication year")) {
				showViaPubYear();
			}
			else {
				System.out.println("Sorry, we do not offer that option. Please come back and try again!");
			}
		}
		
		//method to search through the books
		public static void searchbook() {
			System.out.println("What would you like to search by? ");
			System.out.println("book id");
			System.out.println("goodreads id");
			System.out.println("best book id");
			System.out.println("work id");
			System.out.println("book count");
			System.out.println("isbn");
			System.out.println("isbn13");
			System.out.println("author");
			System.out.println("publication year");
			System.out.println("original title");
			System.out.println("title");
			System.out.println("average rating");
			System.out.println("ratings count");
			System.out.println("work rating count");
			System.out.println("text review count");
			System.out.println("rating 1");
			System.out.println("rating 2");
			System.out.println("rating 3");
			System.out.println("rating 4");
			System.out.println("rating 5");
			System.out.println("image url");
			
			Scanner scnr = new Scanner(System.in);
			String choice = scnr.nextLine();
			
			if (choice.equals("book id")) {
				System.out.println("Please type the book id");
				String search = scnr.nextLine();
				searchViaBIds(search);
			}
			else if (choice.equals("goodreads id")) {
				System.out.println("Please type the goodreads id");
				String search = scnr.nextLine();
				searchViaGIds(search);
			}
			else if (choice.equals("best book id")) {
				System.out.println("Please type the best book id");
				String search = scnr.nextLine();
				searchViaBestIds(search);
			}
			else if (choice.equals("work id")) {
				System.out.println("Please type the work id");
				String search = scnr.nextLine();
				searchViaWIds(search);
			}
			else if (choice.equals("book count")) {
				System.out.println("Please type the book count");
				String search = scnr.nextLine();
				searchViaCount(search);
			}
			else if (choice.equals("isbn")) {
				System.out.println("Please type the isbn");
				String search = scnr.nextLine();
				searchViaIsbns(search);
			}
			else if (choice.equals("isbn13")) {
				System.out.println("Please type the isbn13");
				String search = scnr.nextLine();
				searchVia13s(search);
			}
			else if (choice.equals("author")) {
				System.out.println("Please type the author");
				String search = scnr.nextLine();
				searchViaAuths(search);
			}
			else if (choice.equals("publication year")) {
				System.out.println("Please type the publication year");
				String search = scnr.nextLine();
				searchViaPubYear(search);
			}
			else if (choice.equals("original title")) {
				System.out.println("Please type the original title");
				String search = scnr.nextLine();
				searchViaOTitles(search);
			}
			else if (choice.equals("title")) {
				System.out.println("Please type the title");
				String search = scnr.nextLine();
				searchViaTitles(search);
			}
			else if (choice.equals("average rating")) {
				System.out.println("Please type the average rating");
				String search = scnr.nextLine();
				searchViaAvgRatings(search);
			}
			else if (choice.equals("ratings count")) {
				System.out.println("Please type the ratings count");
				String search = scnr.nextLine();
				searchViaRatingCounts(search);
			}
			else if (choice.equals("work rating count")) {
				System.out.println("Please type the work rating count");
				String search = scnr.nextLine();
				searchViaWorkCounts(search);
			}
			else if (choice.equals("text review count")) {
				System.out.println("Please type the text review count");
				String search = scnr.nextLine();
				searchViaTextCounts(search);
			}
			else if (choice.equals("rating 1")) {
				System.out.println("Please type the rating 1");
				String search = scnr.nextLine();
				searchViaRat1(search);
			}
			else if (choice.equals("rating 2")) {
				System.out.println("Please type the rating 2");
				String search = scnr.nextLine();
				searchViaRat2(search);
			}
			else if (choice.equals("rating 3")) {
				System.out.println("Please type the rating 3");
				String search = scnr.nextLine();
				searchViaRat3(search);
			}
			else if (choice.equals("rating 4")) {
				System.out.println("Please type the rating 4");
				String search = scnr.nextLine();
				searchViaRat4(search);
			}
			else if (choice.equals("rating 5")) {
				System.out.println("Please type the rating 5");
				String search = scnr.nextLine();
				searchViaRat5(search);
			}
			else if (choice.equals("image url")) {
				System.out.println("Please type the image url");
				String search = scnr.nextLine();
				searchViaUrls(search);
			}
			else {
				System.out.println("Sorry, that is not an option. Please try again.");
				searchbook();
			}
		}
		
		//method to show the list via author
		public static void showViaAuthor() {
			System.out.println("Would you like to see the list in 'ascending' or 'descending'?");
			Scanner scnr = new Scanner(System.in);
			String choice = scnr.nextLine();
			
			if (choice.equals("ascending") ) {
				showBookByAuthAsce();
			}
			else if (choice.equals("descending")) {
				showBookByAuthDesc();
			}
			else {
				System.out.println("Sorry, that was not an option. Please try again.");
				showViaAuthor();
			}
		}
		
		//method to show the list via pub year
		public static void showViaPubYear() {
			System.out.println("Would you like to see the list in 'ascending' or 'descending'?");
			Scanner scnr = new Scanner(System.in);
			String choice = scnr.nextLine();
			
			if (choice.equals("ascending") ) {
				showBookByPubAsce();
			}
			else if (choice.equals("descending")) {
				showBookByPubDesc();
			}
			else {
				System.out.println("Sorry, that was not an option. Please try again.");
				showViaPubYear();
			}
		}
	
		//method to read the file and add all the values into one main list
		public static void read_book_record() {
			try {
				//File myObj = new File("src/BookLibrary/resources/books.csv");
				File myObj = new File("src/BookLibrary/resources/books10k.csv");
				Scanner scanner = new Scanner(myObj);
				String tempData = "";
				while (scanner.hasNext()) {
					String data = scanner.nextLine();
					tempData = "" + data;
					
					char comma = ',';
					char quote = '"';
					int i;
					String listUnit = "";
					int quotesNum = 0;
					for (i=0; i<tempData.length(); i++) {
						
						if (quotesNum>0) {
							if (tempData.charAt(i) != quote) {
								listUnit = listUnit + tempData.charAt(i);
							}
							else {
								listUnit = listUnit + tempData.charAt(i);
								quotesNum = 0;
							}
						}
						
						else if (tempData.charAt(i) == quote) {
							listUnit = listUnit + tempData.charAt(i);
							quotesNum++;
						}
						
						else if (tempData.charAt(i) != comma){
							listUnit = listUnit + tempData.charAt(i);
						}
						else {
							bookLibrary.add(listUnit);
							listUnit = "";
						}
					}
				}
			}
			
			catch (FileNotFoundException e) {
				System.out.println("An error occured.");
				e.printStackTrace();
			}
		}

	//method to distribute the values stored in bookLibrary to the correct book option.
		static int start = 22;
		public static void createBooks() {
			System.out.println("Creating books...");
			int i;
			for (i=0; i<3000; i++) { // Change this number to limit the amount of books, linked lists take significantly longer to handle larger numbers
				linkedBook book = new linkedBook();
				book.createBook(start, start+21);
				start = start + 22;
			}
		}
	
		public static void showTop10() {
			//print out the top 10 books in the csv
			System.out.println("Top 10 books:");
			System.out.println("");
			System.out.println("Title: " + linkedBook.titles.get(0) + " Author: " + linkedBook.auths.get(0));
			System.out.println("Title: " + linkedBook.titles.get(1) + " Author: " + linkedBook.auths.get(1));
			System.out.println("Title: " + linkedBook.titles.get(2) + " Author: " + linkedBook.auths.get(2));
			System.out.println("Title: " + linkedBook.titles.get(3) + " Author: " + linkedBook.auths.get(3));
			System.out.println("Title: " + linkedBook.titles.get(4) + " Author: " + linkedBook.auths.get(4));
			System.out.println("Title: " + linkedBook.titles.get(5) + " Author: " + linkedBook.auths.get(5));
			System.out.println("Title: " + linkedBook.titles.get(6) + " Author: " + linkedBook.auths.get(6));
			System.out.println("Title: " + linkedBook.titles.get(7) + " Author: " + linkedBook.auths.get(7));
			System.out.println("Title: " + linkedBook.titles.get(8) + " Author: " + linkedBook.auths.get(8));
			System.out.println("Title: " + linkedBook.titles.get(9) + " Author: " + linkedBook.auths.get(9));
		}
	
	//method to allow a user to search by book_id
	public static void searchViaBIds(String search) {
		int properIndex = search(linkedBook.book_ids, search);
		printSearchResults(properIndex);
	}
	
	//method to allow a user to search by goodread_ids
	public static void searchViaGIds(String search) {
		int properIndex = search(linkedBook.goodreads_ids, search);
		printSearchResults(properIndex);
	}
	
	//method to allow a user to search by best_ids
	public static void searchViaBestIds(String search) {
		int properIndex = search(linkedBook.best_ids, search);
		printSearchResults(properIndex);
	}
	
	//method to allow a user to search by work_ids
	public static void searchViaWIds(String search) {
		int properIndex = search(linkedBook.work_ids, search);
		printSearchResults(properIndex);
	}
	
	//method to allow a user to search by count
	public static void searchViaCount(String search) {
		int properIndex = search(linkedBook.count, search);
		printSearchResults(properIndex);
	}
	
	
	//method to allow a user to search by isbns
	public static void searchViaIsbns(String search) {
		int properIndex = search(linkedBook.isbns, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by thirteens
	public static void searchVia13s(String search) {
		int properIndex = search(linkedBook.thirteens, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by auths
	public static void searchViaAuths(String search) {
		int properIndex = search(linkedBook.auths, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by pub_year
	public static void searchViaPubYear(String search) {
		int properIndex = search(linkedBook.pub_year, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by orig_titles
	public static void searchViaOTitles(String search) {
		int properIndex = search(linkedBook.orig_titles, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by titles
	public static void searchViaTitles(String search) {
		int properIndex = search(linkedBook.titles, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by codes
	public static void searchViaCodes(String search) {
		int properIndex = search(linkedBook.codes, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by avg_ratings
	public static void searchViaAvgRatings(String search) {
		int properIndex = search(linkedBook.avg_ratings, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by ratings_counts
	public static void searchViaRatingCounts(String search) {
		int properIndex = search(linkedBook.ratings_counts, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by work_counts
	public static void searchViaWorkCounts(String search) {
		int properIndex = search(linkedBook.work_counts, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by text_reviews_counts
	public static void searchViaTextCounts(String search) {
		int properIndex = search(linkedBook.text_reviews_counts, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by rat1
	public static void searchViaRat1(String search) {
		int properIndex = search(linkedBook.rat1, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by rat2
	public static void searchViaRat2(String search) {
		int properIndex = search(linkedBook.rat2, search);
		printSearchResults(properIndex);
	}
	
	//method to allow a user to search by rat3
	public static void searchViaRat3(String search) {
		int properIndex = search(linkedBook.rat3, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by rat4
	public static void searchViaRat4(String search) {
		int properIndex = search(linkedBook.rat4, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by rat5
	public static void searchViaRat5(String search) {
		int properIndex = search(linkedBook.rat5, search);
		printSearchResults(properIndex);
	}
		
	//method to allow a user to search by urls
	public static void searchViaUrls(String search) {
		int properIndex = search(linkedBook.urls, search);
		printSearchResults(properIndex);
	}
	
	//linear search for linkedlists
	public static int search(LinkedList<String> list, String element) {
		int i; 
		int res = -1;
		for (i=0; i<list.size(); i++) {
			if (list.get(i).equals(element)) {
				res = i;
			}
		}
		return res;
	}
		
	//method to print the results of the search
	public static void printSearchResults(int index) {
		System.out.println("Searching . . . ");

		if (index>-1) {
			String title = (String) linkedBook.titles.get(index);
			String author = (String) linkedBook.auths.get(index);
			System.out.println("Book found!");
			System.out.println(title + " written by " + author);
		}
		else {
			System.out.println("No book found, please check your input and try again.");
		}
	}
	
	//prints out the list sorted be either authors or publication year in ascending or descending order
	static String tempAuth;
	static LinkedList authAsce = new LinkedList();
	public static void showBookByAuthAsce() {
		
		Collections.sort(Book.sortAuths);
		int i;
		for (i=0; i<Book.sortAuths.size(); i++) {
			tempAuth = (String) Book.sortAuths.get(i);

			int j;
			for (j = 0; j<Book.auths.size(); j++) {
				String place = (String) Book.auths.get(j);
				if (place.equals(tempAuth)) {
					if (shownBooksAAsce.contains((String) Book.titles.get(j))==false){
						String title =(String) Book.titles.get(j);
						shownBooksAAsce.add(title);
						authAsce.add(j);
						break;
					}
				}
			}
		}
	}
	
	public static LinkedList<String> shownBooksAAsce = new LinkedList<String>();
	/*public static String returnTitleAsce(int index) {
		int j;
		String title = "";
		for (j = 0; j<linkedBook.auths.size(); j++) {
			String place = (String) linkedBook.auths.get(j);
			if (place.equals(tempAuth)) {
				if (shownBooksAAsce.contains((String) linkedBook.titles.get(j))==false){
					title = title + (String) linkedBook.titles.get(j);
					shownBooksAAsce.add(title);
					break;
				}
			}
		}
		return title;
	}*/
	static LinkedList authDesc = new LinkedList();
	public static void showBookByAuthDesc() {
		Collections.sort(Book.sortAuths, Collections.reverseOrder());
		int i;
		for (i=0; i<Book.sortAuths.size(); i++) {
			tempAuth = (String) Book.sortAuths.get(i);

			int j;
			for (j = 0; j<Book.auths.size(); j++) {
				String place = (String) Book.auths.get(j);
				if (place.equals(tempAuth)) {
					if (shownBooksADesc.contains((String) Book.titles.get(j))==false){
						String title =(String) Book.titles.get(j);
						shownBooksADesc.add(title);
						authDesc.add(j);
						break;
					}
				}
			}
		}
	}
	
	public static LinkedList<String> shownBooksADesc = new LinkedList<String>();
	/*public static String returnTitleDesc(int index) {
		int j;
		String title = "";
		for (j = 0; j<linkedBook.auths.size(); j++) {
			String place = (String) linkedBook.auths.get(j);
			if (place.equals(tempAuth)) {
				if (shownBooksADesc.contains((String) linkedBook.titles.get(j))==false){
					title = title + (String) linkedBook.titles.get(j);
					shownBooksADesc.add(title);
					break;
				}
			}
		}
		return title;
	}*/
	static LinkedList pubAsce = new LinkedList();
	static String tempPubYear;
	public static void showBookByPubAsce() {
		Collections.sort(Book.sortPubYear);
		int i;
		for (i=0; i<Book.sortPubYear.size(); i++) {
			tempPubYear = (String) Book.sortPubYear.get(i);

			int j;
			for (j = 0; j<Book.pub_year.size(); j++) {
				String place = (String) Book.pub_year.get(j);
				if (place.equals(tempPubYear)) {
					if (shownBooksPubAsce.contains((String) Book.titles.get(j))==false){
						String title =(String) Book.titles.get(j);
						shownBooksPubAsce.add(title);
						pubAsce.add(j);
						break;
					}
				}
			}
		}
	}
	
	public static LinkedList<String> shownBooksPubAsce = new LinkedList<String>();
	/*public static String returnTitleAsceP(int index) {
		int j;
		String title = "";
		for (j = 0; j<linkedBook.pub_year.size(); j++) {
			String place = (String) linkedBook.pub_year.get(j);
			if (place.equals(tempPubYear)) {
				if (shownBooksPubAsce.contains((String) linkedBook.titles.get(j))==false){
					title = title + (String) linkedBook.titles.get(j);
					shownBooksPubAsce.add(title);
					break;
				}
			}
		}
		return title;
	}*/
	static LinkedList pubDesc = new LinkedList();
	public static void showBookByPubDesc() {
		Collections.sort(Book.sortPubYear, Collections.reverseOrder());
		int i;
		for (i=0; i<Book.sortPubYear.size(); i++) {
			tempPubYear = (String) Book.sortPubYear.get(i);

			int j;
			for (j = 0; j<Book.pub_year.size(); j++) {
				String place = (String) Book.pub_year.get(j);
				if (place.equals(tempPubYear)) {
					if (shownBooksPubDesc.contains((String) Book.titles.get(j))==false){
						String title =(String) Book.titles.get(j);
						shownBooksPubDesc.add(title);
						pubDesc.add(j);
						break;
					}
				}
			}
		}
	}
	
	public static LinkedList<String> shownBooksPubDesc = new LinkedList<String>();
	/*public static String returnTitleDescP(int index) {
		int j;
		String title = "";
		for (j = 0; j<linkedBook.pub_year.size(); j++) {
			String place = (String) linkedBook.pub_year.get(j);
			if (place.equals(tempPubYear)) {
				if (shownBooksPubDesc.contains((String) linkedBook.titles.get(j))==false){
					title = title + (String) linkedBook.titles.get(j);
					shownBooksPubDesc.add(title);
					break;
				}
			}
		}
		return title;
	}*/
}