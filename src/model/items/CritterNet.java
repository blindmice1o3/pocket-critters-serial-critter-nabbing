package model.items;

import main.Handler;
import model.entities.critters.Critter;
import model.entities.critters.stats.StatsModule;
import model.states.battle.BattleState;

public class CritterNet extends Item {

    public CritterNet(Handler handler) {
        super(handler, Identifier.CRITTER_NET);
    }

    /* Capture method (Generation 1) (https://bulbapedia.bulbagarden.net/wiki/Catch_rate)
     5. If not, generate a random value, M, between 0 and 255.
     6. Calculate f:
            f = (HPmax * 255 * 4) / (HPcurrent * Ball),
                where all divisions are rounded down to the nearest integer.
            The minimum value of f is 1 and its maximum value is 255.
            The value of Ball is 8 if a Great Ball is used or 12 otherwise.
     7. If f is greater than or equal to M, the Pokémon is caught.
         Otherwise, the Pokémon breaks free.
         In practical terms, lowering the target's HP to 1/3 of its maximum will
         guarantee capture with a Poké Ball, while lowering it to 1/2 will
         guarantee capture with a Great Ball.
     */
    public void execute() {
        System.out.println("CritterNet.execute().");

        if (handler.getStateManager().getCurrentState() instanceof BattleState) {
            Critter critterOfOpponent = ((BattleState)handler.getStateManager().getIState("BattleState")).getCritterOfOpponent();
            StatsModule statsModuleOfOpponent = critterOfOpponent.getStatsModule();

            int mValue = (int)(Math.random() * 256);
            System.out.println("mValue: " + mValue);

            int fValue = (statsModuleOfOpponent.getStatsEffectiveMap().get(StatsModule.Type.HP) * 255 * 4) /
                    (critterOfOpponent.getHpEffectiveCurrent() * 12);

            //maybe Math.ceiling and Math.floor
            if (fValue < 1) {
                fValue = 1;
            } else if (fValue > 255) {
                fValue = 255;
            }

            if (fValue >= mValue) {
                System.out.println("CAUGHT!!!!");
            } else {
                System.out.println("AWWWW!!!!!");
            }
        }
    }

} // **** end CritterNet class ****