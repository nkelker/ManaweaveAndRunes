package io.github.sfseeger.manaweave_and_runes.datagen.server.datamaps;

import io.github.sfseeger.lib.common.datamaps.SpellNodeAttributes;
import io.github.sfseeger.lib.common.mana.Manas;
import io.github.sfseeger.lib.common.spells.AbstractSpellNode;
import io.github.sfseeger.lib.core.ManaweaveAndRunesRegistries;
import io.github.sfseeger.manaweave_and_runes.core.init.SpellNodeInit;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.function.Supplier;

public class SpellNodeAttributeProvider implements IDataMapRegistrar {
    private static <T extends AbstractSpellNode> ResourceKey<AbstractSpellNode> createResourceKey(Supplier<T> spellNode) {
        return ResourceKey.create(ManaweaveAndRunesRegistries.SPELL_NODE_REGISTRY_KEY,
                spellNode.get().getRegistryName());
    }

    @Override
    public void register(DataMapProvider provider) {
        DataMapProvider.Builder<SpellNodeAttributes, AbstractSpellNode> builder =
                provider.builder(SpellNodeAttributes.SPELL_NODE_ATTRIBUTES);
        addAttributes(builder, SpellNodeInit.SPELL_TYPE_PROJECTILE, SpellNodeAttributes.builder(10).withCost(
                Manas.AirMana, 5).withModifier(SpellNodeInit.SPELL_MODIFIER_STRENGTHEN).withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN).build());

        addAttributes(builder, SpellNodeInit.SPELL_TYPE_SELF,
                SpellNodeAttributes.builder(3).withCost(Manas.EarthMana, 3).withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN).build());
        addAttributes(builder, SpellNodeInit.SPELL_TYPE_TOUCH,
                SpellNodeAttributes.builder(5).withCost(Manas.EarthMana, 3).withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN).build());
        addAttributes(builder, SpellNodeInit.SPELL_TYPE_RUNE, SpellNodeAttributes.builder(25)
                .withCost(Manas.EarthMana, 10)
                .withCost(Manas.OrderMana, 2)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_ELONGATE)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_WIDEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN)
                .build());

        addAttributes(builder, SpellNodeInit.SPELL_EFFECT_BREAK, SpellNodeAttributes.builder(8)
                .withCost(Manas.EarthMana, 4)
                .withCost(Manas.EntropyMana, 2)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_STRENGTHEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_WIDEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_ELONGATE)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_DELICATE)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_EFFECT_BURN, SpellNodeAttributes.builder(8)
                .withCost(Manas.FireMana, 4)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_STRENGTHEN)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_EFFECT_EXPLODE, SpellNodeAttributes.builder(12)
                .withCost(Manas.FireMana, 15)
                .withCost(Manas.EntropyMana, 8)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_STRENGTHEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_WIDEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_EFFECT_HEAL, SpellNodeAttributes.builder(6)
                .withCost(Manas.WaterMana, 8)
                .withCost(Manas.OrderMana, 2)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_STRENGTHEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_DELICATE)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_EFFECT_HARM, SpellNodeAttributes.builder(6)
                .withCost(Manas.VoidMana, 2)
                .withCost(Manas.EntropyMana, 2)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_STRENGTHEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_DELICATE)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_EFFECT_PUSH, SpellNodeAttributes.builder(6)
                .withCost(Manas.AirMana, 4)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_STRENGTHEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_WIDEN)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_ELONGATE)
                .withModifier(SpellNodeInit.SPELL_MODIFIER_HASTEN)
                .build());

        addAttributes(builder, SpellNodeInit.SPELL_MODIFIER_STRENGTHEN, SpellNodeAttributes.builder(4)
                .withCost(Manas.EarthMana, 4)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_MODIFIER_WIDEN, SpellNodeAttributes.builder(4)
                .withCost(Manas.AirMana, 2)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_MODIFIER_ELONGATE, SpellNodeAttributes.builder(4)
                .withCost(Manas.AirMana, 2)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_MODIFIER_DELICATE, SpellNodeAttributes.builder(1)
                .withCost(Manas.OrderMana, 1)
                .build());
        addAttributes(builder, SpellNodeInit.SPELL_MODIFIER_HASTEN, SpellNodeAttributes.builder(-4).withCost(Manas.OrderMana, 4).build());
    }

    private <T extends AbstractSpellNode> void addAttributes(DataMapProvider.Builder<SpellNodeAttributes, AbstractSpellNode> builder, Supplier<T> node, SpellNodeAttributes attributes) {
        builder.add(createResourceKey(node), attributes, false);
    }
}
