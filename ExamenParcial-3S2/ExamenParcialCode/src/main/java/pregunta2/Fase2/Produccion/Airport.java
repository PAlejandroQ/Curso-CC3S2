package pregunta2.Fase2.Produccion;
public class Airport {
    public static void main(String[] args) {
        Flight economyFlight = new EconomyFlight("1");
        Flight businessFlight = new BusinessFlight("2");

        Passenger cesar = new Passenger("Cesar", true);
        Passenger jessica = new Passenger("Jessica", false);

        businessFlight.addPassenger(cesar);
        businessFlight.removePassenger(cesar);
        businessFlight.addPassenger(jessica);
        economyFlight.addPassenger(jessica);

        System.out.println("Lista de pasajeros de vuelos de negocios:");
        for (Passenger passenger : businessFlight.getPassengers()) {
            System.out.println(passenger.getName());
        }

        System.out.println("Lista de pasajeros de vuelos de negocios:");
        for (Passenger passenger : economyFlight.getPassengers()) {
            System.out.println(passenger.getName());
        }
    }
}
