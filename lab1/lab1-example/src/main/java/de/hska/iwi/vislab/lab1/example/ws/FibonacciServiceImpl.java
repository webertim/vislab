package de.hska.iwi.vislab.lab1.example.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "de.hska.iwi.vislab.lab1.example.ws.FibonacciService")
public class FibonacciServiceImpl implements FibonacciService {

    private int n = 0;

    @Override
    public int getFibonacci(int n) {
        return fibonacci(n);
    }

    @Override
    public int next() {
        n++;
        return fibonacci(n);
    }

    @Override
    public void restore() {
        n = 0;
    }

    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}