package net.reldo.taskstracker.panel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import net.reldo.taskstracker.TasksTrackerPlugin;
import net.reldo.taskstracker.panel.components.FixedWidthPanel;
import net.reldo.taskstracker.panel.subfilters.*;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.ColorScheme;

public class SubFilterPanel extends FixedWidthPanel
{
    private final List<FilterButtonPanel> filterPanels = new ArrayList<>();

    public SubFilterPanel(TasksTrackerPlugin plugin, SpriteManager spriteManager)
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(ColorScheme.DARKER_GRAY_COLOR);
        setVisible(false);

        addFilterButtonPanel(new SkillFilterPanel(plugin));

        addFilterButtonPanel(new DifficultyFilterPanel(plugin, spriteManager));

        addFilterButtonPanel(new AreaFilterPanel(plugin, spriteManager));

        addFilterButtonPanel(new CategoryFilterPanel(plugin, spriteManager));
    }

    public void addFilterButtonPanel(FilterButtonPanel panel)
    {
        filterPanels.add(panel);
        add(panel);
    }

    public void redraw()
    {
        filterPanels.forEach(FilterButtonPanel::redraw);
    }
}
