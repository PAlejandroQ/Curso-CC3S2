package pregunta2.Fase5.Pruebas;
import org.junit.jupiter.api.*;
import pregunta2.Fase5.Produccion.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @DisplayName("Dado que hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger jessica;
        private Passenger cesar;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Luegos puedes agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(jessica)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertEquals("Jessica", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(jessica)),
                        () -> assertEquals(0, economyFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Entonces no puedes agregarlo a un vuelo economico mas de una vez")
            @RepeatedTest(5)
            public void testEconomyFlightRegularPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(cesar);
                }
                assertAll("Verifica que un pasajero regular se pueda agregar a un vuelo económico solo una vez",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(cesar)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
                );
            }
        }
        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo economico")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertEquals("Cesar", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Entonces no puedes agregarlo a un vuelo economico mas de una vez")
            @RepeatedTest(5)
            public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(cesar);
                }
                assertAll("Verifica que un pasajero VIP se pueda agregar a un vuelo económico solo una vez",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(cesar)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
                );
            }
        }
    }

    @DisplayName("Dado que hay un vuelo de negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger jessica;
        private Passenger cesar;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces no puedes agregarlo o eliminarlo de un vuelo de negocios")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                        () -> assertEquals(false, businessFlight.addPassenger(jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo de negocios")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                        () -> assertEquals(true, businessFlight.addPassenger(cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Entonces no puedes agregarlo a un vuelo de negocios mas de una vez.")
            @RepeatedTest(5)
            public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    businessFlight.addPassenger(cesar);
                }
                assertAll("Verifica que un pasajero VIP se pueda agregar a un vuelo de negocios solo una vez",
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertTrue(businessFlight.getPassengersSet().contains(cesar)),
                        () -> assertTrue(new ArrayList<>(businessFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
                );
            }
        }
    }

   // Recuerda que debes completar esto del ejercicio anterior
   @DisplayName("Dado que hay un vuelo premium")
   @Nested
   class PremiumFlightTest {
       private Flight premiumFlight;
       private Passenger jessica;
       private Passenger cesar;

       @BeforeEach
       void setUp() {
           premiumFlight = new PremiumFlight("3");
           jessica = new Passenger("Jessica", false);
           cesar = new Passenger("Cesar", true);
       }

       @Nested
       @DisplayName("Cuando tenemos un pasajero regular")
       class RegularPassenger {

           @Test
           @DisplayName("Entonces no puede agregarlo o eliminarlo de un vuelo de premium")
           public void testBusinessFlightRegularPassenger() {
               assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de premium",
                       () -> assertEquals(false, premiumFlight.addPassenger(jessica)),
                       () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
                       () -> assertEquals(false, premiumFlight.removePassenger(jessica)),
                       () -> assertEquals(0, premiumFlight.getPassengersSet().size())
               );
           }
       }

       @Nested
       @DisplayName("Cuando tenemos un pasajero VIP")
       class VipPassenger {

           @Test
           @DisplayName("Luego puedes agregarlo y puedes eliminarlo de un vuelo premium")
           public void testBusinessFlightVipPassenger() {
               assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                       () -> assertEquals(true, premiumFlight.addPassenger(cesar)),
                       () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                       () -> assertEquals(true, premiumFlight.removePassenger(cesar)),
                       () -> assertEquals(0, premiumFlight.getPassengersSet().size())
               );
           }
       }
   }


}

