package com.assistantteacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/timetable")
public class TimetableController {
	@RequestMapping(value="/showTimetable.htm")
	public String showTimeTable(Model model){
		return "showTimetable";
	}
		@RequestMapping(value="/showWebsite.htm")
		public String showWebsite(Model model){
			return "showWebsite";
}
		@RequestMapping(value="/firstYear.htm")
		public String firstyear(Model model){
			return "fTimetable";
}
}
