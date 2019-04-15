# Build
mvn clean package && docker build -t it.ciacformazione/baruzziProject .

# RUN

docker rm -f baruzziProject || true && docker run -d -p 8080:8080 -p 4848:4848 --name baruzziProject it.ciacformazione/baruzziProject 