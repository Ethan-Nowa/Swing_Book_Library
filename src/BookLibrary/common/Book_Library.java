// To swap between the 99 csv and 10000 csv, go to read_book_record() and swap the commented file, then go to createBooks() and swap the number in the for loop
// also swap the for loop

package BookLibrary.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import BookLibrary.views.MainUI;

import java.util.ArrayList;
import java.util.Collections;

//web app that performs library functions
public class Book_Library {
	
	public static ArrayList<String> bookLibrary = new ArrayList<String>();

	
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
		
		//testing the binary search
		System.out.println("Testing binary search...");
		startTime = System.currentTimeMillis();
		int i;
		for (i=0; i<Book.book_ids.size(); i++) {
			int book_id = i;
			int tempId = binarySearch(Book.book_ids, book_id);
			if (tempId != -1) {
				int index = binarySearch(Book.book_ids, book_id);
				//System.out.println("Book found!     " + Book.titles.get(index) + " by " + Book.auths.get(index));
			}
		}
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time to complete the example linear search: " + totalTime + " milliseconds.");
		
		runInConsole();
	}
	
	static int binarySearch(ArrayList arr, int x) {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if ( Integer.parseInt((String) arr.get(m)) == x)
                return m;
 
            // If x greater, ignore left half
            if (Integer.parseInt((String) arr.get(m)) < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // If we reach here, then element was
        // not present
        return -1;
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
			searchViaBookID(search);
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
		else if (choice.equals("isbn")) {
			System.out.println("Please type the isbn");
			String search = scnr.nextLine();
			searchViaISBN(search);
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
			searchViaTitle(search);
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
			showBookByAuthorAscending();
		}
		else if (choice.equals("descending")) {
			showBookByAuthorDescending();
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
			showBookByYearAscending();
		}
		else if (choice.equals("descending")) {
			showBookByYearAscending();
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
		for (i=0; i<200; i++) { // Change this number to reduce the amount of books
			Book book = new Book();
			book.createBook(start, start+21);
			start = start + 22;
		}
	}
	
	public static void showTop10() {
		//print out the top 10 books in the csv
		System.out.println("Top 10 books:");
		System.out.println("");
		System.out.println("Title: " + Book.titles.get(0) + " Author: " + Book.auths.get(0));
		System.out.println("Title: " + Book.titles.get(1) + " Author: " + Book.auths.get(1));
		System.out.println("Title: " + Book.titles.get(2) + " Author: " + Book.auths.get(2));
		System.out.println("Title: " + Book.titles.get(3) + " Author: " + Book.auths.get(3));
		System.out.println("Title: " + Book.titles.get(4) + " Author: " + Book.auths.get(4));
		System.out.println("Title: " + Book.titles.get(5) + " Author: " + Book.auths.get(5));
		System.out.println("Title: " + Book.titles.get(6) + " Author: " + Book.auths.get(6));
		System.out.println("Title: " + Book.titles.get(7) + " Author: " + Book.auths.get(7));
		System.out.println("Title: " + Book.titles.get(8) + " Author: " + Book.auths.get(8));
		System.out.println("Title: " + Book.titles.get(9) + " Author: " + Book.auths.get(9));
	}
	
	// Ethan altered version
	//method to allow a user to search by book_id
	public static void searchViaBookID(String search) {
		for (int i = 0; i < Book.book_ids.size(); i++) {
			if (((String)Book.book_ids.get(i)).contains(search)) {
				searchResults(i);
			}
		}
	}
	
	//method to allow a user to search by goodread_ids
	public static void searchViaGIds(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.goodreads_ids.size(); i++) {
			if (search.equals((String)Book.goodreads_ids.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
	
	//method to allow a user to search by best_ids
	public static void searchViaBestIds(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.best_ids.size(); i++) {
			if (search.equals((String)Book.best_ids.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
	
	//method to allow a user to search by work_ids
	public static void searchViaWIds(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.book_ids.size(); i++) {
			if (search.equals((String)Book.book_ids.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
	
	// Ethan altered version
	//method to allow a user to search by isbns
	public static void searchViaISBN(String search) {
		for (int i = 0; i < Book.isbns.size(); i++) {
			if (((String)Book.isbns.get(i)).contains(search)) {
				searchResults(i);
			}
		}
	}
		
	//method to allow a user to search by thirteens
	public static void searchVia13s(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.thirteens.size(); i++) {
			if (search.equals((String)Book.thirteens.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by auths
	public static void searchViaAuths(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.auths.size(); i++) {
			if (search.equals((String)Book.auths.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by pub_year
	public static void searchViaPubYear(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.pub_year.size(); i++) {
			if (search.equals((String)Book.pub_year.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by orig_titles
	public static void searchViaOTitles(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.orig_titles.size(); i++) {
			if (search.equals((String)Book.orig_titles.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
	
	// Ethan altered version
	//method to allow a user to search by titles
	public static void searchViaTitle(String search) {
		String temp = search.toLowerCase();
		for (int i = 0; i < Book.titles.size(); i++) {
			if (((String)Book.titles.get(i)).toLowerCase().contains(temp)) {
				searchResults(i);
			}
		}
	}
		
	//method to allow a user to search by codes
	public static void searchViaCodes(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.codes.size(); i++) {
			if (search.equals((String)Book.codes.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by avg_ratings
	public static void searchViaAvgRatings(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.avg_ratings.size(); i++) {
			if (search.equals((String)Book.avg_ratings.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by ratings_counts
	public static void searchViaRatingCounts(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.ratings_counts.size(); i++) {
			if (search.equals((String)Book.ratings_counts.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by work_counts
	public static void searchViaWorkCounts(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.work_counts.size(); i++) {
			if (search.equals((String)Book.work_counts.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by text_reviews_counts
	public static void searchViaTextCounts(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.text_reviews_counts.size(); i++) {
			if (search.equals((String)Book.text_reviews_counts.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by rat1
	public static void searchViaRat1(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.rat1.size(); i++) {
			if (search.equals((String)Book.rat1.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by rat2
	public static void searchViaRat2(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.rat2.size(); i++) {
			if (search.equals((String)Book.rat2.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
	
	//method to allow a user to search by rat3
	public static void searchViaRat3(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.rat3.size(); i++) {
			if (search.equals((String)Book.rat3.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by rat4
	public static void searchViaRat4(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.rat4.size(); i++) {
			if (search.equals((String)Book.rat4.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by rat5
	public static void searchViaRat5(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.rat5.size(); i++) {
			if (search.equals((String)Book.rat5.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
		
	//method to allow a user to search by urls
	public static void searchViaUrls(String search) {
		int i;
		int properIndex = -1;
		for (i=0; i<Book.urls.size(); i++) {
			if (search.equals((String)Book.urls.get(i))) {
				properIndex = i;
			}
		}
		searchResults(properIndex);
	}
	
	
	// Ethan modified
	//method to print the results of the search
	public static void searchResults(int index) {
		if (index > -1) {
			//String title = (String) Book.titles.get(index); String author = (String) Book.auths.get(index); System.out.println(title + " written by " + author); //Prints result to console
			if (MainUI.panelBook[index] == null) {
				MainUI.createBook(index); // Creates the books in the UI based on the search results
				MainUI.resultCount++; // Adds to the results counter for the UI
			} else if (MainUI.panelBook[index].isVisible() == false) {
				MainUI.createBook(index); // Creates the books in the UI based on the search results
				MainUI.resultCount++; // Adds to the results counter for the UI
			}
		}
	}
	
	
	//prints out the list sorted be either authors or publication year in ascending or descending order
	static String tempAuth;
	public static ArrayList<Integer> authAsce = new ArrayList<Integer>();
	public static void showBookByAuthorAscending() {
		
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
	
	public static ArrayList<String> shownBooksAAsce = new ArrayList<String>();
	/*public static String returnTitleAsce(int index) {
		int j;
		String title = "";
		for (j = 0; j<Book.auths.size(); j++) {
			String place = (String) Book.auths.get(j);
			if (place.equals(tempAuth)) {
				if (shownBooksAAsce.contains((String) Book.titles.get(j))==false){
					title = title + (String) Book.titles.get(j);
					shownBooksAAsce.add(title);
					break;
				}
			}
		}
		return title;
	}*/
	
	public static ArrayList<Integer> authDesc = new ArrayList<Integer>();
	public static void showBookByAuthorDescending() {
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
	
	public static ArrayList<String> shownBooksADesc = new ArrayList<String>();
	/*public static String returnTitleDesc(int index) {
		int j;
		String title = "";
		for (j = 0; j<Book.auths.size(); j++) {
			String place = (String) Book.auths.get(j);
			if (place.equals(tempAuth)) {
				if (shownBooksADesc.contains((String) Book.titles.get(j))==false){
					title = title + (String) Book.titles.get(j);
					shownBooksADesc.add(title);
					break;
				}
			}
		}
		return title;
	}*/
	
	public static ArrayList<Integer> pubAsce = new ArrayList<Integer>();
	static String tempPubYear;
	public static void showBookByYearAscending() {
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
	
	public static ArrayList<String> shownBooksPubAsce = new ArrayList<String>();
	/*public static String returnTitleAsceP(int index) {
		int j;
		String title = "";
		for (j = 0; j<Book.pub_year.size(); j++) {
			String place = (String) Book.pub_year.get(j);
			if (place.equals(tempPubYear)) {
				if (shownBooksPubAsce.contains((String) Book.titles.get(j))==false){
					title = title + (String) Book.titles.get(j);
					shownBooksPubAsce.add(title);
					break;
				}
			}
		}
		return title;
	}*/
	
	public static ArrayList<Integer> pubDesc = new ArrayList<Integer>();
	public static void showBookByYearDescending() {
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
	
	public static ArrayList<String> shownBooksPubDesc = new ArrayList<String>();
	/*public static String returnTitleDescP(int index) {
		int j;
		String title = "";
		for (j = 0; j<Book.pub_year.size(); j++) {
			String place = (String) Book.pub_year.get(j);
			if (place.equals(tempPubYear)) {
				if (shownBooksPubDesc.contains((String) Book.titles.get(j))==false){
					title = title + (String) Book.titles.get(j);
					shownBooksPubDesc.add(title);
					break;
				}
			}
		}
		return title;
	}*/
}