package model.states.menu;

import main.Handler;
import model.entities.Player;
import model.states.IState;
import model.states.StateManager;

import java.awt.*;

public class MenuState implements IState {

    private Handler handler;
    private Player player;

    public MenuState(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
    } // **** end MenuState(Handler, Player) constructor

    @Override
    public void tick(long timeElapsed) {
        ///////////////////////////////
        Object[] args = { player };
        handler.getStateManager().push(
                handler.getStateManager().getIState("MenuStateMenu"),
                null);
        ///////////////////////////////


    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void enter(Object[] args) {

    }

    @Override
    public void exit() {

    }

} // **** end MenuState class ****