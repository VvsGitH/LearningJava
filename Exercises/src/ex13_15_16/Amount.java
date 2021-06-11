package ex13_15_16;

public class Amount implements Cloneable{
	private int units;
	private int cents;
	private String currency;
	
	public Amount(int units, int cents, String currency) {
		this.units = units;
		this.cents = cents;
		this.currency = currency;
	}
	
	public void setAmount(int units, int cents) {
		this.units = units;
		this.cents = cents;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return String.format("%d,%02d %s", units, cents, currency);
	}
	
	// DEEP EQUALITY IMPLEMENTATION
	
	@Override
	public boolean equals(Object o) {
		// Check if the type is the same and is not null
		if (o != null && getClass().equals(o.getClass())) {
			Amount m = (Amount) o;
			return (units == m.units) 
					&& (cents == m.cents) 
					&& (currency == m.currency);
		}
		
		return false;
	}
	
	// The behaviour of the hashCode() must be coherent with equals
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 5*hash + units;
		hash = 5*hash + cents;
		hash = 5*hash + (currency != null ? currency.hashCode() : 0);
		return hash;
	}
	
	// DEEP CLONE IMPLEMENTATION
	
	@Override
	public Object clone() {
		try {
			// Copia campo a campo
			Amount a = (Amount) super.clone();
			a.currency = new String(currency);
			return a;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
