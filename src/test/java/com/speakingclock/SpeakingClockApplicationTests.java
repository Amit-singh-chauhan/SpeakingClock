package com.speakingclock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeakingClockApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testValidTime() {
		String expected = "It's two forty five";
		String actual = UserInputTimeConversion("02:45");
		assertEquals(expected, actual);
	}

	@Test
	public void testInvalidHour() {
		assertThrows(IllegalArgumentException.class, () -> UserInputTimeConversion("24:00"));
	}

	@Test
	public void testInvalidMinute() {
		assertThrows(IllegalArgumentException.class, () -> UserInputTimeConversion("12:60"));
	}

	@Test
	public void testMidnight() {
		String expected = "It's Midnight";
		String actual = UserInputTimeConversion("00:00");
		assertEquals(expected, actual);
	}

	@Test
	public void testMidday() {
		String expected = "It's Midday";
		String actual = UserInputTimeConversion("12:00");
		assertEquals(expected, actual);
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
