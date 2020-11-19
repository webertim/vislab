package de.hska.iwi.vislab.lab1.example.ws;

import javax.jws.WebService;

@WebService
public interface FibonacciService {

    public int getFibonacci(int n);

    public int next();

    public void restore();
}