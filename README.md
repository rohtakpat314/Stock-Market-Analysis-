# Stock Market Analysis - MAANG Stocks (Java)

[![GitHub stars](https://img.shields.io/github/stars/rohtakpat314/Stock-Market-Analysis-?style=social)](https://github.com/rohtakpat314/Stock-Market-Analysis-/stargazers)

This project performs analysis on MAANG stocks (Meta, Apple, Amazon, Netflix, Google) using historical stock data from Kaggle. The goal is to compute key financial features such as **Total Growth**, **Volatility**, and **Risk-Reward metrics**.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Dataset](#dataset)
- [Installation](#installation)
- [Usage](#usage)
- [Results](#results)
- [Future Work](#future-work)
- [License](#license)

---

## Overview

This project uses historical stock price data to analyze the performance of major tech companies. By computing metrics such as **Total Growth** and **Volatility**, it allows investors and enthusiasts to understand trends and risk levels in MAANG stocks.

The project is implemented in **Java**, using CSV files as input for stock data.

---

## Features

- **Total Growth**: Measures the overall percentage change in stock price over a given period.  
- **Volatility**: Calculates the standard deviation of daily stock returns to measure risk.  
- **Risk-Reward Ratio (in progress)**: Evaluates the potential return relative to the risk for each stock.

---

## Dataset

The stock data is sourced from Kaggle. The dataset contains full historical data of MAANG stock prices since their IPO, updated daily.  

**Kaggle Link:** [MAANG Stock Prices](https://www.kaggle.com/datasets/nikhil1e9/netflix-stock-price)  

### Description

MAANG stands for Meta, Amazon, Apple, Netflix, and Google. The dataset provides daily, weekly, and monthly stock prices, automatically updated daily using data from Yahoo Finance.

### Features

- `Date`: Date of the stock price record  
- `Open`: Opening price on that day  
- `High`: Highest trading price during the day  
- `Low`: Lowest trading price during the day  
- `Close`: Closing price on that day  
- `Adj Close`: Adjusted closing price (accounts for stock splits/dividends)  
- `Volume`: Number of shares traded

### Use Cases

- **Market Analysis**: Analyze trends and seasonal patterns  
- **Investment Strategies**: Develop and backtest strategies  
- **Forecasting**: Build predictive models for future stock prices  
- **Trading Algorithms**: Test automated trading strategies

### Files Available

- `AMAZON_daily.csv`, `APPLE_daily.csv`, `GOOGLE_daily.csv`, `META_daily.csv`, `NETFLIX_daily.csv`  
- Also includes monthly and weekly CSVs for each company  

**License:** CC0: Public Domain  
**Update Frequency:** Daily

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/rohtakpat314/Stock-Market-Analysis-.git
```

2. Navigate into the project directory:

```bash
cd Stock-Market-Analysis-
```

3. Ensure **Java 11+** is installed.

---

## Usage

1. Place your Kaggle CSV files (one per stock) in the `data/` folder.  
2. Compile the Java files:

```bash
javac *.java
```

3. Run the main program (replace `Main` with your main class name):

```bash
java Main
```

4. The program outputs key metrics and optionally generates reports for each stock.

---

## Results

The program generates metrics such as:

| Stock  | Total Growth | Volatility | Risk-Reward |
|--------|--------------|------------|------------|
| Apple  | XX%          | XX         | XX         |
| Amazon | XX%          | XX         | XX         |
| Meta   | XX%          | XX         | XX         |
| Netflix| XX%          | XX         | XX         |
| Google | XX%          | XX         | XX         |

---

## Future Work

- Complete the **Risk-Reward** metric calculation  
- Add interactive visualizations using Java GUI or export to Excel/CSV for charts  
- Expand analysis to other market sectors  

---

## License

---

**Author:** Rohtak Patwardhan  
**GitHub:** [rohtakpat314](https://github.com/rohtakpat314)  
**Email:** rspatwardha2@wisc.edu
