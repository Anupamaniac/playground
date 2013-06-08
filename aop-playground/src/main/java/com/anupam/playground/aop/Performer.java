package com.anupam.playground.aop;

public class Performer{
	public Performer(){
		System.out.println(" Performer instantiated.... ");
	}
	
	public void perform() throws Exception{		
			boolean b = true;
			for(int j=0;j<20;j++){
				System.out.println(" I'm performing ");
				if(j > 13 && b){
					throw new Exception(" I'm performing badly ");
				}
				Thread.sleep(500);
			}
	}

	public void performerAppearsOnStage() {
		// TODO Auto-generated method stub
		System.out.println(" **Appeared on stage.** ");
	}
}