package br.ifb.tsi.poo.robot.controller;

import java.io.IOException;
import java.util.Scanner;

import br.ifb.tsi.poo.robot.model.battles.AutoBattle;
import br.ifb.tsi.poo.robot.model.battles.AutoSkillBattle;
import br.ifb.tsi.poo.robot.model.battles.ManualBattle;
import br.ifb.tsi.poo.robot.model.battles.ManualSkillBattle;
import br.ifb.tsi.poo.robot.model.battles.Tournament;
import br.ifb.tsi.poo.robot.model.constructors.InteractiveSkillRobotEngineer;
import br.ifb.tsi.poo.robot.model.constructors.InteractiveRobotEngineer;
import br.ifb.tsi.poo.robot.model.constructors.RandomRobotEngineer;
import br.ifb.tsi.poo.robot.model.constructors.Referee;
import br.ifb.tsi.poo.robot.model.constructors.TournamentReferee;
import br.ifb.tsi.poo.robot.utils.Reader;


public class Main {
	public static void main(String[] args) throws IOException {
		
		String wheels = "src/br/ifb/tsi/poo/robot/utils/anaconda.txt";
		String iron = "src/br/ifb/tsi/poo/robot/utils/iron.txt";
		
		boolean active = true;
		Scanner input = new Scanner(System.in); 
		
		while (active == true ) {
			Reader.reader(wheels);
			int tire = input.nextInt();
			
			if (tire == 1) {
				Reader.reader(iron);
				int robop = input.nextInt();
				
				switch (robop) {
				case 1:
					Referee referee = new Referee(new RandomRobotEngineer(), new AutoBattle());
					referee.callTheFighter();
					break;
				case 2:
					Referee referee_two = new Referee(new InteractiveRobotEngineer(), new AutoBattle());
					referee_two.callTheFighter();
					break;
				case 3:
					Referee referee_three = new Referee(new InteractiveSkillRobotEngineer(), new AutoSkillBattle());
					referee_three.callTheFighter();
					break;
				case 4:
					TournamentReferee tournamentReferee = new TournamentReferee(new RandomRobotEngineer(), new Tournament());
					tournamentReferee.callTheFighter();
					break;
				default:
					System.out.println("Por favor, insira um valor válido");
					break;
				}
				
			} else if (tire == 2) {
				Reader.reader(iron);
				int robop = input.nextInt();
				
				switch (robop) {
				case 1:
					Referee referee = new Referee(new RandomRobotEngineer(), new ManualBattle());
					referee.callTheFighter();
					break;
				case 2:
					Referee referee_two = new Referee(new InteractiveRobotEngineer(), new ManualBattle());
					referee_two.callTheFighter();
					break;
				case 3:
					Referee referee_three = new Referee(new InteractiveSkillRobotEngineer(), new ManualSkillBattle());
					referee_three.callTheFighter();
					break;
				default:
					System.out.println("Por favor, insira um valor válido");
					break;
				}
				
			} else {
				System.out.println("Por favor, insira um valor válido");
			}
		}
		input.close();
	}
}
