# Java Simple Calculator
This project represents my first practical experience working with Java. It was developed in the summer of 2023, before I started university. After learning the fundamentals of the language and becoming familiar with the AWT and Swing libraries through tutorials by [La Geekipedia de Ernesto](https://www.youtube.com/playlist?list=PLyvsggKtwbLX9LrDnl1-K6QtYo7m0yXWB), I decided to build a small project on my own to consolidate what I had learned and move beyond guided exercises.

> [!NOTE]
> As this project was created during my first contact with a programming language, and due to the limited knowledge I had at the time, the calculator follows a very simple interaction model. It only supports arithmetic operations between two numbers, and the operator must be selected after both numbers have been entered. Rather than evaluating full mathematical expressions, the program processes inputs in a fixed sequence (first number → second number → operator → result)

## Preview
<p align="center">
   <img src="/screenshots/pic1.png" width="35%">
   &nbsp;&nbsp;&nbsp;&nbsp;
   <img src="/screenshots/pic2.png" width="35%">
</p>

## Features
- Basic arithmetic operations:
  - Addition
  - Subtraction
  - Multiplication
  - Division
- Graphical interface built with **Java Swing**
- **Dark mode / Light mode** toggle
- Version history dialog
- Simple input validation

## Running the Project (from source)
Compile:
```
javac Calculadora.java
```
Run:
```
java Calculadora
```

## Running the Project (by .jar)
```
java -jar Calculadora.jar
```
