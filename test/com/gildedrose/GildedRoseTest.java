package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void normalItemTenDaysToSell() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0], is(new Item("+5 Dexterity Vest", 9, 19)));
    }

    @Test
    public void normalItemTenDaysToSellApproval() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Approvals.verify(items[0]);
    }
}
