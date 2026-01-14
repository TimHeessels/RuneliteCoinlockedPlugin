package com.rogueliteplugin.ui;

import javax.swing.*;
import java.awt.*;

public class PackOptionButton extends JButton {
    private static final int CARD_WIDTH = 120;
    private static final int CARD_HEIGHT = 190;

    private float alpha = 1f;
    private final String unlockTitle;
    private final String unlockType;
    private final Icon unlockIcon;

    private final String challengeTitle;
    private final String challengeType;

    public PackOptionButton(String unlockTitle, String unlockType, String challengeTitle, String challengeType, Icon unlockIcon) {
        this.unlockTitle = unlockTitle;
        this.unlockIcon = unlockIcon;
        this.unlockType = unlockType;
        this.challengeTitle = challengeTitle;
        this.challengeType = challengeType;

        Dimension size = new Dimension(CARD_WIDTH, CARD_HEIGHT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(6, 6, 6, 6)
        ));

        setAlignmentX(Component.CENTER_ALIGNMENT);
        setFocusPainted(false);
        setEnabled(false);

        showBack();
    }

    public void showBack() {
        setText("?");
        setIcon(null);
    }

    public void reveal() {
        setText("<html><center>"
                + "<span style='font-size:14px; color:#46a720;'>"
                + "Unlock<br>"
                + unlockType+ "<br>"
                + unlockTitle + "</span><br><br>"
                + "<span style='font-size:14px; color:#4656ff;'>"
                + "Next challenge<br>"
                + challengeType + "<br>"
                + challengeTitle
                + "</span><br>"
                + "</center></html>");

        setIcon(unlockIcon);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setEnabled(true);
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(
                AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)
        );
        super.paintComponent(g2);
        g2.dispose();
    }
}

