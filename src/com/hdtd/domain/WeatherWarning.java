package com.hdtd.domain;

import javax.persistence.Column;

import com.hdtd.domain2.BasePojoTwo;

public class WeatherWarning extends BasePojoTwo {
	@Column(name="ReprtContent")
	private String ReportContent;

	public String getReportContent() {
		return ReportContent;
	}

	public void setReportContent(String reportContent) {
		ReportContent = reportContent;
	}

	@Override
	public String toString() {
		return "WeatherWarning [ReportContent=" + ReportContent + "]";
	}
	

}
