package hd.josh.daily.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import hd.josh.daily.R;

/**
 * Created by Josh HD on 9/20/2016.
 */

public class Tools {
    private static SimpleDateFormat dfDay = new SimpleDateFormat("EEEE, MMMM d");
    private static SimpleDateFormat dfYear = new SimpleDateFormat("YYYY");
    private static SimpleDateFormat dfTime = new SimpleDateFormat("h:mm a");

    public static String getDay(Date date) {
        return dfDay.format(date);
    }

    public static String getYear(Date date) {
        return dfYear.format(date);
    }

    public static String getTime(Date date) {
        return dfTime.format(date);
    }

    public int getIcon(int weatherCode) {
        int iconRes = R.drawable.ic_weather_sunny;
        int digit1 = Integer.parseInt(Integer.toString(weatherCode).substring(0, 1));

        switch (digit1) {
            case 2:
                switch (weatherCode) {
                    case 200:
                    case 201:
                    case 202:
                    case 230:
                    case 231:
                    case 232:
                        iconRes = R.drawable.ic_weather_lightning_rainy;
                        break;
                    case 210:
                    case 211:
                    case 212:
                    case 221:
                        iconRes = R.drawable.ic_weather_lightning;
                        break;
                }
                break;

            case 3:
                iconRes = R.drawable.ic_weather_pouring;
                break;

            case 5:
                switch (weatherCode) {
                    case 511:
                    case 520:
                    case 521:
                    case 522:
                    case 531:
                        iconRes = R.drawable.ic_weather_pouring;
                        break;
                    case 500:
                    case 501:
                    case 502:
                    case 503:
                    case 504:
                        iconRes = R.drawable.ic_weather_rainy;
                        break;
                }
                break;

            case 6:
                switch (weatherCode) {
                    case 600:
                    case 601:
                    case 602:
                        iconRes = R.drawable.ic_weather_snowy;
                        break;
                    case 611:
                    case 612:
                    case 615:
                    case 616:
                    case 620:
                    case 621:
                    case 622:
                        iconRes = R.drawable.ic_weather_snowy_rainy;
                        break;
                }
                break;

            case 7:
                iconRes = R.drawable.ic_weather_fog;
                break;

            case 8:
                switch (weatherCode) {
                    case 800:
                        iconRes = R.drawable.ic_weather_sunny;
                        break;
                    case 801:
                        iconRes = R.drawable.ic_weather_partlycloudy
                        break;
                    case 802:
                    case 803:
                    case 804:
                        iconRes = R.drawable.ic_weather_cloudy;
                        break;
                }
                break;

            case 9:
                switch (weatherCode) {
                    case 900:
                    case 901:
                    case 902:
                    case 903:
                    case 904:
                    case 905:
                        iconRes = R.drawable.ic_weather_windy;
                        break;
                    case 906:
                        iconRes = R.drawable.ic_weather_hail;
                        break;
                    default:
                        iconRes = R.drawable.ic_weather_windy_variant;
                        break;
                }
            default:
                iconRes = R.drawable.ic_weather_sunny;
                break;
        }


        return iconRes;
    }
}
