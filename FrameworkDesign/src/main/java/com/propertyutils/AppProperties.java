package com.propertyutils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

	@Value(("${browser}"))
	private String browser;
	@Value(("${username123}"))
	private String username123;
	@Value(("${password}"))
	private String password;
	@Value(("${url}"))
	private String url;

	public String getBrowser() {
	return browser;
	}

	public String getUsername123() {
	return username123;
	}

	public String getPassword() {
	return password;
	}
	public String getUrl() {
	return url;
	}


	@Override
	public String toString() {
	return "AppProperties{" +
	"browser=" + browser +
	", username123='" + username123 + '\'' +
	", password='" + password + '\'' +
	", url='" + url + '\'' +
	'}';
	}
}
