package de.hska.iwi.vislab.lab2.example;

public class FibonacciResponse {

    public FibonacciResponse(int n, int fibonacci) {
        this.n = n;
        this.fibonacci = fibonacci;
    }

    int n;
    int fibonacci;

    @Override
    public String toString() {
        return "{" +
                    "\"n\":" + n + "," +
                    "\"fibonacci\":" + fibonacci +
                "}";
    }
}