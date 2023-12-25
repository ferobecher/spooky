package Menu;

import Menu.Skeleton;

import java.awt.BorderLayout;

import javax.swing.*;

public class SkeletonPanel extends JPanel{
    public SkeletonPanel() {
        this.setBackground(null);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setSize(600,600);
        this.add(new Skeleton());
    }
}
