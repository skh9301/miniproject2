package com.miniproject2.study.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

// 남은 날짜와 시간 계산 참고용 클래스
public class TimeCounter01 {

	public static void main(String[] args) {		
		// html : datetime-local, 자바 : LocalDateTime, MySQL : datetime		
		// LocalDateTime 남은시간 초 계산
		// input type="datetime-local" 을 문자열로 받으면 다음과 같음		
		LocalDateTime startDt = LocalDateTime.parse("2024-05-28T11:19");
		LocalDateTime endDt = LocalDateTime.parse("2024-05-29T10:55");
		LocalDateTime currDt = LocalDateTime.now();
		System.out.println(currDt);
		// 시작 시간과 종료일 사이의 초 계산
		long seconds = currDt.until(endDt, ChronoUnit.SECONDS);		
		
		// 남은 날짜를 계산하고 날짜 계산한 만큼 차감 
		long days = seconds / 24 / 60 / 60;
		seconds = seconds - days * 24 * 60 * 60;
		
		// 남은 시간을 계산하고 시간 계산한 만큼 차감
		long hours = seconds / 60 / 60;
		seconds = seconds - hours * 60 * 60;
		
		// 남은 분을 계산하고 분 계산한 만큼 차감 
		long minutes = seconds / 60;
		seconds = seconds - minutes * 60;
		
		// 경매 종료까지 남은 날짜와 시간 출력
		System.out.printf("%d일 %d시간 %d분 %d초 남음\n", 
					days, hours, minutes, seconds);
		
		// 경매 시작 전이면 경매 시작시간 표시
		// 경매가 시작되었으면 종료까지 남은 시간 표시
		// 경매 시작 전 여부 started=true, 경매 종료여부 finished=true
		boolean started = currDt.isAfter(startDt);
		System.out.println("경매 시작 여부 : " + started);
		
		boolean finished = currDt.isAfter(endDt);
		System.out.println("경매 종료 여부 : " + finished);
	}
}		