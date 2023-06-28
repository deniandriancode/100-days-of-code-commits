package d6;

import java.util.concurrent.*;

class FactorialSquareCalculator extends RecursiveTask<Integer> {
    private Integer n;
    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);
        calculator.fork();

        return n * n + calculator.join();
    }
}

public class Run2 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialSquareCalculator calculator = new FactorialSquareCalculator(3);
        forkJoinPool.execute(calculator);
        Integer result = calculator.join();
        System.out.println(result);
    }
}
