import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Date;

public class Main
{
    public static void main(String[] args) {

        long hourInMilliseconds = (long)(60*60*1000);
        Date currentDate = new Date();
        Date newDate = new Date(currentDate.getTime() + (long)(2.5*hourInMilliseconds)); //устанавливаем время +2.5 часа

        Airport airport = Airport.getInstance();
        airport.getTerminals().stream()//получаем список терминалов и преобразуем в поток
                .flatMap(x -> x.getFlights().stream()) // у каждого терминала получаем полеты и преобразуем в поток
                .filter(x -> x.getType().equals(Flight.Type.DEPARTURE)) // фильтруем по вылету
                .filter(x -> x.getDate().after(currentDate) && x.getDate().before(newDate)) // фильтруем по дате
                .forEach(System.out::println); // печатаем

    }



}
