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
public class StateContext {

    private State state;

    public StateContext(State state) {
        this.state = state;
    }

    public void command(String command) {
        state.execute(this, command);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
