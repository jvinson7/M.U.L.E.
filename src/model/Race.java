package model;

/**
 * Race represents all of the possible races for players
 * @author Kevin Randrup
 */
public enum Race {
	Elf,
	Droid,
	FirBolg,
	SpaceCowboy,
	SpacePirate;
	
	@Override
	public String toString() {
		if (this == FirBolg) {
			return "Fir Blog";
		} else if (this == SpaceCowboy) {
			return "Space Cowboy";
		} else if (this == SpacePirate) {
			return "Space Pirate";
		} else {
			return this.name();
		}
	}
}
