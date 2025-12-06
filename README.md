# Stock Market Analysis - MAANG Stocks (Java)

Analyze MAANG stocks (Meta, Apple, Amazon, Netflix, Google) using historical stock data to compute **Total Growth**, **Volatility**, and **Risk-Reward** (in progress).  

---

## Features

- **Total Growth**: Overall percentage change in stock price  
- **Volatility**: Risk measured by standard deviation of daily returns  
- **Risk-Reward**: Potential return relative to risk (coming soon)  

---

## Dataset

Data comes from Kaggle: [MAANG Stock Prices](https://www.kaggle.com/datasets/nikhil1e9/netflix-stock-price)  

**Columns:**  
`Date`, `Open`, `High`, `Low`, `Close`, `Adj Close`, `Volume`  

**Files:** Daily, weekly, and monthly CSVs for Meta, Apple, Amazon, Netflix, Google  

**License:** CC0 (Public Domain)  
**Updated:** Daily

---

## Installation & Usage

1. Clone the repo:  
```bash
git clone https://github.com/rohtakpat314/Stock-Market-Analysis-.git
cd Stock-Market-Analysis-
```

2. Place CSV files in `data/`  
3. Compile:  
```bash
javac *.java
```
4. Run:  
```bash
java Main
```

---

## Results

Generates metrics and optionally reports for each stock:

| Stock  | Total Growth | Volatility | Risk-Reward |
|--------|--------------|------------|------------|
| Apple  | XX%          | XX         | XX         |
| Amazon | XX%          | XX         | XX         |
| Meta   | XX%          | XX         | XX         |
| Netflix| XX%          | XX         | XX         |
| Google | XX%          | XX         | XX         |

---

## Future Work

- Complete **Risk-Reward** calculation  
- Export results or visualize data in charts  

---

**Author:** Rohtak Patwardhan  
**GitHub:** [rohtakpat314](https://github.com/rohtakpat314)  
**Email:** rspatwardha2@wisc.edu
