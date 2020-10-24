package version4;

import java.util.Iterator;

public abstract class Situation {

	public String valeur(Client client) {
		Iterator<Location> forEach = client.getLocations().iterator();
		String result = headerString(client);

		while (forEach.hasNext()) {

			Location each = (Location) forEach.next();

			// mise en forme location
			result += eachRentalString(each);
		}

		// ajout récapitulatif client
		result += footerString(client);

		return result;
	}

	abstract String headerString(Client client);

	abstract String eachRentalString(Location location);

	abstract String footerString(Client client);

}
