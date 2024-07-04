// Book Library
// A GUI application to show library book details as read from a file.


// Division of work:
// Ethan Nowaczyk developed the classes contained in the .views package
// Phelix Brooks developed the classes contained in the .common package with minor adjustments from Ethan to allow it to function with MainUI.java




// Currently the program will search through ID, Title, and ISBN, and output the books containing what the user has entered into the search bar.

// The sorting options are separate from the search feature, they do not work in tandem

// See the screenshots in the .zip to see runtime differences between linear and binary search
	// It seems that the amount of linkedlists simply cannot handle the large amount of data while arraylists can easily handle it



// The GUI takes absurdly long to load large book counts, so it's not recommended to use too many books
// to change this, go to createBooks() in Book_Library.java and change the for loop number



//////////////////////////////////////////////////////////////////////////////
// This class initializes the program and UI elements.
//////////////////////////////////////////////////////////////////////////////

package BookLibrary.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookLibrary.common.Book;
import BookLibrary.common.Book_Library;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

/**
 * This class initializes the program and UI elements.
 * Date:   September 13, 2023
 * @author Ethan Nowaczyk
 * @version 1.0
 */
public class MainUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int resultCount = 0;
	
	private JPanel contentPane;
	private JPanel bodyPanel;
	private static JPanel panelBookList;
	private static JScrollPane scrollPane;
	private JTextField txtSearch;
	private static JLabel resultsFoundLabel;
	
	// Book components, increase 99 to something higher if more books will be added
	public static JPanel panelBook[] = new JPanel[10000];
	private static JLabel labelImageBook[] = new JLabel[10000];
	private static JPanel panelRatingMenu[] = new JPanel[10000];
	private static JButton buttonTotalRatings[] = new JButton[10000];
	private static JButton buttonCloseRatingMenu[] = new JButton[10000];
	private static JTextArea textAreaRatings[] = new JTextArea[10000];
	private static JLabel labelTitle[] = new JLabel[10000];
	private static JLabel labelAuthorDate[] = new JLabel[10000];
	private static JLabel labelBookID[] = new JLabel[10000];
	private static JLabel labelLanguage[] = new JLabel[10000];
	private static JLabel labelISBN[] = new JLabel[10000];
	private static JLabel labelISBN13[] = new JLabel[10000];


	/**
	 * Launch the application.
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Runs the primary functions required for the game to start.
	 */
	public MainUI() {
		createMain();
		//read the book list
		Book_Library.read_book_record();
		//create all the books
		Book_Library.createBooks();
		
		for (int i = 0; i < 10; i++) { createBook(i); } //Creates the visuals for the first 10 books.

		addPlaceholderStyle(txtSearch);

		// This sets the initial scroll bar position to the top
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() { 
               scrollPane.getVerticalScrollBar().setValue(0);
           }
        });
	}
	
	/**
	 * Creates the main UI elements of the application.
	 */
	public void createMain() {
		// Main pane
		setTitle("BookLibrary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1520, 1020);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		//////////////////////////////////////////////////////////////////////////////////////////
		// Header Panel
		//////////////////////////////////////////////////////////////////////////////////////////
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		headerPanel.setBounds(0, 0, 1520, 70);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblBookLibrary = new JLabel("Book Library");
		lblBookLibrary.setForeground(new Color(0, 128, 255));
		lblBookLibrary.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBookLibrary.setBounds(10, 11, 290, 48);
		headerPanel.add(lblBookLibrary);
		//////////////////////////////////////////////////////////////////////////////////////////
		
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(250, 250, 250));
		bodyPanel.setBounds(0, 70, 1504, 912);
		bodyPanel.setLayout(null);
		contentPane.add(bodyPanel);
		
		panelBookList = new JPanel();
		panelBookList.setBackground(new Color(250, 250, 250));
		//panelBookList.setLayout(null);
		panelBookList.setLayout(new BoxLayout(panelBookList, BoxLayout.Y_AXIS));
		
		UIManager.put("ScrollBar.width", 40);
        scrollPane = new JScrollPane(panelBookList);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBounds(0, 80, 1504, 832);
        bodyPanel.add(scrollPane);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////
		// Search Panel
		//////////////////////////////////////////////////////////////////////////////////////////
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 255), new Color(0, 128, 255), new Color(0, 128, 255), new Color(0, 128, 255)));
		searchPanel.setBackground(new Color(255, 255, 255));
		searchPanel.setBounds(10, 10, 500, 40);
		bodyPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
		resultsFoundLabel = new JLabel("10 results found");
		resultsFoundLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultsFoundLabel.setBounds(520, 10, 130, 40);
		bodyPanel.add(resultsFoundLabel);
		
		// This is the button to confirm search
		JButton searchButton = new JButton("");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < panelBook.length; i++) {
					if (panelBook[i] != null) {
						panelBook[i].setVisible(false);
					}
				}
				Book_Library.searchViaBookID(txtSearch.getText().toLowerCase());
				Book_Library.searchViaTitle(txtSearch.getText().toLowerCase());
				Book_Library.searchViaISBN(txtSearch.getText().toLowerCase());
				resultsFoundLabel.setText(resultCount+" results found");
				resultCount = 0;
				// This sets the initial scroll bar position to the top
		        javax.swing.SwingUtilities.invokeLater(new Runnable() {
		           public void run() { 
		               scrollPane.getVerticalScrollBar().setValue(0);
		           }
		        });
			}
		});
		searchButton.setFocusPainted(false);
		searchButton.setContentAreaFilled(true);
		searchButton.setBorderPainted(false);
		searchButton.setBackground(new Color(0, 128, 255));
		searchButton.setBounds(428, 0, 72, 40);
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon searchIcon = new ImageIcon(MainUI.class.getResource("/BookLibrary/resources/magnifying-glass-search-icon.png"));
		Image image = searchIcon.getImage().getScaledInstance(72, 40, Image.SCALE_DEFAULT);
		searchIcon = new ImageIcon(image);
		searchButton.setIcon(searchIcon);
		searchPanel.add(searchButton);
		
		// This is the text field where users enter what they want to search
		txtSearch = new JTextField();
		txtSearch.setBounds(0, 0, 428, 40);
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearch.getText().equals("search")) {
					txtSearch.setText(null);
					txtSearch.requestFocus();
					removePlaceholderStyle(txtSearch);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearch.getText().length()==0) {
					txtSearch.setText("search");
					addPlaceholderStyle(txtSearch);
				}
			}
		});
		txtSearch.setText("search");
		txtSearch.setToolTipText("");
		txtSearch.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtSearch.setOpaque(false);
		txtSearch.setBackground(null);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSearch.setColumns(10);
		searchPanel.add(txtSearch);
		//////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////
		// Combo Boxes
		//////////////////////////////////////////////////////////////////////////////////////////
		
		// Sort Type (ID, Publication Year, etc.)
		final JComboBox<Object> comboBoxSortType = new JComboBox<Object>();
		comboBoxSortType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSortType.setModel(new DefaultComboBoxModel<Object>(new String[] {"Book ID", "Author", "Original Publication Year"}));
		comboBoxSortType.setBounds(679, 10, 300, 40);
		bodyPanel.add(comboBoxSortType);
		
		// Sort Order (Ascending/Descending)
		final JComboBox<Object> comboBoxSortOrder = new JComboBox<Object>();
		comboBoxSortOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSortOrder.setModel(new DefaultComboBoxModel<Object>(new String[] {"Ascending", "Descending"}));
		comboBoxSortOrder.setBounds(1020, 10, 130, 40);
		bodyPanel.add(comboBoxSortOrder);
		
		
		comboBoxSortOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Book ID
				if (comboBoxSortType.getSelectedItem() == "Book ID" && comboBoxSortOrder.getSelectedItem() == "Ascending") {
					sort("Book ID", "Ascending");
				} else if (comboBoxSortType.getSelectedItem() == "Book ID" && comboBoxSortOrder.getSelectedItem() == "Descending") {
					sort("Book ID", "Descending");
				}
				
				// Author
				if (comboBoxSortType.getSelectedItem() == "Author" && comboBoxSortOrder.getSelectedItem() == "Ascending") {
					sort("Author", "Ascending");
				} else if (comboBoxSortType.getSelectedItem() == "Author" && comboBoxSortOrder.getSelectedItem() == "Descending") {
					sort("Author", "Descending");
				}
				
				// Year
				if (comboBoxSortType.getSelectedItem() == "Original Publication Year" && comboBoxSortOrder.getSelectedItem() == "Ascending") {
					sort("Original Publication Year", "Ascending");
				} else if (comboBoxSortType.getSelectedItem() == "Original Publication Year" && comboBoxSortOrder.getSelectedItem() == "Descending") {
					sort("Original Publication Year", "Descending");
				}
			}
		});
		
		comboBoxSortType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Book ID
				if (comboBoxSortType.getSelectedItem() == "Book ID" && comboBoxSortOrder.getSelectedItem() == "Ascending") {
					sort("Book ID", "Ascending");
				} else if (comboBoxSortType.getSelectedItem() == "Book ID" && comboBoxSortOrder.getSelectedItem() == "Descending") {
					sort("Book ID", "Descending");
				}
				
				// Author
				if (comboBoxSortType.getSelectedItem() == "Author" && comboBoxSortOrder.getSelectedItem() == "Ascending") {
					sort("Author", "Ascending");
				} else if (comboBoxSortType.getSelectedItem() == "Author" && comboBoxSortOrder.getSelectedItem() == "Descending") {
					sort("Author", "Descending");
				}
				
				// Year
				if (comboBoxSortType.getSelectedItem() == "Original Publication Year" && comboBoxSortOrder.getSelectedItem() == "Ascending") {
					sort("Original Publication Year", "Ascending");
				} else if (comboBoxSortType.getSelectedItem() == "Original Publication Year" && comboBoxSortOrder.getSelectedItem() == "Descending") {
					sort("Original Publication Year", "Descending");
				}
			}
		});
		//////////////////////////////////////////////////////////////////////////////////////////
	}
	
	
	// Function that is performed in the combo box selections
	private static void sort(String type, String order) {
		// First hide current books
		for (int i = 0; i < panelBook.length; i++) {
			if (panelBook[i] != null) {
				panelBook[i].setVisible(false);
			}
		}
		resultsFoundLabel.setText(Book.book_ids.size()+" results found");
		
		// Book ID
		if (type == "Book ID" && order == "Ascending") {
			for (int i = 0; i < Book.book_ids.size(); i++) { createBook(i); } //Creates the visuals for all of the books.
		} else if (type == "Book ID" && order == "Descending") {
			for (int i = Book.book_ids.size()-1; i >= 0; i--) { createBook(i); } //Creates the visuals for all of the books.
		}
		
		// Author
		if (type == "Author" && order == "Ascending") {
			// Then perform the sort
			Book_Library.showBookByAuthorAscending(); // Sort by Author Ascending
			// Then create the books
			for (int i = 0; i < Book_Library.authAsce.size(); i++) {
				createBook((int) Book_Library.authAsce.get(i));
			}
		} else if (type == "Author" && order == "Descending") {
			// Then perform the sort
			Book_Library.showBookByAuthorDescending(); // Sort by Author Descending
			// Then create the books
			for (int i = 0; i < Book_Library.authDesc.size(); i++) {
				createBook((int) Book_Library.authDesc.get(i));
			}
		}
		
		// Year
		if (type == "Original Publication Year" && order == "Ascending") {
			// Then perform the sort
			Book_Library.showBookByYearAscending(); // Sort by Year Ascending
			// Then create the books
			for (int i = 0; i < Book_Library.pubAsce.size(); i++) {
				createBook((int) Book_Library.pubAsce.get(i));
			}
		} else if (type == "Original Publication Year" && order == "Descending") {
			// Then perform the sort
			Book_Library.showBookByYearDescending(); // Sort by Year Descending
			// Then create the books
			for (int i = 0; i < Book_Library.pubDesc.size(); i++) {
				createBook((int) Book_Library.pubDesc.get(i));
			}
		}
		
		// This sets the initial scroll bar position to the top
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() { 
               scrollPane.getVerticalScrollBar().setValue(0);
           }
        });
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	// Book Panel Creation
	//////////////////////////////////////////////////////////////////////////////////////////
	// This function creates a panel with all of the information for each book
	public static void createBook(final int bookNum) {
		// First set panel size for the scroll bar (when using null layout)
		//panelBookList.setPreferredSize(new Dimension(1504, (220*(bookNum+1))));
		
		// Book panel ///////////////////////////////////////////////////////////////////////
		panelBook[bookNum] = new JPanel();
		//panelBook[bookNum].setBounds(10, 0+(200*(bookNum))+(20*(bookNum)), 1400, 200); //x,y,width,height  // Use this when using null layout
		panelBook[bookNum].setPreferredSize(new Dimension(1400, 200)); // Use this when not using null layout
		panelBook[bookNum].setBackground(new Color(255, 255, 255));
		panelBook[bookNum].setBorder(new LineBorder(new Color(240, 240, 240)));
		panelBook[bookNum].setLayout(null);
		panelBookList.add(panelBook[bookNum]);
		/////////////////////////////////////////////////////////////////////////////////////
		
		// Book Image ///////////////////////////////////////////////////////////////////////
		labelImageBook[bookNum] = new JLabel("");
		labelImageBook[bookNum].setBackground(new Color(192, 192, 192));
		labelImageBook[bookNum].setHorizontalAlignment(SwingConstants.CENTER);
		labelImageBook[bookNum].setBounds(0, 0, 300, 200);
		panelBook[bookNum].add(labelImageBook[bookNum]);
		URL url = null;
		try {
			url = new URL(Book.urls.get(bookNum));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon bookIcon = new ImageIcon(url);
		Image image = bookIcon.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT);
		bookIcon = new ImageIcon(image);
		labelImageBook[bookNum].setIcon(bookIcon);
		/////////////////////////////////////////////////////////////////////////////////////
		
		// Rating Menu //////////////////////////////////////////////////////////////////////
		panelRatingMenu[bookNum] = new JPanel();
		panelRatingMenu[bookNum].setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelRatingMenu[bookNum].setVisible(false);
		panelRatingMenu[bookNum].setBounds(310, 0, 300, 200);
		panelBook[bookNum].add(panelRatingMenu[bookNum]);
		panelRatingMenu[bookNum].setLayout(null);
		
		buttonTotalRatings[bookNum] = new JButton(Book.work_counts.get(bookNum));
		buttonTotalRatings[bookNum].setForeground(new Color(0, 128, 255));
		buttonTotalRatings[bookNum].setHorizontalAlignment(SwingConstants.LEFT);
		buttonTotalRatings[bookNum].setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonTotalRatings[bookNum].setFocusPainted(false);
		buttonTotalRatings[bookNum].setContentAreaFilled(true);
		buttonTotalRatings[bookNum].setBorderPainted(false);
		buttonTotalRatings[bookNum].setBackground(null);
		buttonTotalRatings[bookNum].setBounds(410, 68, 100, 30);
		buttonTotalRatings[bookNum].setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonTotalRatings[bookNum].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pulls up a menu showing the exact amount of each of the 5 ratings
				panelRatingMenu[bookNum].setVisible(true);
				buttonTotalRatings[bookNum].setVisible(false);
			}
		});
		panelBook[bookNum].add(buttonTotalRatings[bookNum]);
		
		buttonCloseRatingMenu[bookNum] = new JButton("X");
		buttonCloseRatingMenu[bookNum].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRatingMenu[bookNum].setVisible(false);
				buttonTotalRatings[bookNum].setVisible(true);
			}
		});
		buttonCloseRatingMenu[bookNum].setFont(new Font("Verdana", Font.BOLD, 11));
		buttonCloseRatingMenu[bookNum].setMargin(new Insets(0, 0, 0, 0));
		buttonCloseRatingMenu[bookNum].setBounds(275, 0, 25, 25);
		panelRatingMenu[bookNum].add(buttonCloseRatingMenu[bookNum]);
		
		textAreaRatings[bookNum] = new JTextArea();
		textAreaRatings[bookNum].setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaRatings[bookNum].setText(Book.avg_ratings.get(bookNum)+" out of 5\r\n"+Book.work_counts.get(bookNum)+" total ratings\r\n\r\n1 star:\t     "+Book.rat1.get(bookNum)+"\r\n2 star:\t     "+Book.rat2.get(bookNum)+"\r\n3 star:\t     "+Book.rat3.get(bookNum)+"\r\n4 star:\t     "+Book.rat4.get(bookNum)+"\r\n5 star:\t     "+Book.rat5.get(bookNum)+"");
		textAreaRatings[bookNum].setAutoscrolls(false);
		textAreaRatings[bookNum].setEditable(false);
		textAreaRatings[bookNum].setBackground(null);
		textAreaRatings[bookNum].setBounds(20, 11, 250, 178);
		panelRatingMenu[bookNum].add(textAreaRatings[bookNum]);
		/////////////////////////////////////////////////////////////////////////////////////
		
		// Title
		labelTitle[bookNum] = new JLabel(Book.titles.get(bookNum));
		labelTitle[bookNum].setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTitle[bookNum].setBounds(310, 11, 1000, 30);
		panelBook[bookNum].add(labelTitle[bookNum]);
		
		// Author & Date
		labelAuthorDate[bookNum] = new JLabel("by "+Book.auths.get(bookNum)+"     |     "+Book.pub_year.get(bookNum));
		labelAuthorDate[bookNum].setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAuthorDate[bookNum].setBounds(310, 39, 1000, 30);
		panelBook[bookNum].add(labelAuthorDate[bookNum]);
		
		// Book ID
		labelBookID[bookNum] = new JLabel("ID: "+Book.book_ids.get(bookNum));
		labelBookID[bookNum].setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelBookID[bookNum].setBounds(1344, 0, 2000, 30);
		panelBook[bookNum].add(labelBookID[bookNum]);
		
		// Language
		labelLanguage[bookNum] = new JLabel("Language:   "+Book.codes.get(bookNum));
		labelLanguage[bookNum].setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLanguage[bookNum].setBounds(820, 69, 500, 30);
		panelBook[bookNum].add(labelLanguage[bookNum]);
		
		// ISBN
		labelISBN[bookNum] = new JLabel("ISBN:         "+Book.isbns.get(bookNum));
		labelISBN[bookNum].setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelISBN[bookNum].setBounds(820, 99, 500, 30);
		panelBook[bookNum].add(labelISBN[bookNum]);
		
		// ISBN 13    [there seems to be an issue with the data in the csv file, the isbn-13s are missing the final digit and it's been replaced with a zero]
		labelISBN13[bookNum] = new JLabel("ISBN-13:     "+Book.thirteens.get(bookNum));
		labelISBN13[bookNum].setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelISBN13[bookNum].setBounds(820, 129, 500, 30);
		panelBook[bookNum].add(labelISBN13[bookNum]);
		

		// This was the beginning to the rating icons which would display a visual to represent the average rating of the book
		// However, it would simply take too long to fully implement it, so it is here as a concept and is not fully implemented
		JPanel panelRatingIcons;
		JLabel ratingLabel[] = new JLabel[6];
		
		panelRatingIcons = new JPanel();
		panelRatingIcons.setBounds(310, 68, 100, 30);
		panelRatingIcons.setBackground(new Color(255, 255, 255));
		panelRatingIcons.setLayout(new GridLayout(1, 5));
		panelBook[bookNum].add(panelRatingIcons);
		
		ImageIcon ratingIcon = new ImageIcon(MainUI.class.getResource("/BookLibrary/resources/heart15x15.png"));
		Image ratingimage = ratingIcon.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		ratingIcon = new ImageIcon(ratingimage);
		
		int i = 1;
		while (i < 6) {
			ratingLabel[i] = new JLabel();
			ratingLabel[i].setIcon(ratingIcon);
			panelRatingIcons.add(ratingLabel[i]);
			i++;
		}
		//
	}
	
	// These add/remove the placeholder text style to the search text field
	public void addPlaceholderStyle(JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.ITALIC);
		textField.setFont(font);
		textField.setForeground(Color.gray);
	}
	
	public void removePlaceholderStyle(JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.PLAIN);
		textField.setFont(font);
		textField.setForeground(Color.black);
	}
}
