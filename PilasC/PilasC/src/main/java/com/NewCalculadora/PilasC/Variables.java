package com.NewCalculadora.PilasC;

public class Variables {
    private final String nombre;
    private int valor;

    public Variables(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nombre + "=" + valor;
    }
}
