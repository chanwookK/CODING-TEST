class StockSpanner {
    Deque<Stock> stack;

    class Stock {
        int value;
        int period;
        Stock(int value) {
            this.value = value;
            this.period = 1;
        }
    }

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        Stock current = new Stock(price);
        while (!stack.isEmpty()) {
            Stock peek = stack.peek();
            if (peek.value <= current.value) {
                current.period += peek.period;
                stack.pop();
            }
            else break;
        }
        stack.push(current);
        return current.period;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */