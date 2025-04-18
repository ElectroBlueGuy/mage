package mage.cards.t;

import mage.abilities.costs.common.DiscardXTargetCost;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.ReturnToHandTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.filter.StaticFilters;
import mage.target.common.TargetNonlandPermanent;
import mage.target.targetadjustment.XTargetsCountAdjuster;

import java.util.UUID;

/**
 * @author fireshoes
 */
public final class TurbulentDreams extends CardImpl {

    public TurbulentDreams(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{U}{U}");

        // As an additional cost to cast this spell, discard X cards.
        this.getSpellAbility().addCost(new DiscardXTargetCost(StaticFilters.FILTER_CARD_CARDS, true));

        // Return X target nonland permanents to their owners' hands.
        Effect effect = new ReturnToHandTargetEffect();
        effect.setText("Return X target nonland permanents to their owners' hands");
        this.getSpellAbility().addEffect(effect);
        this.getSpellAbility().addTarget(new TargetNonlandPermanent());
        this.getSpellAbility().setTargetAdjuster(new XTargetsCountAdjuster());
    }

    private TurbulentDreams(final TurbulentDreams card) {
        super(card);
    }

    @Override
    public TurbulentDreams copy() {
        return new TurbulentDreams(this);
    }
}
