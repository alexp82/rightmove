/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rightmove.design;

/**
 *
 * @author alexp
 */
public class StatePattern {

    public static void main(String[] args) {
        StateContext context = new StateContext(new LowerCaseState());
        context.command("Monday");
        context.command("Tuesday");
        context.command("Wednesday");
        context.command("Thursday");
        context.command("Friday");
    }
}
