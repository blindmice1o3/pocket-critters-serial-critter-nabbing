package model.states.menu;

import main.Handler;
import model.entities.nabbers.Player;
import model.states.IState;
import model.states.StateManager;

import java.awt.*;

public class MenuState implements IState {

    private Handler handler;
    private Player player;

    public MenuState(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;

        ////////////////////
        initStateManager();
        ////////////////////
    } // **** end MenuState(Handler, Player) constructor

    private void initStateManager() {
        StateManager.add("MenuStateMenu", new MenuStateMenu(handler, player));
        StateManager.add("MenuStateCritterDex", new MenuStateCritterDex(handler, player));
        StateManager.add("MenuStateCritterBeltList", new MenuStateCritterBeltList(handler, player));
        StateManager.add("MenuStateItemList", new MenuStateItemList(handler, player));
        StateManager.add("MenuStatePlayerStats", new MenuStatePlayerStats(handler, player));
        StateManager.add("MenuStateSave", new MenuStateSave(handler, player));
        StateManager.add("MenuStateOption", new MenuStateOption(handler, player));
        StateManager.add("MenuStateExit", new MenuStateExit(handler, player));
    }

    @Override
    public void tick() {
        ///////////////////////////////
        Object[] args = { player };
        StateManager.change("MenuStateMenu", null);
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