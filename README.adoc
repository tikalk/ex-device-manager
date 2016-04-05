# FleetTracker Device Manager

This micro service is responsible for accepting raw-gps lines (HTTP or Socket), and transmit them to Kafka raw-gps topic.
It is based  on Vert.x 3

## How to build
_______________
From the project home folder run the following command:

./gradlew clean shadowJar zipAll

This will create self contained zip, that you can unzip on host container. The output zip is located at
as-device-manager/build/distributions/as-device-manager-3.1.0.tar.gz

## How to run
--------------

Unzip the file as-device-manager/build/distributions/as-device-manager-3.1.0.tar.gz
cd to the created folder (as-device-manager-3.1.0)
Run the following command : 
./device-manager.sh

## What to code
----------------
You should code which create a device-manager code, which get the payload and adds two fields:id and receptionTime. This means that you should get the String and concat two fields to it as follow:

<GPS>,<RECEPTION-TIME>,<ID>

The RECEPTION-TIME is the 'current-date' formatted as yyMMddHHmmss
The ID is some GUID you should generate and concat at the end.

The created GPS record is sent via Kafka to the GPS Service to the raw-gps topic.



 

