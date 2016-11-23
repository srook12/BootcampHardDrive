package ssa;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Stock {
	private String symbol;
	private String name;
	private int numShares;
	private double purchasePrice;
	private double currPrice;
	private Date dateBought;
	private Date dateSold;
	
	public static final String SPLIT_ERROR1 = "Error - you must use positive values for the ";
	public static final String SPLIT_TO = " to ";
	public static final String SPLIT_FROM = " from ";
	public static final String SPLIT_ERROR2 = " value when splitting!";
	public static final String NUM_SHARES_ERROR = "Number of shares must be greater than 0!";
	public static final String PRICE_ERROR = "Price must be at least 0!";
	
	public static final String DATE_FORMAT = "MM/dd/yyyy";
	public static final String MONEY_FORMAT = "#,##0.00";
	//                                              Sym\Name\Shrs\Cost\Price\Value\Gain-Loss\Bought\Sold
	public static final String STOCK_LINE_FORMAT = "%-3s   %-20s   %-6d   $%6s   $%6s   $%10s   $%10s   %-10s   %-10s\n";
	public static final String SUCCESS = "Success";
	
	// To buy a stock, we need its symbol, name, the number of shares, the purchase
	// price, and the date the stock was bought. The current price will be initialized
	// to the purchase price.
	public Stock(String symbol, String name, int numShares, 
			double purchasePrice, String dateBought) {
		setSymbol(symbol);
		setName(name);
		setNumShares(numShares);
		
		setPurchasePrice(purchasePrice);
		setCurrPrice(purchasePrice);	
		setDateBought(stringAsDate(dateBought));		
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public int getNumShares() {
		return numShares;
	}
	
	public void setNumShares(int numShares) {
		if(numShares > 0) {
			this.numShares = numShares;
		} else {
			System.out.println(NUM_SHARES_ERROR);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		if(purchasePrice >= 0) {
			this.purchasePrice = purchasePrice;
		} else {
			System.out.println(PRICE_ERROR);
		}
	}

	public double getCurrPrice() {
		return currPrice;
	}

	public void setCurrPrice(double currPrice) {
		if(currPrice >= 0) {
			this.currPrice = currPrice;
		} else {
			System.out.println(PRICE_ERROR);
		}
	}

	public Date getDateBought() {
		return dateBought;
	}
	
	public void setDateBought(Date dateBought) {
		this.dateBought = dateBought;
	}
	
	public Date getDateSold() {
		return dateSold;
	}
	
	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}
	
	// Turn a mm/dd/yyyy representation into a date
	public Date stringAsDate(String dateString) {
		DateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
		Date date = new Date();
		try {
			date = dateFormatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	// Format either the date bought or date sold as a string. Used for
	// displaying dates in a report
	public String dateAsString(Date date) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
		
		return dateFormatter.format(date);
	}
	
	// Return the number of days the stock has been held
	public int calcNumDaysStockHeld(Date date) {
		// Have to admit that I borrowed this line
		return (int) ChronoUnit.DAYS.between(dateBought.toInstant(), date.toInstant());
	}
	
	// Calculates the current value of the stock based on the number of shares owned
	// and the current price
	public double calcStockValue() {
		return numShares * currPrice;
	}
	
	// Calculates the net profit of the stock reflected by the purchase price and the
	// current price. If the current price > purchase price, the net profit will be
	// positive. If the current price < purchase price, the net profit will be negative.
	// If the current price == purchase price, the net profit will be 0.
	public double calcNet() {
		return (currPrice - purchasePrice) * numShares;
	}
	
	// Splits a stock's number of shares and price per share dependent on a
	// ratio supplied by the user in the form to / from. For example, a 2-->1 split for
	// 100 shares of stock selling at $10 per share would result in 200 shares of stock
	// selling for $5 a share
	public String split(int to, int from) {
		// Holds the message generated for the result of the call
		StringBuffer sb = new StringBuffer();
		
		if(to <= 0) {
			sb.append(SPLIT_ERROR1 + SPLIT_TO + SPLIT_ERROR2);
		} else if(from <= 0) {
			sb.append(SPLIT_ERROR1 + SPLIT_FROM + SPLIT_ERROR2);
		} else {
			double ratio = (to * 1.0) / from;
			
			setNumShares((int) (getNumShares() * ratio));
			setPurchasePrice(getPurchasePrice() / ratio);
			setCurrPrice(getCurrPrice() / ratio);
			sb.append(SUCCESS);
		}
		
		return sb.toString();
	}
	
	// Print the stock in the format desired by the user
	public String print() {
		StringBuffer sb = new StringBuffer();
		DecimalFormat formatter = new DecimalFormat(MONEY_FORMAT);
		
		String soldDateString = dateSold == null ? " " : dateAsString(getDateSold());
		
		sb.append(String.format(STOCK_LINE_FORMAT, getSymbol(), 
												   getName(),
												   getNumShares(),
												   formatter.format(getPurchasePrice()),
												   formatter.format(getCurrPrice()),
												   formatter.format(calcStockValue()),
												   formatter.format(calcNet()),
												   dateAsString(getDateBought()),
												   soldDateString));		
		return sb.toString();
	}
}
