package de.hska.iwi.vislab.lab2.example;

public class FibonacciResponse {

    public FibonacciResponse() {}

    public FibonacciResponse(int n, int fibonacci) {
        this.n = n;
        this.fibonacci = fibonacci;
    }

    int n;
    int fibonacci;

    public int getN() {
        return n;
    }

    public int getFibonacci() {
        return fibonacci;
    }

    public void setFibonacci(int fibonacci) {
        this.fibonacci = fibonacci;
    }

    public void setN(int n) {
        this.n = n;
    }
}