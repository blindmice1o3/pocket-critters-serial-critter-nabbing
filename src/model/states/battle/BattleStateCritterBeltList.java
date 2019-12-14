package model.states.battle;

import main.Handler;
import main.gfx.Assets;
import model.entities.Player;
import model.entities.critters.Critter;
import model.states.IState;
import model.states.StateMachine;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BattleStateCritterBeltList implements IState {

    private Handler handler;
    private Player player;

    private Critter opponentCritter;

    private int index;

    public BattleStateCritterBeltList(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;

        index = 0;
    } // **** end BattleStateCritterBeltList(Handler, Player) constructor ****

    @Override
    public void tick(long timeElapsed) {
        System.out.println("BattleStateCritterBeltList.tick()");

        //UP
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
            System.out.println("BattleStateCritterBeltList.tick()... up");

            index--;

            if (index < 0) {
                index = (player.getCritterBeltList().size()-1);
            }
        }
        //DOWN
        else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
            System.out.println("BattleStateCritterBeltList.tick()... down");

            index++;

            if (index >= player.getCritterBeltList().size()) {
                index = 0;
            }
        }
        //LEFT
        else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
            System.out.println("BattleStateCritterBeltList.tick()... left");
        }
        //RIGHT
        else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {
            System.out.println("BattleStateCritterBeltList.tick()... right");
        }
        //aButton
        else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_COMMA)) {
            System.out.println("BattleStateCritterBeltList.tick()... aButton");

            System.out.println( "Critter selected: " + player.getCritterBeltList().get(index) );
        }
        //bButton
        else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_PERIOD)) {
            System.out.println("BattleStateCritterBeltList.tick()... bButton");

            ///////////////////////////////
            if (handler.getStateManager().getCurrentState() instanceof BattleState) {
                BattleState battleState = (BattleState)handler.getStateManager().getCurrentState();
                StateMachine stateMachine = battleState.getStateMachine();

                stateMachine.pop();
            }
            ///////////////////////////////
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.backgroundCritterBeltList,
                0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(),
                0, 0, Assets.backgroundCritterBeltList.getWidth(), Assets.backgroundCritterBeltList.getHeight(), null);
    }

    @Override
    public void enter(Object[] args) {
        if (args != null) {
            if (args[0] instanceof Critter) {
                opponentCritter = (Critter)args[0];
            }
        }
    }

    @Override
    public void exit() {

    }

} // **** end BattleStateCritterBeltList class ****