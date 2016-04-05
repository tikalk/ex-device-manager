package com.tikal.fleettracker.devicemanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.cyngn.kafka.MessageProducer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerRequest;

public class HttpGpsGatewayVerticle extends AbstractVerticle {
	private final SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");

	private boolean createReceptionTime;

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(HttpGpsGatewayVerticle.class);

	@Override
	public void start() {
		logger.info("Started HTTP Server on port {} to listen for GPS", config().getInteger("http-port"));
	}
}
