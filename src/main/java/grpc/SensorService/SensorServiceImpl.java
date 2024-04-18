package grpc.SensorService;

import io.grpc.stub.StreamObserver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SensorServiceImpl extends SensorServiceGrpc.SensorServiceImplBase {

    private static final List<SensorData> SENSOR_DATA = new CopyOnWriteArrayList<>();

    static {
        try (Reader reader = new FileReader("../files/sensor.csv");
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                int farmId = Integer.parseInt(csvRecord.get("farm_id"));
                int sensorId = Integer.parseInt(csvRecord.get("sensor_id"));
                String district = csvRecord.get("district");
                double temperature = Double.parseDouble(csvRecord.get("temperature"));
                double illumination = Double.parseDouble(csvRecord.get("illumination"));
                double humidity = Double.parseDouble(csvRecord.get("humidity"));

                SENSOR_DATA.add(new SensorData(farmId, sensorId, district, temperature, humidity, illumination));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void streamSensorData(SensorRequest request, StreamObserver<SensorResponse> responseObserver) {
        int farmId = request.getFarmid();
        int sensorId = request.getSensorid();

        Runnable streamingTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    SensorData sensorData = getSensorData(farmId, sensorId);

                    if (sensorData != null) {
                        SensorResponse response = SensorResponse.newBuilder()
                                .setTempreture(sensorData.getTemperature())
                                .setHumidity(sensorData.getHumidity())
                                .setDistrict(sensorData.getDistrict())
                                .setIllumination(sensorData.getIllumination())
                                .build();

                        responseObserver.onNext(response);
                    }

                    Thread.sleep(15000); // Stream every 5 seconds
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                responseObserver.onCompleted();
            }
        };

        new Thread(streamingTask).start();
    }

    private SensorData getSensorData(int farmId, int sensorId) {
        for (SensorData data : SENSOR_DATA) {
            if (data.getFarmId() == farmId && data.getSensorId() == sensorId) {
                return data;
            }
        }

        return null;
    }

    private static class SensorData {
        private final int farmId;
        private final int sensorId;
        private final String district;
        private final double temperature;
        private final double humidity;
        private final double illumination;

        public SensorData(int farmId, int sensorId, String district, double temperature, double humidity, double illumination) {
            this.farmId = farmId;
            this.sensorId = sensorId;
            this.district = district;
            this.temperature = temperature;
            this.humidity = humidity;
            this.illumination = illumination;
        }

        public int getFarmId() {
            return farmId;
        }

        public int getSensorId() {
            return sensorId;
        }

        public String getDistrict() { // Add getter method for district field
            return district;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getIllumination() {
            return illumination;
        }
    }
}
