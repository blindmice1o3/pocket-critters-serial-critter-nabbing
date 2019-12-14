package model.states.battle;

import main.Handler;
import model.entities.Player;
import model.entities.critters.Critter;
import model.states.IState;
import model.states.StateMachine;

import java.awt.*;

public class BattleState implements IState {

    private Handler handler;
    private Player player;

    private StateMachine stateMachine;

    private Critter opponentCritter;

    public BattleState(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;

        initStateMachine();
    } // **** end BattleState(Handler, Player) constructor ****

    private void initStateMachine() {
        stateMachine = new StateMachine(handler);

        stateMachine.addIStateToCollection("BattleStateIntro", new BattleStateIntro(handler, player));
        stateMachine.addIStateToCollection("BattleStateMenu", new BattleStateMenu(handler, player));
        stateMachine.addIStateToCollection("BattleStateFight", new BattleStateFight(handler, player));
        stateMachine.addIStateToCollection("BattleStateItemList", new BattleStateItemList(handler, player));
        stateMachine.addIStateToCollection("BattleStateCritterBeltList", new BattleStateCritterBeltList(handler, player));
        stateMachine.addIStateToCollection("BattleStateRun", new BattleStateRun(handler, player));
        stateMachine.addIStateToCollection("BattleStateOutro", new BattleStateOutro(handler, player));

        stateMachine.push( stateMachine.getIState("BattleStateIntro"), null );
    }

    @Override
    public void tick(long timeElapsed) {
        stateMachine.getCurrentState().tick(timeElapsed);
    }

    @Override
    public void render(Graphics g) {
        stateMachine.getCurrentState().render(g);
    }

    @Override
    public void enter(Object[] args) {
        if (args != null) {
            if (args[0] instanceof Critter) {
                opponentCritter = (Critter)args[0];
                ((BattleStateIntro)stateMachine.getIState("BattleStateIntro")).setOpponentCritter(opponentCritter);
            }
        }
    }

    @Override
    public void exit() {

    }

    // GETTERS AND SETTERS

    public StateMachine getStateMachine() { return stateMachine; }

} // **** end BattleState class ****