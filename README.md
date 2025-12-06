# Stock Market Analysis - MAANG Stocks

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

---

## Features

The analysis computes the following metrics:

1. **Total Growth**: Measures the overall percentage change in stock price over a given period.
2. **Volatility**: Calculates the standard deviation of daily stock returns to measure risk.
3. **Risk-Reward Ratio (in progress)**: Evaluates the potential return relative to the risk for each stock.

---

## Dataset

The stock data is sourced from Kaggle. The dataset contains full historical data of MAANG stock prices since their IPO, updated daily.  

**Kaggle Link:** [MAANG Stock Prices](https://www.kaggle.com/datasets/nikhil1e9/netflix-stock-price)  

### Description

MAANG is an acronym for Meta, Amazon, Apple, Netflix, and Google. The dataset provides daily, weekly, and monthly stock prices, automatically updated daily using data from Yahoo Finance.

### Features

- `Date`: The date of the stock price record.  
- `Open`: Opening price of the stock on that day.  
- `High`: Highest trading price of the stock during the day.  
- `Low`: Lowest trading price of the stock during the day.  
- `Close`: Closing price of the stock on that day.  
- `Adj Close`: Adjusted closing price (accounts for stock splits/dividends).  
- `Volume`: Number of shares traded.

### Use Cases

- **Market Analysis**: Analyze trends, seasonal patterns, and overall market performance.  
- **Investment Strategies**: Develop and backtest investment strategies based on historical price movements.  
- **Forecasting**: Build predictive models for future stock prices.  
- **Trading Algorithms**: Design and test automated trading algorithms.

### Files Available

- `AMAZON_daily.csv`, `APPLE_daily.csv`, `GOOGLE_daily.csv`, `META_daily.csv`, `NETFLIX_daily.csv`  
- Also includes monthly and weekly CSVs for each company.  

**License:** CC0: Public Domain  
**Update Frequency:** Daily

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/yourusername/Stock-Market-Analysis.git
```

2. Navigate into the project directory:

```bash
cd Stock-Market-Analysis
```

3. Install required Python packages:

```bash
pip install -r requirements.txt
```

*(Ensure you have Python 3.x installed.)*

---

## Usage

1. Place your Kaggle CSV files (one per stock) in the `data/` folder.  
2. Run the main analysis script:

```bash
python analyze_stocks.py
```

3. The script outputs key metrics and visualizations for each stock.

---

## Results

The project generates metrics such as:

| Stock  | Total Growth | Volatility | Risk-Reward |
|--------|--------------|------------|------------|
| Apple  | XX%          | XX         | XX         |
| Amazon | XX%          | XX         | XX         |
| Meta   | XX%          | XX         | XX         |
| Netflix| XX%          | XX         | XX         |
| Google | XX%          | XX         | XX         |

Visualizations such as stock growth charts and volatility graphs are also produced for each company.

---

## Future Work

- Complete the **Risk-Reward** metric calculation.  
- Add interactive visualizations using Plotly or Dash.  
- Expand analysis to other market sectors.  

---

## License

This project is licensed under the MIT License.

---

**Author:** Rohtak Patwardhan  
**Email:** rspatwardha2@wisc.edu
