package com.speakingclock.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class TimeConversionService {

	public String LocalSystemTimeConversion() {
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
		String time = currentTime.format(formatter);
		return new String(UserInputTimeConversion(time));

	}

	public String UserInputTimeConversion(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3));
		if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
			throw new IllegalArgumentException("Invalid time format");
		}

		if (hour == 0 && minute == 0) {
			return "It's Midnight";
		}

		if (hour == 12 && minute == 0) {
			return "It's Midday";
		}

		String[] numbers = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] tens = { "", "", "twenty", "thirty", "forty", "fifty" };

		String hourWord = "";
		if (hour < 20) {
			hourWord = numbers[hour];
		} else {
			hourWord = tens[hour / 10] + " " + numbers[hour % 10];
		}

		String minuteWord = "";
		if (minute < 20) {
			minuteWord = numbers[minute];
		} else {
			minuteWord = tens[minute / 10] + " " + numbers[minute % 10];
		}

		String words = "It's " + hourWord + " " + minuteWord;
		return words;
	}

}
