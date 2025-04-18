package mage.cards.b;

import mage.MageInt;
import mage.abilities.common.CantBlockAbility;
import mage.abilities.common.LandfallAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.LifeCompareCondition;
import mage.abilities.decorator.ConditionalContinuousEffect;
import mage.abilities.effects.ContinuousEffect;
import mage.abilities.effects.common.ReturnSourceFromGraveyardToBattlefieldEffect;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.keyword.HasteAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;

import java.util.UUID;

/**
 * @author maurer.it_at_gmail.com
 */
public final class Bloodghast extends CardImpl {

    public Bloodghast(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{B}{B}");
        this.subtype.add(SubType.VAMPIRE, SubType.SPIRIT);

        this.power = new MageInt(2);
        this.toughness = new MageInt(1);

        // Bloodghast can't block.
        this.addAbility(new CantBlockAbility());
        // Bloodghast has haste as long as an opponent has 10 or less life.
        ContinuousEffect effect = new GainAbilitySourceEffect(HasteAbility.getInstance(), Duration.WhileOnBattlefield);
        this.addAbility(new SimpleStaticAbility(new ConditionalContinuousEffect(effect,
                new LifeCompareCondition(TargetController.OPPONENT, ComparisonType.OR_LESS, 10),
                "{this} has haste as long as an opponent has 10 or less life")));
        // Landfall — Whenever a land you control enters, you may return Bloodghast from your graveyard to the battlefield.
        this.addAbility(new LandfallAbility(Zone.GRAVEYARD, new ReturnSourceFromGraveyardToBattlefieldEffect(false, false), true));
    }

    private Bloodghast(final Bloodghast card) {
        super(card);
    }

    @Override
    public Bloodghast copy() {
        return new Bloodghast(this);
    }
}
