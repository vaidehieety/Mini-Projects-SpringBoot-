package com.example.tax;

public class IncomeTax implements Tax {
    /*
    1. Create the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. Make this class an implementation of Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */
	
	double taxableAmount;
	double taxAmount;
	boolean isTaxPayed;
	
	public IncomeTax() {
		this.isTaxPayed=false;
	}
	
		
	public void setTaxableAmount(int amount) {
		this.taxableAmount=(double)amount;
	}
	
	public void calculateTaxAmount() {
		if(this.taxableAmount>=0 && this.taxableAmount<300000) {
			this.taxAmount=0.0;
		}else if(this.taxableAmount>=300000 && this.taxableAmount<600000) {
			this.taxAmount = this.taxableAmount * 0.05;
		}else if(this.taxableAmount>=600000 && this.taxableAmount<900000) {
			this.taxAmount = this.taxableAmount * 0.10;
		}else if(this.taxableAmount>=900000 && this.taxableAmount<1200000) {
			this.taxAmount = this.taxableAmount * 0.15;
		}else if(this.taxableAmount>=1200000 && this.taxableAmount<1500000) {
			this.taxAmount = this.taxableAmount * 0.20;
		}else if(this.taxableAmount>=1500000 ) {
			this.taxAmount=this.taxableAmount *0.30;;
		}
		
	}
	
	public double getTaxAmount() {
		return this.taxAmount;	
	}
	
	public String getTaxType() {
		return "income";
	}
	
	public boolean isTaxPayed() {
		return this.isTaxPayed;
	}
	
	public void payTax() {
		if(this.isTaxPayed==false) {
			this.isTaxPayed=true;
		}
		System.out.println("Hi, your income tax is paid");
	}

}
