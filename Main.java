/**
 * Stock Analysis Tool
 * 
 * This program loads historical stock data from CSV files for several companies
 * and allows the user to analyze growth and volatility between two dates via
 * a terminal interface.
 * 
 * Bugs: none known
 * 
 * @author Rohtak Patwardhan
 * @version Fall 2025
 * @Project Stock Analysis Tool
 * @contact rspatwardha2@wisc.edu
 * @citation AI: helped with code suggestions and Java I/O formatting
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class implements a simple Stock Analysis Tool for terminal use.
 * Users can select a stock and analyze its growth and volatility
 * between two dates using historical stock price data from CSV files.
 * Bugs: none known
 * 
 * @author Rohtak Patwardhan
 */
public class Main {

    /**
     * Main method that loads stock data, initializes the application,
     * and runs the main user input loop for analysis.
     * 
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {

        // Load stocks
        Stock amazon = CSVLoader.loadStock("AMZN", "AMAZON_daily.csv");
        Stock google = CSVLoader.loadStock("GOOGL", "GOOGLE_daily.csv");
        Stock apple = CSVLoader.loadStock("AAPL", "APPLE_daily.csv");
        Stock meta = CSVLoader.loadStock("META", "META_daily.csv");
        Stock netflix = CSVLoader.loadStock("NFLX", "NETFLIX_daily.csv");

        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(amazon);
        stocks.add(google);
        stocks.add(apple);
        stocks.add(meta);
        stocks.add(netflix);

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Stock Analysis Tool ===");

        while (true) {

            System.out.println("\nAvailable stocks:");
            for (Stock s : stocks) {
                System.out.print(s.getSymbol() + " ");
            }

            System.out.print("\n\nEnter stock symbol (or EXIT): ");
            String symbol = sc.nextLine().trim().toUpperCase();

            if (symbol.equals("EXIT")) {
                System.out.println("Goodbye!");
                break;
            }

            Stock selected = null;
            for (Stock s : stocks) {
                if (s.getSymbol().equals(symbol)) {
                    selected = s;
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Invalid stock symbol.");
                continue;
            }

            try {
                System.out.print("Enter start date (YYYY-MM-DD): ");
                LocalDate start = LocalDate.parse(sc.nextLine());

                System.out.print("Enter end date (YYYY-MM-DD): ");
                LocalDate end = LocalDate.parse(sc.nextLine());

                System.out.println("\nChoose analysis:");
                System.out.println("1. Total Growth");
                System.out.println("2. Volatility");
                System.out.println("3. Both");

                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 1 || choice == 3) {
                    double g = selected.growthBetween(start, end);
                    System.out.printf("Growth: %.2f%%\n", g * 100);
                }

                if (choice == 2 || choice == 3) {
                    double v = selected.volatilityBetween(start, end);
                    System.out.printf("Volatility: %.2f%%\n", v * 100);
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        sc.close();
    }
}

/* ======================= STOCK ======================= */

/**
 * Represents a stock with a symbol and a history of price records.
 * Provides methods to calculate growth and volatility over a date range.
 */
class Stock {

    private final String symbol;
    private final ArrayList<PriceRecord> history;

    /**
     * Constructs a Stock object with the given symbol.
     * 
     * @param symbol the stock symbol (e.g., "AAPL")
     */
    public Stock(String symbol) {
        this.symbol = symbol;
        this.history = new ArrayList<>();
    }

    /**
     * Returns the stock symbol.
     * 
     * @return the stock symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Adds a price record to the stock's history.
     * 
     * @param record the price record to add
     */
    public void addRecord(PriceRecord record) {
        history.add(record);
    }

    /**
     * Filters price records between two dates (inclusive).
     * 
     * @param start the start date
     * @param end   the end date
     * @return an ArrayList of PriceRecord objects within the date range
     */
    private ArrayList<PriceRecord> recordsBetween(LocalDate start, LocalDate end) {
        ArrayList<PriceRecord> filtered = new ArrayList<>();
        for (PriceRecord r : history) {
            if (!r.getDate().isBefore(start) && !r.getDate().isAfter(end)) {
                filtered.add(r);
            }
        }
        return filtered;
    }

    /**
     * Calculates total growth between two dates.
     * Growth is defined as (endPrice - startPrice) / startPrice.
     * 
     * @param start the start date
     * @param end   the end date
     * @return the growth as a decimal (e.g., 0.05 for 5%)
     */
    public double growthBetween(LocalDate start, LocalDate end) {
        ArrayList<PriceRecord> data = recordsBetween(start, end);
        if (data.size() < 2) return 0.0;

        double startPrice = data.get(0).getClose();
        double endPrice = data.get(data.size() - 1).getClose();
        return (endPrice - startPrice) / startPrice;
    }

    /**
     * Calculates volatility (standard deviation of daily returns) between two dates.
     * 
     * @param start the start date
     * @param end   the end date
     * @return the volatility as a decimal
     */
    public double volatilityBetween(LocalDate start, LocalDate end) {
        ArrayList<PriceRecord> data = recordsBetween(start, end);
        if (data.size() < 2) return 0.0;

        int n = data.size();
        double sum = 0.0;

        for (int i = 1; i < n; i++) {
            sum += data.get(i).dailyReturn(data.get(i - 1));
        }

        double mean = sum / (n - 1);
        double variance = 0.0;

        for (int i = 1; i < n; i++) {
            double r = data.get(i).dailyReturn(data.get(i - 1));
            variance += Math.pow(r - mean, 2);
        }

        return Math.sqrt(variance / (n - 1));
    }
}

/* ======================= PRICE RECORD ======================= */

/**
 * Represents a single price record for a stock, including the date and closing price.
 */
class PriceRecord {

    private final LocalDate date;
    private final double close;

    /**
     * Constructs a PriceRecord object.
     * 
     * @param date  the date of the record
     * @param close the closing price
     */
    public PriceRecord(LocalDate date, double close) {
        this.date = date;
        this.close = close;
    }

    /**
     * Returns the date of the price record.
     * 
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the closing price of the stock for this record.
     * 
     * @return the closing price
     */
    public double getClose() {
        return close;
    }

    /**
     * Calculates the daily return relative to a previous PriceRecord.
     * 
     * @param prev the previous price record
     * @return the daily return as a decimal
     */
    public double dailyReturn(PriceRecord prev) {
        return (this.close - prev.close) / prev.close;
    }
}

/* ======================= CSV LOADER ======================= */

/**
 * Utility class to load stock data from CSV files.
 */
class CSVLoader {

    /**
     * Loads stock data from a CSV file.
     * Assumes the file has a header row, with the date in column 0 and closing
     * price in column 4.
     * 
     * @param symbol   the stock symbol
     * @param filename the CSV file name
     * @return a Stock object with all loaded PriceRecords
     */
    public static Stock loadStock(String symbol, String filename) {

        Stock stock = new Stock(symbol);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                LocalDate date = LocalDate.parse(parts[0]);
                double close = Double.parseDouble(parts[4]);

                stock.addRecord(new PriceRecord(date, close));
            }

        } catch (IOException e) {
            System.out.println("Error reading " + filename);
        }

        return stock;
    }
}
