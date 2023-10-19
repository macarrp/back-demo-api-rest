package com.marcebits.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/net")
public class NetController {

	@GetMapping("/")
	public String getCosas(HttpServletRequest request) {
		try {
			InetAddress[] ips = InetAddress.getAllByName("www.google.es");
			for(InetAddress ip : ips) {
				log.info("INFO GOOGLE - " + ip.getHostAddress());				
			}
			
			InetAddress[] ips2 = InetAddress.getAllByName("desaplicaciones.aragon.es");
			for(InetAddress ip : ips2) {
				log.info("INFO DES - " + ip.getHostAddress());				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String getRemoteAddr = request.getRemoteAddr();
		log.info("getLocalAddr " + getRemoteAddr);
		log.info("a " + request.getServerName());
		log.info("b " + request.getHeaderNames());
		
		InetAddress remote = null;
		try {
			remote = InetAddress.getByName(getRemoteAddr);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("remote" + remote);
		
		return getRemoteAddr;
	}
}
