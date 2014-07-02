/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rightmove.design;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author alexp
 */
public class PrintVisitor implements ReflectiveVisitor {

    public void defaultMethod(Object o) {
        System.out.println(o.toString());
    }

    public void visit(Object o) {
        // Class.getName() returns package information as well. This strips off the package information giving us just the class name
        String methodName = o.getClass().getName();
        methodName = "visit" + methodName.substring(methodName.lastIndexOf('.') + 1);
        // Now we try to invoke the method visit<methodName>
        try {
            // Get the method visitFoo(Foo foo)
            Method m = getClass().getMethod(methodName, new Class[]{o.getClass()});
            // Try to invoke visitFoo(Foo foo)
            m.invoke(this, new Object[]{o});
        } catch (NoSuchMethodException e) {
            // No method, so do the default implementation
            defaultMethod(o);
        }
    }

    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o instanceof Visitable) {
                ((Visitable) o).accept(this);
            }
        }
    }

    public void visitString(String string) {
        System.out.println("'" + string + "'");
    }

    public void visitFloat(Float floatValue) {
        System.out.println(floatValue.toString() + "f");
    }

}
