package br.ifb.tsi.poo.robot.model.constructors;


import br.ifb.tsi.poo.robot.model.battles.Tournament;
import br.ifb.tsi.poo.robot.model.robots.Fighter;

public class TournamentReferee extends Tournament{
	private Coach coach;
	private Tournament quarter_one;
	private Tournament quarter_two;
	private Tournament quarter_three;
	private Tournament quarter_four;
	
	private Tournament semi_one;
	private Tournament semi_two;
	
	private Tournament finalBattle;
	private Tournament thirdPlace;
	

	public TournamentReferee(Coach engineer, Tournament tournament) {
		super();
		this.coach = engineer;
		this.quarter_one = tournament;
		this.quarter_two = tournament;
		this.quarter_three = tournament;
		this.quarter_four = tournament;
		this.semi_one = tournament;
		this.semi_two = tournament;
		this.finalBattle = tournament;
		this.thirdPlace = tournament;
	}

	public void callTheFighter() {
		
		Fighter r1 = coach.trainFighter();
		Fighter r2 = coach.trainFighter();		
		this.quarter_one.setR1(r1);
		this.quarter_one.setR2(r2);
		this.quarter_one.start(" pela Quartas de Final 1 - ");
		Fighter s11 = quarter_one.getWinner();
		s11.reset();
		System.out.println(s11);
		
		Fighter r3 = coach.trainFighter();
		Fighter r4 = coach.trainFighter();
		this.quarter_two.setR1(r3);
		this.quarter_two.setR2(r4);
		this.quarter_two.start(" pela Quartas de Final 2 - ");
		Fighter s12 = this.quarter_two.getWinner();
		s12.reset();
		
		
		Fighter r5 = coach.trainFighter();
		Fighter r6 = coach.trainFighter();
		this.quarter_three.setR1(r5);
		this.quarter_three.setR2(r6);
		this.quarter_three.start(" pela Quartas de Final 3 - ");
		Fighter s21 = this.quarter_three.getWinner();
		s21.reset();
		
		Fighter r7 = coach.trainFighter();
		Fighter r8 = coach.trainFighter();
		this.quarter_four.setR1(r7);
		this.quarter_four.setR2(r8);
		this.quarter_four.start(" pela Quartas de Final 4 - ");
		Fighter s22 = this.quarter_four.getWinner();
		s22.reset();
		
		System.out.println("Semifinal");
		System.out.println("Vencedor Quartas 1 " + s11 );
		System.out.println("Vencedor Quartas 2 " + s12);
		System.out.println("Vencedor Quartas 3 " + s21);
		System.out.println("Vencedor Quartas 4 " + s22);
		
	
		this.semi_one.setR1(s11);
		this.semi_one.setR2(s12);
		this.semi_one.start(" pela SemiFinal 1 - ");
		Fighter f1 = this.semi_one.getWinner();
		Fighter t1 = this.semi_one.getLooser();
		f1.reset();
		t1.reset();
		
		this.semi_two.setR1(s21);	
		this.semi_two.setR2(s22);
		this.semi_two.start(" pela SemiFinal 2 - ");
		Fighter f2 = this.semi_two.getWinner();
		Fighter t2 = this.semi_two.getLooser();
		f2.reset();
		t2.reset();
		
		
		this.finalBattle.setR1(f1);
		this.finalBattle.setR2(f2);
		this.finalBattle.start(" pela Final - ");
		
		
		this.thirdPlace.setR1(t1);
		this.thirdPlace.setR2(t2);
		this.thirdPlace.start(" pelo Terceiro Lugar - ");
		
	}
}
