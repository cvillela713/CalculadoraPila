package com.NewCalculadora.PilasC;

import java.util.LinkedList;

public class PilaT<T> {
    private LinkedList<T> elementos = new LinkedList<>();

    public void push(T elemento) {
        elementos.push(elemento);
    }

    public T pop() {
        return elementos.pop();
    }

    public T peek() {
        return elementos.peek();
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}
