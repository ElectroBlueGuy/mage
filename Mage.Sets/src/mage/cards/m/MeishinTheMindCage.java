
package mage.cards.m;

import java.util.UUID;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.dynamicvalue.common.CardsInControllerHandCount;
import mage.abilities.dynamicvalue.common.SignInversionDynamicValue;
import mage.abilities.dynamicvalue.common.StaticValue;
import mage.abilities.effects.common.continuous.BoostAllEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SuperType;
import mage.filter.StaticFilters;

/**
 *
 * @author emerald000
 */
public final class MeishinTheMindCage extends CardImpl {

    public MeishinTheMindCage(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "{4}{U}{U}{U}");
        this.supertype.add(SuperType.LEGENDARY);

        // All creatures get -X/-0, where X is the number of cards in your hand.
        this.addAbility(new SimpleStaticAbility(new BoostAllEffect(new SignInversionDynamicValue(CardsInControllerHandCount.ANY), StaticValue.get(0), Duration.WhileOnBattlefield, StaticFilters.FILTER_PERMANENT_CREATURE, false, "All creatures get -X/-0, where X is the number of cards in your hand")));
    }

    private MeishinTheMindCage(final MeishinTheMindCage card) {
        super(card);
    }

    @Override
    public MeishinTheMindCage copy() {
        return new MeishinTheMindCage(this);
    }
}
