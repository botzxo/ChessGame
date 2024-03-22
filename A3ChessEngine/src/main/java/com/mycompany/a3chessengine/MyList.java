/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a3chessengine;

/**
 *
 * @author shahe
 */
public class MyList<T>{
   
    private Object[] elements;
    private int size;

    public MyList() {
        this.elements = new Object[10]; // initial capacity
        this.size = 0;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            Object[] newElements = new Object[size * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index]; // cast is necessary
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // facilitate garbage collection
    }
    
    public void addAll(MyList<T> anotherList) {
        for (int i = 0; i < anotherList.size(); i++) {
            this.add(anotherList.get(i));
        }
    }
    
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            // Using equals to check for equality since T could be any object
            if (element == null && elements[i] == null) {
                return true;
            } else if (element != null && element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
