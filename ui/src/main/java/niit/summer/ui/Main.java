package niit.summer.ui;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UIForm form = new UIForm();
                form.initUI();
            }
        });
    }
}
