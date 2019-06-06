package de.vr.minesweeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.vr.minegui.MineSweeperWindow;
import de.vr.minelogic.*;

@SpringBootApplication
public class MinesweeperApplication {

  public static void main(String[] args) {
    // SpringApplication.run(MinesweeperApplication.class, args);
    System.out.println("Caaaaaarl, why did you kill all these people?");
    
    new MineSweeperWindow();
    MainFrame newframe= new MainFrame();
    newframe.init();
  }
}
