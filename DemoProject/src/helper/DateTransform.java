package helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTransform {
	public static String dateFormat(String d) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(d, inputFormatter);
		String formattedDate = outputFormatter.format(date);
		return formattedDate;
	}
}
