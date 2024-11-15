package com.NewCalculadora.PilasC;

import java.util.HashMap;
import java.util.Map;

public class EvaluadorExpresion {
    private final PilaT<Integer> pilaOperandos = new PilaT<>();
    private final PilaT<Character> pilaOperadores = new PilaT<>();
    private final Map<String, Variables> variables = new HashMap<>();

    public void crearVariable(String nombre, int valorInicial) {
        if (nombre.length() > 12 || !nombre.matches("[a-zA-Z][a-zA-Z0-9]*")) {
            throw new IllegalArgumentException("Nombre de variable inválido");
        }
        variables.put(nombre, new Variables(nombre, valorInicial));
    }

    public int evaluarExpresion(String expresion) {
        for (int i = 0; i < expresion.length(); i++) {
            char simbolo = expresion.charAt(i);

            if (Character.isDigit(simbolo)) {
                pilaOperandos.push(Character.getNumericValue(simbolo));
            } else if (simbolo == '@') {
                mostrarPilas();
            } else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/') {
                while (!pilaOperadores.estaVacia() && precedencia(simbolo) <= precedencia(pilaOperadores.peek())) {
                    aplicarOperador();
                }
                pilaOperadores.push(simbolo);
            }
        }

        while (!pilaOperadores.estaVacia()) {
            aplicarOperador();
        }

        return pilaOperandos.pop();
    }

    private void aplicarOperador() {
        int b = pilaOperandos.pop();
        int a = pilaOperandos.pop();
        char operador = pilaOperadores.pop();

        switch (operador) {
            case '+': pilaOperandos.push(a + b); break;
            case '-': pilaOperandos.push(a - b); break;
            case '*': pilaOperandos.push(a * b); break;
            case '/': pilaOperandos.push(a / b); break;
        }
    }

    private void mostrarPilas() {
        System.out.println("Operandos: " + pilaOperandos);
        System.out.println("Operadores: " + pilaOperadores);
    }

    private int precedencia(char operador) {
        return switch (operador) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    public PilaT<Integer> getPilaOperandos() {
        return pilaOperandos;
    }

    public PilaT<Character> getPilaOperadores() {
        return pilaOperadores;
    }
}
