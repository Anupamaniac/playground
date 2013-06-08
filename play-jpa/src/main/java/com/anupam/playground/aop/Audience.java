package com.anupam.playground.aop;


public class Audience{
	
	public Audience(){
		System.out.println(" Audience instantiated... ");
	}
	
	public void takeSeats(){
		System.out.println(" Please take a seat... ");
	}
	
	public void turnOffCellPhones(){
		System.out.println(" Please turn off your Cell phones ");
	}
	
	public void applause(){
		for(int i=1;i<=5;i++){
			System.out.println(" CLAP CLAP CLAP CLAP CLAP CLAP CLAP CLAP CLAP CLAP CLAP ");
		}		
	}
	
	public void demandRefund(){
		for(int j=0;j<5;j++){
			System.out.println(" I want my money back ");
		}		
	}
}
