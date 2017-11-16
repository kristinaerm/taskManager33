/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.TimerTask;
import javax.swing.JFrame;
import model.TaskLog;

/**
 *
 * @author USER
 */
public class NotificationTimerTask extends TimerTask{

    @Override
    public void run() {
        SimpleNotification frame = new SimpleNotification(Transfer.tl);
        
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
