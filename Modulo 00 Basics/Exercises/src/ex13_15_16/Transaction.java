package ex13_15_16;

public class Transaction extends Amount {
	private String emitter;
	private String[] receivers;
	
	public Transaction(String emitter, String[] receivers, int units, int cents, String currency) {
		super(units, cents, currency);
		this.emitter = emitter;
		
		// Devo clonare l'array in ingresso in modo da fare una copia dei valori
		// Altrimenti verrebbe semplicmente assegnata la reference
		this.receivers = receivers.clone();
	}
	
	public void changeReceiver(String current, String newReceiver) {
		for (int i = 0; i < receivers.length; i++) {
			if (receivers[i] == current) receivers[i] = newReceiver;
		}
	}
	
	@Override
	public String toString() {
		String str = "{\n  Emitter: " + emitter + "\n  Receivers: ";
		for (String elm : receivers) {
			str += elm + " ";
		}
		str += "\n  Amount: " + super.toString() + "\n}";
		return str;
	}
	
	// DEEP EQUALITY OF A SUBCLASS
	
	@Override
	public boolean equals(Object o) {
		// Check the equality of the superclass first
		if (super.equals(o)) {
			Transaction t = (Transaction) o;
			
			// Check the equality of the other attributes
			if (emitter == t.emitter) {
				
				// Check the equality of two arrays
				if (receivers.length != t.receivers.length)
					return false;
				
				for (int i = 0; i < receivers.length; i++) {
					if (receivers[i] != t.receivers[i] ) {
						return false;
					}
				}
				
				return true;
				
			} else 
				return false;
			
		} else
			return false;
	}
	
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 5*hash + (emitter != null ? emitter.hashCode() : 0);
		hash = 5*hash + (receivers != null ? receivers.hashCode() : 0);
		return hash;
	}
	
	// DEEP CLONE OF A SUBCLASS
	
	@Override
	public Object clone() {
		// Copia campo a campo
		Transaction t = (Transaction) super.clone();
		
		// Copia dei campi non primitivi
		t.emitter = new String(emitter);		
		t.receivers = receivers.clone();
		
		return t;
	}
}
