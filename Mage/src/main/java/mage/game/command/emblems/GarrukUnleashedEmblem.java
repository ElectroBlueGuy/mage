package mage.game.command.emblems;

import mage.abilities.triggers.BeginningOfEndStepTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.search.SearchLibraryPutInPlayEffect;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.StaticFilters;
import mage.game.command.Emblem;
import mage.target.common.TargetCardInLibrary;

public class GarrukUnleashedEmblem extends Emblem {

    // At the beginning of your end step, you may search your library for a creature card, put it onto the battlefield, then shuffle your library.
    public GarrukUnleashedEmblem() {
        super("Emblem Garruk");
        Effect effect = new SearchLibraryPutInPlayEffect(new TargetCardInLibrary(StaticFilters.FILTER_CARD_CREATURE), false)
                .setText("search your library for a creature card, put it onto the battlefield, then shuffle");
        this.getAbilities().add(new BeginningOfEndStepTriggeredAbility(Zone.COMMAND, TargetController.YOU, effect, true, null));
    }

    private GarrukUnleashedEmblem(final GarrukUnleashedEmblem card) {
        super(card);
    }

    @Override
    public GarrukUnleashedEmblem copy() {
        return new GarrukUnleashedEmblem(this);
    }
}
