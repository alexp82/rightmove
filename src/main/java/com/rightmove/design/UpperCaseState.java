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
public class UpperCaseState implements State {

    public void execute(StateContext context, String command) {
        if (command == null || command.isEmpty()) {
            throw new IllegalArgumentException("Command is empty!");
        }
        System.out.println(command.toUpperCase());
        context.setState(new LowerCaseState());
    }

}
