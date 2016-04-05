package com.tikal.fleettracker.devicemanager;

import com.cyngn.kafka.MessageProducer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;

public class DeviceManagerVerticle extends AbstractVerticle {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DeviceManagerVerticle.class);

	@Override
	public void start() {
		vertx.deployVerticle(MessageProducer.class.getName(),new DeploymentOptions().setConfig(config()));
		vertx.deployVerticle(new HttpGpsGatewayVerticle(),new DeploymentOptions().setConfig(config()));
		vertx.deployVerticle(new NetServerGpsGatewayVerticle(),new DeploymentOptions().setConfig(config()));
		
		
		logger.info("Started listening to EventBus for GPS");
	}
	

}
