###
# vert.x docker device-manager using a Java verticle packaged as a fatjar
# To build:
#  docker build -t fleettracker/as-device-manager .
# To run:
#   docker run -t -i -p 8080:8080 fleettracker/as-device-manager
###

FROM java:8

EXPOSE 4080
# Copy your fat jar to the container
ADD build/distributions/as-device-manager-3.1.0.tar.gz /as-device-manager

# Launch the verticle
ENV WORKDIR /as-device-manager/run-bin
ENTRYPOINT ["sh", "-c"]
CMD ["cd $WORKDIR ; ./device-manager.sh"]
